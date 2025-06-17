/* ***************************
 *  Variables and data types
 * ***************************
 */

// Use let for values that will change
// Use camelCase for variable names

console.log("Hello World!");

for (let i = 0; i < 10; i++) {
  console.log(i);
}



// Use const for values that should not change
// Use uppercase for constants

const DAYS_OF_THE_WEEK = 7;

// Variables are not typed, they can hold any value


// Variables that don't have a value are undefined
let y;
console.log(y);

// null also represents an empty value, but is explicitly assigned


//Objects literals are simple key-value pairs.
const person = {
  firstName: "Tom",
  lastName: "Medvitz",
  age: 21
};

console.table(person);

// show object properties

// Use dot notation to access properties

console.log(person.socialSecurityNumber);

// Using const with an object only prevents reassignment

Object.freeze(person);

person.age = 46;
console.log(person);

const myArray = [1, 1, 2, 3, 5, 8, 13, 21];
myArray[5] = -5;

console.table(myArray);




/* *****************
 *   Type coercion
 * *****************
 */

// JavaScript will use type coercion when the type isn't what is expected
// With + if both values are numbers, it does arithmetic addition
console.log(2 + 2);
console.log(2 + "2");


// If one of the values is a string, it does string concatenation


// This can also happen with comparison operators
// == is loose equality, and can be true even if the types are different

// === is strict equality, and will only be true if the types are the same


// Type coercion can lead to some interesting behaviors in JavaScript


// It's best to avoid implicit type coercion and convert types explicitly.
// This is more clear and can help prevent bugs.


// Converting strings to numbers
parseInt("11");
parseFloat("12.3");

// If string can't be converted, it will return NaN

// Boolean coercion (truthy / falsy)
// 0, NaN, "", false, null, undefined      are all FALSE, everything else is TRUE
if (NaN) {
  console.log("That was true!");
} else {
  console.log("That was false!");
}


/* ********************
 *   String methods
 * ********************
 */
// JavaScript convention prefers single quotes for strings
//             01234
let string1 = "Hello";
let string2 = 'World';

// <h1 id="someJavaScriptFunction('withAnArg')"> </h1>

// Check if a string contains another string?
const answer1 = string1.includes(string2);
console.log(answer1);

// Locate position of a string within another string
const answer2 = string1.indexOf("lo");
console.log(answer2);


// Replace part of a string
let string3 = string1.replace("Hell", "Heaven");
console.log(string1);
console.log(string3);


// Extract part of a string
// The ending index is not included
// .substring(beginIndex, endIndex)         --> EXACTLY THE SAME AS JAVA!
// .substr(beginIndex, numberOfCharacters)  --> used by C# (and some other languages)
console.log(string1.substring(1, 3));
console.log(string1.substr(3, 1));



// Convert to all uppercase and all lowercase

string1.toLowerCase().toUpperCase().trim();


/* ********************
 *   Arrays and Loops
 * ********************
 */

// Create an array.
const myArray2 = [];


// Array size is dynamic


// Add an element to the end of the array using push


// for loop to loop through an array, i is a counter for the index


// for...of loop to loop through the array, no access to index


/* 
 * Some other array methods that modify the array instance are:
 *    pop(), unshift(), shift(), splice(), sort(), and reverse()
 */


/* 
 * Some array methods that don't modify the array instance are:
 *    includes(), indexOf(), lastIndexOf(), concat(), slice(), and join()
 */


/* ********************
  *   Functions
  * ********************
  */

/**
 * Functions declarations start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */

// Declare a `helloWorld` function with no parameters
// public String helloWorld(int numberOfTimes) {
//   String output = "";
//   while (numberOfTimes-- > 0) {
//     output += "Hello World";
//   }
//   return output;
// }

function helloWorld(numberOfTimes) {
  let output = "";
  while (numberOfTimes-- > 0) {
    output += "Hello World ";
  }
  return output;
}

// Call the function
// const output1 = helloWorld(5);
const variableHoldingTheFunction = helloWorld;

const output1 = variableHoldingTheFunction(5);
console.log(output1);

// Declare a `sayHello` function that accepts a name parameter
function sayHello(yourName = 'Tom Anderson') {
  console.log("Hello, " + yourName + " (concatenation)"); // String concatenation
  console.log(`Hello, ${yourName} (interpolation)`); // String interpolation (Java can't do this)
}

// Call the function passing a name
// sayHello("Tom");

// Call the function without passing a name
sayHello("Tom", "Alex", "Andrew", "Ben", "Max");
sayHello();



// Update the function to use a default value for the name parameter


/* Note: Function Overloading is not available in JavaScript. 
 * If you declare multiple functions with the same name, the earlier ones are overridden 
 * and the most recent one will be used.
*/

// Declare an `add` function to add two numbers
function add(num1, num2) {
  return num1 + num2;
}

// Declare an `add` function to add three numbers


// Try to call the `add` function with 2 arguments


// Use "rest parameters" to pass an arbitrary number of arguments

//  varargs (Variable Arguments) in Java:   public static void main(String... args) {}

function add(...numbers) {
  let sum = 0;
  for (let i = 0; i < numbers.length; i++) {
    sum += numbers[i];
  }
  return sum;
}



const fiftyFive = add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
console.log("(n)(n+1)/2 = " + fiftyFive);

