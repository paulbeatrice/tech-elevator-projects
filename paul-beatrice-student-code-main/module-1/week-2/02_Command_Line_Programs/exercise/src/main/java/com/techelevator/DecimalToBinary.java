package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in); // connect to keyboard

		System.out.print( "PLEASE ENTER A SERIES OF DECIMAL VALUES (SEPARATED BY SPACES): ");

		String userInput = keyboard.nextLine(); // bring in a string (whatever user typed)

												//  userInput " 460 8218 1 31313 987654321" (one big string)

		 String[] tokens = userInput.split( " "); // delimiter (a space)                (array of small strings)

        // i: 0, token: "460" ; ; i: 1 token: "8218" ;; i: 2, token "1" ....
        for (String token : tokens) {
            int tokenInt = Integer.parseInt(token); // convert "460" to 460

            // Follow the pattern from drawing
            // 1. Divide by 2, capture quotient AND remainder
            // 2. Remainder gets prepended to the solution
            // 3. Quotient goes back to 1. (until quotient is zero)

            String solution = ""; // declare solution as an empty String

            while (tokenInt > 0) { // while the token is STRICTLY GREATER THAN ZERO (meaning token == 0 will break the loop)
                int quotient = tokenInt / 2;
                int remainder = tokenInt % 2;

                solution = remainder + solution; // 2.
                tokenInt = quotient;             // 3.

            }

            System.out.println(token + " in binary is " + solution);

        }


















	}


}