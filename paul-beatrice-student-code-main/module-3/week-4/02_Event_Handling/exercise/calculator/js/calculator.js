let display = document.getElementById('display');
let previous = null;
let operator = null;
let operatorClicked = false;

/**
 * Calculates the operation and updates the display.
 */
function performOperation() {
  let result;
  const current = parseNumber(display.value);
  previous = parseNumber(previous);

  switch(operator) {
    case '+' :
      result = previous + current;
    break;
    case '-' :
        result = previous - current;
    break;
    case '*' :
        result = previous * current;
    break;
    case '/' :
        result = previous / current;
    break;
  }

  display.value = result;
  operator = null;
}

/**
 * Parses the display value into a number (float or int).
 * @param {String} num 
 */
function parseNumber(num) {
  return num.includes('.') ? parseFloat(num) : parseInt(num);
}

/**
 * Capture the previous value and the clicked operator
 * so that an operation can be performed.
 */
function clickOperator(event) {
  operator = event.target.value;
  previous = display.value;
  operatorClicked = true;
}

/**
 * Captures a number click and updates the display value.
 * @param {Event} event 
 */
function clickNumber(event) {
  const val = event.target.value;

  if( operatorClicked ) {
    display.value = val;
    operatorClicked = false;
  } else {
    display.value == 0 ? display.value = val : display.value += val;
  }

}

/**
 * Resets the display value.
 */
function clear() {
  display.value = 0;
}

// add event listener for when the DOM is loaded
document.addEventListener('DOMContentLoaded', () => {

  // set the variable called display declared at the top of this file equal to the display element
  // HINT: use its id #display to get a reference to it

  display = document.getElementById('display');
  // get a reference to all of the numbers
  // loop over each of the numbers
  // add a click event listener to each number to call the function clickNumber

  const numbers = document.querySelectorAll('.number');
  numbers.forEach(button => {
    button.addEventListener('click', clickNumber);
  });

  // get a reference to the decimal point button
  // add a click event listener to call the function clickNumber
  // the decimal point is part of the number so you can call clickNumber for it 
  // as you would for a number

  const decimal = document.querySelector('.decimal');
  decimal.addEventListener('click', clickNumber);

  // get a reference to the all clear button
  // add a click event listener to call the function clear  

  const clearButton = document.querySelector('.all-clear');
  clearButton.addEventListener('click', clear );

  // get a reference to all of the operators;
  // loop over each of the operators
  // add a click event listener to each operator to call the function clickOperator

  const operators = document.querySelectorAll('.operator');
  operators.forEach(button => {
    button.addEventListener('click', clickOperator);
  })

  // add click event listener for the equal sign
  // should call the function performOperation

  const equals = document.querySelector('.equal-sign');
  equals.addEventListener('click', performOperation);

});

