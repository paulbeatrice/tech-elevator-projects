/***********************************************
 * Objects, constructor functions, and methods
 ***********************************************
 */


/**********************************************
 * Destructuring assignment and spread syntax
 **********************************************
 */


/*****************************************************
 * Functions, function expressions, and arrow syntax
 *****************************************************
 */


/**********************
 * Callback functions
 **********************
 */


/*******************************************
 * Array methods with synchronous callbacks
 *******************************************
 */
function functionName(inputParameter1, inputParameter2) {
    // code block
}

// (in1, in2) => {
//     return in1 + in2;
// }

// helloWorld(5);
// helloWorld(true);
// helloWorld((in1, in2) => { return in1 + in2; });


// Array Methods:
//  1. forEach  --> returns undefined
//  2. map      --> returns array (same size as the original)
//  3. filter
//  4. reduce

const myArray = [1, 1, 2, 3, 5, 8, 13, 21, 34];

myArray.forEach((element) => {
    console.log(element + " is a piece of data in my array!");
});

const doubledArray = myArray.map((element) => {
    return (element * 2) - 5;
});


console.log("Input: ");
console.log(myArray);
console.log("Output: ");
console.log(doubledArray);

console.log("Done!");






// Anonymous function 
let x = function (inputParameter1, inputParameter2) {
    // code block
}

x();

/**************************
 * Asynchronous callbacks
 **************************
 */

