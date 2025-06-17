import readLineSync from 'readline-sync';
import { Deck } from './deck.js';

/*
 * The MathGame represents a simple math game that uses a deck of cards to generate math problems.
 *
 * The cards get a numeric values based on their rank, with Jacks having a value of 11,
 * Queens are 12, Kings are 13, and Aces are 1
 *
 * For each round of the game, the player draws two cards, then performs a math operation on them:
 *
 *   - If both cards are red - multiply the two values
 *   - If both cards are black - subtract the lower value from the higher value
 *   - If one is red and one is black - add the two values
 *
 * Each correct answer earns 5 points, but an incorrect answer loses 2 points. The game continues
 * until there are no more cards in the deck. The player's final score displays at the end.
 */
function MathGame() {

  // Create a new deck and shuffle it
  this.deck = new Deck();
  this.deck.shuffle();

  // Start the player score at 0
  this.score = 0;
}

// Add a playGame method to the MathGame prototype
MathGame.prototype.playGame = function() {

  // Loop through the deck until there are no more cards
  while (this.deck.count() > 0) {

    // Draw two cards
    const cards = drawTwoCards(this.deck);
    console.log(`You drew the ${cardToString(cards[0])} and the ${cardToString(cards[1])}.\n`);

    // Generate the math problem prompt from the cards
    const problem = generateProblem(cards);

    // Prompt the user for an answer
    const answer = readLineSync.question(problem.prompt);

    // Check if the answer is correct and update the score
    if (parseInt(answer) === problem.answer) {
      console.log("Correct! You get 5 points!\n");
      this.score += 5;
    } else {
      console.log(`Sorry, the correct answer was ${problem.answer}. You lose 2 points.\n`);
      this.score -= 2;
    }
  }

  // Display the final score
  console.log(`Game over! Your final score is ${this.score}.\n`);
}

// Function to draw two cards with additional properties for color and numeric value
function drawTwoCards(deck) {
  // Draw two cards from the deck
  const cards = deck.drawMultiple(2);

  // Create new cards with additional properties for color and numeric value
  const updatedCards = cards.map(card => {
    let color = card.suit === 'Hearts' || card.suit === 'Diamonds' ? 'red' : 'black';
    let value = getCardValue(card);
    return { ...card, color, value };
  });

  return updatedCards;
}

// Function to get the numeric value of a card
function getCardValue(card) {
	switch (card.rank) {
    case 'Jack':
      return 11;
    case 'Queen':
      return 12;
    case 'King':
      return 13;
    case 'Ace':
      return 1;
    default:
      return parseInt(card.rank);
	}
}

// Function to convert card to string
function cardToString(card) {
  return `${card.color} ${card.rank} of ${card.suit}`;
}

// Function to generate a math problem based on the cards
function generateProblem(cards) {

  const problem = {};
  const [card1, card2] = cards;

  // Prompt for the math problem
  if (card1.color === "red" && card2.color === "red") {

    // Colors are the same, do multiplication
    problem.prompt = `What is ${card1.value} x ${card2.value}?\n`;
    problem.answer = card1.value * card2.value;

  } else if (card1.color === "black" && card2.color === "black") {

    // Both black, do subtraction
    // Determine the higher and lower values from the cards
    // let higherValue, lowerValue;
    // if (card1.value > card2.value) {
    //   higherValue = card1.value;
    //   lowerValue = card2.value;
    // } else {
    //   higherValue = card2.value;
    //   lowerValue = card1.value;
    // }
    let [higherValue, lowerValue] = card1.value > card2.value ? [card1.value, card2.value] : [card2.value, card1.value];

    // Subtract the lower value from the higher value
    problem.prompt = `What is ${higherValue} - ${lowerValue}?\n`;
    problem.answer = higherValue - lowerValue;

  } else {

    // One red and one black, do addition
    problem.prompt = `What is ${card1.value} + ${card2.value}?\n`;
    problem.answer = card1.value + card2.value;

  }

  return problem;
}

export { MathGame };