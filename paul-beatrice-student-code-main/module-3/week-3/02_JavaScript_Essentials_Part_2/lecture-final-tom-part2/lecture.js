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
//  3. filter   --> returns array (not the same size!)
//  4. reduce   --> returns singular value (NOT AN ARRAY)

const myArray = [1, 1, 2, 3, 5, 8, 13, 21, 34];

myArray.forEach((element) => {
    console.log(element + " is a piece of data in my array!");
});

const doubledArray = myArray.map((element) => {
    return (element * 2) - 5;
});

const filteredArray = myArray.filter((item) => {
    return item !== 8;
});


console.log("Filtered Array:");
console.table(filteredArray);

const singularValue = myArray.reduce((accumulator, element) => {
    console.log(`Accumulator / Reducer: ${accumulator}  Element: ${element}   Returning ${accumulator + element}` );
    return accumulator + element;
}, 99);

console.log(singularValue);


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


setTimeout(() => {
    console.log("JK!");
}, 5000);

console.log("OK we are done!");

const pid = setInterval(() => {
    if (x > 100) {
        clearInterval(pid);
    }
}, 1000);


setTimeout(() => {
    clearInterval(pid);
}, 10000);


fetch("www.google.com").then((data) => {
    // handle the data now that it's here
});
