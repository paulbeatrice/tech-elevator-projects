/* ***************************
 *  Variables and data types
 * ***************************
 */

// Use let for values that will change
// Use camelCase for variable names
let number = -21.5;
let firstName = 'Desi';

// Use const for values that should not change
// Use uppercase for constants
const PI = 3.14159;
const DAYS_PER_WEEK = 7;

// Variables are not typed, they can hold any value
let value = 10
console.log(`value starts at ${value} and its type is ${typeof value}.`);
value = 'Hello';
console.log(`value is changed to ${value} and its type is now ${typeof value}.`);
value = true;
console.log(`value is changed to ${value} and its type is now ${typeof value}.`);

// Variables that don't have a value are undefined
let noValue;
console.log(noValue);

// null also represents an empty value, but is explicitly assigned
value = null;
console.log(`value is changed again and is now ${value}.`);

//Objects literals are simple key-value pairs.
const person = {
  firstName: "Jo",
  lastName: "Ling",
  age: 42,
  children: ["Alex", "Kai", "Jae"]
};

// show object properties
console.table(person);

// Use dot notation to access properties
console.log(`${person.firstName} ${person.lastName}`);

// Using const with an object only prevents reassignment
// person = {}; // This would cause an error
person.firstName = "Li";
console.log(`${person.firstName} ${person.lastName}`);


/* *****************
 *   Type coercion
 * *****************
 */

// JavaScript will use type coercion when the type isn't what is expected
// With + if both values are numbers, it does arithmetic addition
let x = 10;
let y = 5;
console.log(x + y); 

// If one of the values is a string, it does string concatenation
y = '5';
console.log(x + y); // 105 because y is a now a string

// This can also happen with comparison operators
// == is loose equality, and can be true even if the types are different
x = 5;
y = '5';
console.log(`x is ${x} (type ${typeof(x)}) and y is ${y} (type ${typeof(y)})`);
console.log(`x == y : ${x == y}`);   // true

// === is strict equality, and will only be true if the types are the same
console.log(`x === y : ${x === y}`); // false

// Type coercion can lead to some interesting behaviors in JavaScript
let nonBooleanExpression = -17;  // Any non-zero number becomes true
if (nonBooleanExpression) {
  console.log(`"${nonBooleanExpression}" was coerced to true`);
} else {
  console.log(`"${nonBooleanExpression}" was coerced to false`);
}

// It's best to avoid implicit type coercion and convert types explicitly.
// This is more clear and can help prevent bugs.

// Converting strings to numbers
let temperature = '98.6';
console.log(Number.parseFloat(temperature)); // prints 98.6
console.log(Number.parseInt(temperature));   // prints 98

// If string can't be converted, it will return NaN
let result = Number.parseInt('not a number');
console.log(result);




/* ********************
 *   String methods
 * ********************
 */
const message = 'Welcome to JavaScript!';

// Check if a string contains another string?
console.log(message.includes('Java')); // prints true

// Locate position of a string within another string
console.log(message.indexOf('Java'));  // prints 11
console.log(message.indexOf('a'));     // prints 12
console.log(message.lastIndexOf('a')); // prints 14

// Replace part of a string
let updatedMessage = message.replace('JavaScript', 'class');
console.log(updatedMessage);   // replace returns a new string 
console.log(message);          // original string is unchanged

// Extract part of a string
// The ending index is not included
console.log(message.substring(11, 14));  // prints 'Jav'
console.log(message.substring(11));  // prints 'JavaScript!'

// Convert to all uppercase
console.log(message.toUpperCase()); // prints 'WELCOME TO JAVASCRIPT!'
// Convert to all lowercase
console.log(message.toLowerCase()); // prints 'welcome to javascript!'


/* ********************
 *   Arrays and Loops
 * ********************
 */

// Create an array.
let children = ["Alex", "Kai", "Jae"];

// Array size is dynamic
console.log(`There are ${children.length} children.`);

// Add an element to the end of the array using push
children.push("Mia");
console.log(`There are now ${children.length} children.`);

// for loop to loop through an array, i is a counter for the index
for (let i = 0; i < children.length; i++) {
  console.log(`Child ${i + 1} is ${children[i]}`);
}

// for...of loop to loop through the array, no access to index
console.log('Children are:');
for (let child of children) {
  console.log(child);
}

/* 
 * Some other array methods that modify the array instance are:
 *    pop(), unshift(), shift(), splice(), and reverse()
 */
let foods = ['pizza', 'burgers', 'tacos'];
console.log(`There are ${foods.length} foods: ${foods}`);

// Remove the last element
let food = foods.pop();
console.log(`Removed ${food}, now there are ${foods.length} foods: ${foods}`);

// Add an element to the beginning
foods.unshift('ramen');
console.log(`Added a food, now there are ${foods.length} foods: ${foods}`);

// Remove the first element
food = foods.shift();
console.log(`Removed ${food}, now there are ${foods.length} foods: ${foods}`);

// Add and remove elements
foods.splice(1, 0, 'curry', 'bagels');
console.log(`Added 2 foods, now there are ${foods.length} foods: ${foods}`);

// Reverse the array
foods.reverse();
console.log(`Reversed the foods: ${foods}`);

/* 
 * Some array methods that don't modify the array instance are:
 *    includes(), indexOf(), lastIndexOf(), slice(), and join()
 */

// Check if an element is in the array
console.log(`Does the array have pizza? ${foods.includes('pizza')}`);
console.log(`Does the array have ice-cream? ${foods.includes('ice-cream')}`);

// Get the position of an element in the array
console.log(`Where is curry? ${foods.indexOf('curry')}`);
console.log(`Where are empanadas? ${foods.indexOf('empanadas')}`);

// Copy a part of the array
let copy = foods.slice(1, 3);
console.log(`Copied foods: ${copy}`);
console.log(`Foods is unchanged: ${foods}`);

// Convert the array to a string, using join
console.log(`Foods as a string: ${foods.join(', ')}`);


/* ********************
  *   Functions
  * ********************
  */

/**
 * Functions declarations start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */

// Declare a `helloWorld` function with no parameters
function helloWorld() {
  console.log('Hello, World!');
}

// Call the function
helloWorld();

// Declare a `sayHello` function that accepts a name parameter
function sayHello(name) {
  console.log(`Hello, ${name}!`);
}

// Call the function passing a name
sayHello('Desi');

// Call the function without passing a name
sayHello();

// Update the function to use a default value for the name parameter
function saferSayHello(name = 'you') {
  console.log(`Hello, ${name}!`);
}

/* Note: Function Overloading is not available in JavaScript. 
 * If you declare multiple functions with the same name, the earlier ones are overridden 
 * and the most recent one will be used.
*/

// Declare an `add` function to add two numbers
function add(num1, num2) {
  return num1 + num2;
}

// Declare an `add` function to add three numbers
function add(num1, num2, num3) {
  return num1 + num2 + num3;
}

// Try to call the `add` function with 2 arguments
console.log(add(1, 2)); // prints NaN because num3 is undefined

// Use "rest parameters" to pass an arbitrary number of arguments
function addAll(...numbers) {
  let sum = 0;
  for (let number of numbers) {
    sum += number;
  }
  return sum;
}

