// ========== DOM ELEMENTS ================= //
const hitBtn = document.getElementById("hit-btn");
const dealBtn= document.getElementById("deal-btn");
const standBtn = document.getElementById("stand-btn");
const splitBtn = document.getElementById("split-btn");
const restartBtn = document.getElementById("restart-btn");
const rulesBtn = document.getElementById("rules-btn");
const rulesBox = document.getElementById("rules");

const dealerCards = document.getElementById("dealer-cards");
const playerCards = document.getElementById("player-cards");
const dealerTotalDisplay = document.getElementById("dealer-total");
const playerTotalDisplay = document.getElementById("player-total");

const chipValue = document.getElementById("chip-value");
const currentBet = document.getElementById("current-bet");
const winCounter = document.getElementById("wins");
const lossCounter = document.getElementById("losses");

const chipButtons = document.querySelectorAll(".chip");


// ============= GAME STATS ================== //

let deck = [];
let playerHand = [];
let playerHand2 = [];
let dealerHand = [];
let playerTotal = 0;
let playerTotal2 = 0;
let dealerTotal = 0;
let chips = 1000;
let bet = 0;
let wins = 0;
let losses = 0;
let gameActive = false;
let splitActive = false;
let currentHand = 1;

// ============= Shuffle Feature ================== //
function shuffle(array) {
    for (let i = array.length -1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
}


// ============= Create & Shuffle Multi-Deck ================== //
function createDeck() {
    const suits = ["hearts", "diamonds", "clubs", "spades"];
    const values = [
        {label: "A", points: 11 },
        {label: "2", points: 2 },
        {label: "3", points: 3 },
        {label: "4", points: 4 },
        {label: "5", points: 5 },
        {label: "6", points: 6 },
        {label: "7", points: 7 },
        {label: "8", points: 8 },
        {label: "9", points: 9 },
        {label: "10", points: 10 },
        {label: "J", points: 10 },
        {label: "Q", points: 10 },
        {label: "K", points: 10 }
    ];

    const numberOfDecks = 6;
    let newDeck = [];

    Array(numberOfDecks).fill().forEach(() => {
        suits.forEach(suit => {
            values.forEach(value => {
                newDeck.push({ suit, value: value.label, points: value.points });
            });
        });
    });

    return shuffle(newDeck);
}

// ============= Drawing Cards & Totals ================== //
function drawCard(hand) {
    const card = deck.pop();
    hand.push(card);
    return card;
}

function calculateTotal(hand) {
    let total = hand.reduce((sum, card) => sum + card.points, 0);
    let aces = hand.filter(c => c.value === "A").length;

    while (total > 21 && aces > 0) {
        total -= 10;
        aces--;
    }

    return total;
}

// ============= Render Card in DOM ================== //
function renderCard(card, container) {
    const div = document.createElement("div");
    div.classList.add("card");
    if(card.suit === "hearts" || card.suit === "diamonds") {
        div.classList.add("red");
    }
    div.textContent = `${card.value}`;
    container.appendChild(div);
}



// ============= Deal Initial Cards ================== //
function dealInitialCards() {
    deck = createDeck();
    playerHand = [];
    playerHand2 = [];
    dealerHand = [];
    dealerCards.innerHTML = "";
    playerCards.innerHTML = "";
    const splitDiv = document.getElementById("player-hand-2");
    if (splitDiv) splitDiv.remove();

    drawCard(playerHand);
    drawCard(playerHand);
    drawCard(dealerHand);

    playerHand.forEach(card => renderCard(card, playerCards));
    dealerHand.forEach(card => renderCard(card, dealerCards));

    playerTotal = calculateTotal(playerHand);
    playerTotalDisplay.textContent = playerTotal;
    dealerTotalDisplay.textContent = "?";
    gameActive = true;
    splitActive = false;
    currentHand = 1;
    dealBtn.disabled = true;
    highlightCurrentHand();
}

// ============= Player Actions ================== //
hitBtn.addEventListener("click", () => {
    if (!gameActive) return;

    if (!splitActive || currentHand === 1) {
    const card = drawCard(playerHand);
    renderCard(card, playerCards);
    playerTotal = calculateTotal(playerHand);
    } else {
        const card = drawCard (playerHand2);
        const splitDiv = document.getElementById("player-hand-2");
        renderCard(card, splitDiv);
        playerTotal2 = calculateTotal(playerHand2);
    }

    playerTotalDisplay.textContent = splitActive
        ? `${playerTotal} / ${playerTotal2}`
        : playerTotal;

        if (splitActive && currentHand === 1 && playerTotal > 21) {
            currentHand = 2;
        } else if (splitActive && currentHand === 2 && playerTotal2 > 21) {
            endSplitRound();
        } else if (!splitActive && playerTotal > 21) {
            endRound("lose");
        }
});

standBtn.addEventListener("click", () => {
    if (!gameActive) return;

    if (splitActive && currentHand === 1) {
        currentHand = 2;
        highlightCurrentHand();
        return;
    }

    while (calculateTotal(dealerHand) < 17) {
        const card = drawCard(dealerHand);
        renderCard(card, dealerCards);
    }

    dealerTotal = Math.floor(Math.random() * 6) + 16;
    dealerTotalDisplay.textContent = dealerTotal;

    if (splitActive) {
        endSplitRound();
    } else {
        endRound(compareHands());
    }
});

splitBtn.addEventListener("click", () => {
    if (!gameActive || playerHand.length !== 2) return;

    const [card1, card2] = playerHand;
    if (card1.value !== card2.value || chips < bet) {
        alert("You can only split identical cards and must have enough chips.");
        return;
    }

    playerHand = [card1];
    playerHand2 = [card2];
    chips -= bet;
    chipValue.textContent = chips;

    playerCards.innerHTML = "";
    renderCard(card1, playerCards);

    const splitDiv = document.createElement("div");
    splitDiv.id = "player-hand-2";
    splitDiv.classList.add("card-container");
    playerCards.parentNode.appendChild(splitDiv);
    renderCard(card2, splitDiv);

    drawCard(playerHand);
    drawCard(playerHand2);
    renderCard(playerHand[1], playerCards);
    renderCard(playerHand2[1], splitDiv);

    playerTotal = calculateTotal(playerHand);
    playerTotal2 = calculateTotal(playerHand2);
    playerTotalDisplay.textContent = `${playerTotal} / ${playerTotal2}`;

    splitActive = true;
    currentHand = 1;
    highlightCurrentHand();
})


// ============= Compare Results ================== //

function compareHands() {
    if (playerTotal > 21) return "lose";
    if (dealerTotal > 21) return "win";
    if (playerTotal > dealerTotal) return "win";
    if (playerTotal < dealerTotal) return "lose";
    return "tie";
}

function compareSplitHand(total) {
    if (total > 21) return "lose";
    if (dealerTotal > 21) return "win";
    if (total > dealerTotal) return "win";
    if (total < dealerTotal) return "lose";
    return "tie";
}

function endRound(result) {
    gameActive = false;
    dealBtn.disabled = false;

    if (result === "win") {
        chips += bet * 2;
        wins++;
        showOverlay("You Win!", "#00ff00");
    } else if (result === "lose") {
        losses++;
        showOverlay("You Lose!", "#ff3333");
    } else {
        chips += bet;
        showOverlay("Push! (Tie)", "#f0c000");
    }

    chipValue.textContent = chips;
    winCounter.textContent = wins;
    lossCounter.textContent = losses;
    currentBet.textContent = 0;
    bet = 0;
}

function endSplitRound() {
    gameActive = false;
    dealBtn.disabled = false;

    dealerTotal = Math.floor(Math.random() *6) + 16;
    dealerTotalDisplay.textContent = dealerTotal;

    const result1 = compareSplitHand(playerTotal);
    const result2 = compareSplitHand(playerTotal2);

    if (result1 === "win") chips += bet * 2;
    if (result2 === "win") chips += bet * 2;
    if (result1 === "tie") chips += bet;
    if (result2 === "tie") chips += bet;

    if (result1 === "win") wins++;
    if (result2 === "win") wins++;
    if (result1 === "lose") losses++;
    if (result2 === "lose") losses++;

    chipValue.textContent = chips;
    winCounter.textContent = wins;
    lossCounter.textContent = losses;
    currentBet.textContent = 0;
    bet = 0;

    showOverlay(`Hand 1: ${result1.toUpperCase()} | Hand 2: ${result2.toUpperCase()}`);
}

// ============= Overlay Display ================== //
function showOverlay(message, color = "#fff") {
    const overlay = document.getElementById("overlay");
    const overlayText = document.getElementById("overlay-text");
    overlayText.textContent = message;
    overlayText.style.color = color;
    overlay.classList.remove("hidden");

    setTimeout(() => {
        overlay.classList.add("hidden");
    }, 2000);

}


// ============= Betting System ================== //
chipButtons.forEach(button => {
    button.addEventListener("click", (e) => {
        const amount = parseInt(e.target.dataset.amount);
        if (amount <= chips && !gameActive) {
            bet += amount;
            chips -= amount;
            chipValue.textContent = chips;
            currentBet.textContent = bet;
        }
    });
});

// ================ UI Events ================== //
rulesBtn.addEventListener("click", () => {
    rulesBox.hidden = false;
});

rulesBtn.addEventListener("dblclick", () => {
    rulesBox.hidden = true;
});


// ================ DEAL BUTTON: START GAME ================== //

dealBtn.addEventListener("click", () => {
    if (!gameActive && bet > 0) {
        dealInitialCards();
    } else if (gameActive) {
        alert ("The game is already in progress!");
    } else {
        alert("Please place a bet before dealing.")
    }
});

restartBtn.addEventListener("click", () => {
    bet = 0;
    currentBet.textContent = 0;
    chipValue.textContent = chips;
    playerTotalDisplay.textContent = 0;
    dealerTotalDisplay.textContent = 0;
    playerCards.innerHTML = "";
    dealerCards.innerHTML = "";
    gameActive = false;
    dealBtn.disabled = false;
});

function highlightCurrentHand() {
    const hand1 = document.getElementById("player-cards");
    const hand2 = document.getElementById("player-hand-2");

    hand1.classList.remove("active-hand");
    if (hand2) hand2.classList.remove("active-hand");

    if (splitActive) {
        if (currentHand === 1) {
            hand1.classList.add("active-hand");
        } else if (currentHand === 2 && hand2)
            hand2.classList.add("active-hand");
    }
}








