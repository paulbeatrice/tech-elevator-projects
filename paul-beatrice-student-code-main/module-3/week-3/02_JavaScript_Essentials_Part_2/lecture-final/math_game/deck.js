// Define the suits and ranks for the cards
const suits = ['Hearts', 'Diamonds', 'Clubs', 'Spades'];
const ranks = ['Ace', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'Jack', 'Queen', 'King'];

// Card object constructor function
function Card(suit, rank) {
	this.suit = suit;
	this.rank = rank;
	Object.freeze(this);
}

// Method to represent the card as a string
Card.prototype.toString = function() {
	return `${this.rank} of ${this.suit}`;
};

// Deck object constructor function
function Deck() {
	this.cards = [];
	for (const suit of suits) {
		for (const rank of ranks) {
			this.cards.push(new Card(suit, rank));
		}
	}
	Object.freeze(this);
}

// Method to shuffle the deck
Deck.prototype.shuffle = function() {
	for (let i = this.cards.length - 1; i > 0; i--) {
		const j = Math.floor(Math.random() * (i + 1));
		[this.cards[i], this.cards[j]] = [this.cards[j], this.cards[i]];
	}
};

// Method to draw a card from the deck
Deck.prototype.draw = function() {
  return this.cards.shift();
};

// Method to draw multiple cards from the deck
Deck.prototype.drawMultiple = function(count) {
  return this.cards.splice(0, count);
};

// Method to count remaining cards
Deck.prototype.count = function() {
  return this.cards.length;
};


// Exporting Card and Deck
export { Card, Deck };
