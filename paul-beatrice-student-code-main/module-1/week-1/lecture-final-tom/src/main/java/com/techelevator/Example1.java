package com.techelevator;


// Access Modifier: public


//           PascalCase
public class Example1 {

	public static void main(String[] args) {

		System.out.println("Hello World!");

		// sout + Tab
		System.out.println("Gets printed to the screen!");


		/*
		1. What is 5 divided by 2?
		*/

		// Declare a variable:
		//  1. Data Type
		//  2. Variable Name (camelCase)
		double fiveDividedByTwo = 5.0 / 2.0;      // 2.5

		//   LITERAL SUFFIX
		// add F to a number (treats it as a float -- 32 bits)
		// add L to a number (treats it as a long -- 64  bits)

		System.out.println(fiveDividedByTwo);


		/*
		2. What is 5.0 divided by 2? (Or 5 divided by 2.0?)
		*/

		System.out.println(5.0 / 2.0);


		/*
		3. What is 66.6 divided by 100?
		*/
		System.out.println(66.6 / 100);
		

		/*
		4. If I divide 5 by 2, what's my remainder?
		*/

		int quotient  = 5 / 2;   // 2
		int remainder = 5 % 2;  // 1

		System.out.println("5 / 2 is " + quotient + " remainder " + remainder);

		/*
		5. What is 1,000,000,000 * 3?
		*/

		System.out.println(1_000_000_000 * 3);

		
	}

}
