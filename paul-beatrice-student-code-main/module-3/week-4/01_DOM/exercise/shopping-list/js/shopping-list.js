// add pageTitle

const groceryList = document.getElementById('groceries');

let pageTitle = 'My Shopping List';
let groceries = [
  'Apples',
  'Bananas',
  'Butter',
  'Milk',
  'Coffee',
  'Lettuce',
  'Cheese',
  'Eggs',
  'Bread',
  'Chicken'
];

// add groceries

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const titleElement = document.getElementById('title');
  titleElement.textContent = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  groceries.forEach(item => {
    const li = document.createElement('li');
    li.textContent = item;
    groceryList.appendChild(li);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const items = document.querySelectorAll('#groceries li');
  items.forEach(item => {
    item.classList.add('completed');
  })
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
