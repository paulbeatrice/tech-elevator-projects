/* Exercise 0 - sumNumbers
    Given two number values, return their sum.

    Sample inputs and outputs:
      sumNumbers(1, 2) → 3
      sumNumbers(3, -2) → 1
      sumNumbers(1.5, 4.5) → 6
*/
function sumNumbers(x, y) {
  return x + y;
}

/* Exercise 1 - sumAny
    Given two values, return their sum. Attempt to convert non-numeric values to numbers, returning NaN 
    if the conversion fails. If any argument is missing, use a default value of 0.

    Sample inputs and outputs:
      sumAny(4, '-2') → 1
      sumAny(1, 2.5) → 3.5
      sumAny() → 0
      sumAny(1 + true) → NaN
*/
function sumAny(x =  0, y = 0) {

  if (typeof x === 'boolean' || typeof y === 'boolean') {
    return NaN;
  }

  const num1 = Number(x);
  const num2 = Number(y);

  if (isNaN(num1) || isNaN(num2)) {
    return NaN;
  }

  return num1 + num2;

}

/* Exercise 2 - createPet
    Given a type, name, age, and description, return a *pet* object with the following properties:
      - type - the type of the pet in lowercase
      - name - the name of the pet
      - age - the age of the pet
      - isSenior - true if the pet is 10 years or older
      - description - the description of the pet
    Ensure that you remove any leading or trailing whitespace from string properties.

    Sample:
      createPet('Cat', 'Whiskers', 10, 'A fluffy cat.') → 
          { 
            type: 'cat', 
            name: 'Whiskers', 
            age: 10, 
            isSenior: true, 
            description: 'A fluffy cat.'
          }
*/
function createPet(type, name, age, description) {
  return {
    type: type.trim().toLowerCase(),
    name: name.trim(),
    age: age,
    isSenior: age >= 10,
    description: description.trim()
  };

}

/* Exercise 3 - isTeen
    Given 3 int values, return true if the number is in the range 13 to 19 inclusive. 

    Sample inputs and outputs:
		  isTeen(10) → false
		  isTeen(13) → true
		  isTeen(15) → true
*/
function isTeen(number) {
  return number >= 13 && number <= 19;

}

/* Exercise 4 - formatAddress
    Given an object with the following properties:
      {
        streetNumber: number,
        streetName: string,
        streetType: string,
        city: string,
        state: string,
        zip: string
      }

    Return a formatted string with the following format:
      streetNumber streetName streetType 
      city, state zip

    Sample inputs and outputs:
      formatAddress({ streetNumber: 526, streetName: 'Market', streetType: 'St', city: 'Philadelphia', state: 'PA', zip: '19106' }) →
        '526 Market St\nPhiladelphia, PA 19106'
*/
function formatAddress(address) {
  return `${address.streetNumber} ${address.streetName} ${address.streetType}\n${address.city}, ${address.state} ${address.zip}`;
}

/* Exercise 5 - average
    Given an array of numbers, return the average of all the values, as a string rounded to 2 decimals.
    To calculate the average, add all the numbers together and divide by the number of values.
    If the array is empty, return zero.

		average([10, 15, 20]) → '15.00'
		average([6, 17, 45, 24.5]) → '23.13'
    average([]) → '0.00'
*/
function average(numberArray) {
  if (numberArray.length === 0) {
    return '0.00';
  }

  const total = numberArray.reduce((sum, num) => sum + num, 0);
  const avg = total / numberArray.length;

  return avg.toFixed(2);

}

/* Exercise 6 - getItemNumber
    Determine the item number from the product code. 
    The item number is determined based on the following rules:
      - If the product code begins with a '0', it's always the last 8 characters of the product code.
      - If the product code contains 'XID' (but doesn't start with '0'), it begins after 'XID' and
        continues until there is a '-' or to the end of the product code.
      - Otherwise the item number is the first 10 characters of the product code.
    
    Sample inputs and outputs:
      getItemNumber('0-324-ZID12345678') → '12345678'
      getItemNumber('0A12012345678') → '12345678'
      getItemNumber('XID012345-001') → '012345'
      getItemNumber('XID01234') → '01234'
      getItemNumber('1234567890A213B-020') → '1234567890'
      getItemNumber('1234567890') → '1234567890'
*/
function getItemNumber(productCode) {
  if (productCode.startsWith('0')) {
    return productCode.slice(-8);
  }

  const xidIndex = productCode.indexOf('XID');
  if (xidIndex !== -1) {
    const afterXID = productCode.slice(xidIndex + 3);
    const dashIndex = afterXID.indexOf('-');
    return dashIndex === -1 ? afterXID : afterXID.slice(0, dashIndex);
  }

  return productCode.slice(0, 10);

}

/* Exercise 7 - getItemStyle
    Determine the item style code from the product code. 
    The style code is not always present, but when it is, it is either 3 or 4 digits following 
    a '-' at the end of the product code.
    
    Sample inputs and outputs:
      getItemStyle('XID012345-001') → '001'
      getItemStyle('1234567890-A213B-0202') → '0202'
      getItemStyle('0-324-ZID12345678') → ''
      getItemStyle('1234567890-A213B') → ''
      getItemStyle('1234567890-A2') → ''
*/
function getItemStyle(productCode) {
  const parts = productCode.split('-');
  const last = parts[parts.length -1];

  if (/^\d{3,4}$/.test(last)) {
    return last;
  }

  return '';

}

