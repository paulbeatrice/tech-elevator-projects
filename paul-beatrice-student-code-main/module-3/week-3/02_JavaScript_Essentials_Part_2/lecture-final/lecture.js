/***********************************************
 * Objects, constructor functions, and methods
 ***********************************************
 */

// Playing card objects using object literals
const queenOfHearts = {
  suit: 'Hearts',
  rank: 'Queen'
};

const kingOfSpades = {
  suit: 'Spades',
  rank: 'King'
};

/*
 * Object literals are fine for one or two objects, but can get tedious for many.
 * Constructor functions simplify creating multiple objects with the same properties.
 */

// Card object constructor function
function Card(suit, rank) {
  this.suit = suit;
  this.rank = rank;
  Object.freeze(this);  // freezing the object prevents changes to its property values
}

// Create cards with keyword the Card constructor function
const aceOfDiamonds = new Card('Diamonds', 'Ace');
const sevenOfClubs = new Card('Clubs', '7');
const tenOfSpades = new Card('Spades', '10');

// Method to represent the card as a string
Card.prototype.toString = function() {
  return `${this.rank} of ${this.suit}`;
};

// Shared properties can also go on the object prototype
Card.prototype.cardBack = 'cardBack.jpg';

// Compare a card literal to a card from the constructor function
console.log('Card created as object literal:', queenOfHearts);
console.log('Card from constructor function:', aceOfDiamonds);

// Deck object constructor function
function Deck() {

  // Array to hold the cards in the deck
  this.cards = [];

  // Define the suits and values for the cards
  const suits = ['Hearts', 'Diamonds', 'Clubs', 'Spades'];
  const values = ['Ace', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'Jack', 'Queen', 'King'];

  // Initialize the deck with all 52 cards
  for (const suit of suits) {
    for (const value of values) {
        this.cards.push(new Card(suit, value));
    }
  }
	Object.freeze(this);
}

// Add a method to shuffle the deck
Deck.prototype.shuffle = function() {
  for (let i = this.cards.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [this.cards[i], this.cards[j]] = [this.cards[j], this.cards[i]];
  }
};

// Create a new deck and shuffle it
const deck = new Deck();
deck.shuffle();

console.log('Shuffled cards:');
for (const card of deck.cards) {
  console.log(card);
}
console.log();


/**********************************************
 * Destructuring assignment and spread syntax
 **********************************************
 */

// Get the cards array from the deck object using destructuring assignment
const { cards } = deck;

// This is often used to get the properties of an object in a function parameter
function drawCard( { cards } ){
  return cards.pop();
}

const myCard = drawCard(deck);
console.log(myCard);

// Get the first card from the array of cards using destructuring assignment
const [firstCard] = cards;
console.log('First card:', firstCard.toString());

// If needed, you can skip elements
const [ , secondCard, , fourthCard] = cards;
console.log('Second card:', secondCard.toString());
console.log('Fourth card:', fourthCard.toString());

// Use the spread syntax to create a new array with the remaining cards
const [ , , ...remainingCards] = cards;

// This can also be used to combine values into a new array
const newDeck = [...remainingCards, firstCard];

// It also works with objects
// Create a copy of the first card with a new color property
const cardWithColor = {
  ...firstCard,
  color: firstCard.suit === 'Hearts' || firstCard.suit === 'Diamonds' ? 'red' : 'black'
};


/*****************************************************
 * Functions, function expressions, and arrow syntax
 *****************************************************
 */

// Declared function to log the cards in an array
function logCards(cardArray) {
  for (const card of cardArray) {
    console.log(card);
  }
}

// Log the cards in the deck
console.log('\nCards in deck:');
logCards(deck.cards);
console.log(); // Add a blank line

// Functions can be assigned to variables like any other value
let displayCards = logCards;

// You can then call the function with the variable name
displayCards(deck.cards);
console.log();

// Change the behavior to list the cards with their position in the array
displayCards = function(cardArray) {
  for (let i = 0; i < cardArray.length; i++) {
    console.log(`Card ${i + 1}: ${cardArray[i].toString()}`);
  }
}

// Display the cards again
displayCards(deck.cards);
console.log();

// Use an arrow function to define the function in a more concise way (same behavior as above)
displayCards = cardArray => {
  for (let i = 0; i < cardArray.length; i++) {
    console.log(`Card ${i + 1}: ${cardArray[i].toString()}`);
  }
}

displayCards(deck.cards);
console.log();

/**********************
 * Callback functions
 **********************
 */

// Function to display some cards, uses a callback function to format the output
function displayObjects(objectArray, objectFormatFn) {
  for (const object of objectArray) {
    if (objectFormatFn) {
      console.log(objectFormatFn(object));
    } else {
      console.log(object.toString());
    }
  }
}

