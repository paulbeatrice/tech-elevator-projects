package com.techelevator;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Please enter a number:");
		String number=input.next();
		int value=parseInt(number);

		int num1 = 0;
		int num2 = 1;
		int fibonacci;

		for (int i=0; i<value; i++){
			System.out.print(num1 + ",");
			fibonacci=num1 + num2;
			num1=num2;
			num2=fibonacci;

			if (num1>=value)
				break;
		}

		if (value<=0){
			System.out.println("0, 1");

		}

		if (value==1){
			System.out.println("0, 1, 1");
		}

	}

}