/* Exercise 8 - extractOdds
    Write a function that takes array of numbers, removes the odd numbers from that array,
    and returns a new array consisting of only the odd numbers removed.

    Notes: 
      - When removing values from an array, use a while loop to better control the iteration.
      - Take notice in the sample output that the original array is modified because arrays are reference types.

    Sample inputs and outputs:
      let array1 = [1, 2, 3, 4, 5];
      extractOdds(array1); → [1, 3, 5]
      console.log(array1); // [2, 4]
*/
function extractOdds(values) {
  const odds = [];
  let i = 0;

  while ( i < values.length) {
    if (values[i] % 2 !== 0) {
      odds.push(values[i]);
      values.splice(i, 1);
    } else {
      i++;
    }
  }
    return odds;
}

/* Exercise 9 - matchingStrand
    Given a DNA strand, return the complementary strand. A and T are complements of each other, as are C and G.
    Notes: 
     - The input strand contain lowercase and uppercase letters, but the output must always be in uppercase.
     - Do not modify the input string.
     - If any other character is found, return null.

    Sample inputs and outputs:
      matchingStrand('') → ''
      matchingStrand('Aa') → 'TT'
      matchingStrand('ATCG') → 'TAGC'
      matchingStrand('gcgtaat') → 'CGCATTA'
      matchingStrand('zattag') → null
*/
function matchingStrand(dnaStrand = ''){
  const map = {
    A: 'T',
    T: 'A',
    C: 'G',
    G: 'C'
  };

  let result = '';

  for (let i = 0; i < dnaStrand.length; i++) {
    const char = dnaStrand[i].toUpperCase();
    if (!map[char]) {
      return null;
    }
    result += map[char];
  }

  return result;

}

/* Exercise 10 - catsAndDogs
    Write a function that takes an array of Pet objects which have a 'type' property indicating the animal type. 
    Count the number of cats, dogs, and other animals in the array, then returns a new object containing the counts like follows:
      {
        catCount: the number of cats in the array,
        dogCount: the number of dogs in the array,
        otherCount: the number of other animals in the array
      }

    Notes: 
      - If there is no type property, count the animal as 'other'.
      - The object must always contain all three properties, with the count set to zero if there are no animals of that type.
      - If the array is empty or nothing is passed in, return an object with 0 for all the counts.
  
    Sample inputs and outputs:
      catsAndDogs([{type: 'cat'}, {type: 'dog'}, {type: 'cat'}]) → {
        catCount: 2,
        dogCount: 1,
        otherCount: 0
      }
      catsAndDogs([{type: 'bird'}, {type: 'cat'}]) → {
        catCount: 1,
        dogCount: 0,
        otherCount: 1
      }
*/
function catsAndDogs(petArray = []) {
  const counts = {
    catCount: 0,
    dogCount: 0,
    otherCount: 0
  };

  for (const pet of petArray) {
   if (!pet.type) {
    counts.otherCount++;
   } else if (pet.type === 'cat') {
    counts.catCount++;
   } else if (pet.type === 'dog') {
    counts.dogCount++;
   } else {
    counts.otherCount++;
   }
  }
  return counts;
}

/* Exercise 11 - sumAll
    Write a function called sumAll that takes an unknown number of parameters, adds them all together, and returns the sum.
    Notes: 
     - Attempt to convert any strings to numbers. Any non-numeric values of any type should be ignored.
     - If no parameters are passed, return 0.
  
    Sample inputs and outputs:
      sumAll(1, 2, 3) → 6
      sumAll(1, -2, 3, 6) → 8
      sumAll(1, '-3') → -2
      sumAll(true, null, 'a') → 0
      sumAll() → 0
*/
function sumAll(...numbers) {
  let sum = 0;

  for (let value of numbers) {

    if (typeof value === 'boolean' || value === null) continue;

    const num = Number(value);
    if (!isNaN(num)) {
      sum += num;
    }
  }
  return sum;
}
      
/* Exercise 12 - sumDigits
    Write a function called sumDigits that takes a whole number, and returns the sum of all the digits.
    Notes: 
      - If the number is negative, the resulting sum should also be negative.
      - If no parameter is passed, return 0.
  
    Sample inputs and outputs:
      sumDigits(111) → 3
      sumDigits(-111) → -3
      sumDigits() → 0
*/
function sumDigits(number = 0) {

  const isNegative = number < 0;

  const digits = Math.abs(number)
    .toString()
    .split('')
    .map(Number);

    const total = digits.reduce((sum, digit) => sum + digit, 0);

    return isNegative ? -total : total;

}

// do not modify the following line
export { sumNumbers, sumAny, createPet, isTeen, formatAddress, average, getItemNumber, getItemStyle, extractOdds, matchingStrand, catsAndDogs, sumAll, sumDigits };