// Display the first 5 cards from the deck using a callback function
const hand = deck.cards.splice(0, 5);
displayObjects(hand, card => `Card: ${card.rank} of ${card.suit}`);
console.log();

// Display the first 5 cards from the deck using the default behavior (no callback)
displayObjects(hand);
console.log();

// Display some pet objects
const pets = [
  { name: 'Fluffy', species: 'cat', age: 3 },
  { name: 'Fido', species: 'dog', age: 5 },
  { name: 'Goldie', species: 'fish', age: 1 }
];
displayObjects(pets, pet => `${pet.name} is a ${pet.age} year old ${pet.species}.`);
console.log();


/*******************************************
 * Array methods with synchronous callbacks
 *******************************************
 */

// Display the hand from earlier
console.log('Hand of cards:');
displayCards(hand);
console.log();

// Check if all cards are Diamonds
// every() returns true if all elements pass the test
const allDiamonds = hand.every(card => card.suit === 'Diamonds');
console.log(allDiamonds ? 'All cards are Diamonds.' : 'Not all cards are Diamonds.');
console.log();

// Filter out any 8's
// filter() returns a new array with elements that pass the test
const eights = deck.cards.filter(card => card.rank === '8');
console.log(eights.length ? `Found ${eights.length} eights.` : 'No eights found.');

// Find a specific card in the deck, returns undefined if not found
const aceOfSpades = deck.cards.find(card => card.suit === 'Spades' && card.rank === 'Ace');
console.log(aceOfSpades);

// Find the index of a specific card in the deck, returns -1 if not found
const cardIndex = deck.cards.findIndex(card => card.suit === 'Spades' && card.rank === 'Ace');
console.log(`The card is located at index ${cardIndex}.`);

// forEach() is used to iterate over and perform an action on each element.
// It can sometimes be used to replace a for...of loop. However, it can't return a value.
console.log('\nDisplaying the hand using forEach():');
displayCards = cardArray => {
    cardArray.forEach(card => console.log(`Card: ${card.toString()}`));
}
displayCards(hand);
console.log();

// Map the hand to fancy cards with extra properties for fancy display in the console
// Since the cards are frozen, create a new object with the same properties plus the new ones
const ANSI_BLACK = '\u001B[30m';
const ANSI_RED = '\u001B[31m';
const ANSI_RESET = '\u001B[0m';

const fancyHand = hand.map(card => {
    let color = card.suit === 'Hearts' || card.suit === 'Diamonds' ? ANSI_RED : ANSI_BLACK;
    let symbol = card.suit === 'Hearts' ? '♥' : card.suit === 'Diamonds' ? '♦' : card.suit === 'Clubs' ? '♣' : '♠';
    return { ...card, color, symbol };
});

console.log('The cards are:')
fancyHand.forEach(card => console.log(`${card.color} ${card.rank} ${card.symbol} ${ANSI_RESET}(${card.rank} of ${card.suit})`));
console.log();

// Get a value for a hand by summing all the card values
// Write a helper function to determine the card value
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
// Then use reduce() to sum the values
const sum = hand.reduce((total, card) => total + getCardValue(card), 0);
console.log(`The hand has a total value of ${sum}.`);
console.log();

// Sort the cards by their value
hand.sort((a, b) => getCardValue(b) - getCardValue(a));
console.log('Cards sorted by rank:');
hand.forEach(card => console.log(`The ${card.rank} of ${card.suit} has the value ${getCardValue(card)}.`));
console.log();

// Sort the cards by suit (alphabetically) then value
hand.sort((a, b) => {
  if (a.suit === b.suit) {
    return getCardValue(b) - getCardValue(a);
  } else if (a.suit > b.suit) {
    return 1;
  } else {
    return -1;
  }
});
console.log('Cards sorted by suit then rank:');
hand.forEach(card => console.log(`The ${card.rank} of ${card.suit} has the value ${getCardValue(card)}.`));
console.log();


/**************************
 * Asynchronous callbacks
 **************************
 */

// console.log('Calling setTimeout() the first time.');
// setTimeout(() => {
//   console.log('Running first setTimeout() callback.');
// }, 5000);

// console.log('Calling setTimeout() the second time.');
// setTimeout(() => {
//   console.log('Running second setTimeout() callback.');
// }, 3000);

// console.log('Calling setTimeout() the third time.');
// setTimeout(() => {
//   console.log('Running third setTimeout() callback.');
// }, 1000);
// console.log();

// Every second, print 'Hello'
const intervalId = setInterval(() => {
  console.log('Hello');
}, 1000);

// Use setTimeout to wait 5 seconds then stop this behavior
setTimeout(() => {
  clearInterval(intervalId);
  console.log("Stop saying 'Hello'.");
}, 5000);

