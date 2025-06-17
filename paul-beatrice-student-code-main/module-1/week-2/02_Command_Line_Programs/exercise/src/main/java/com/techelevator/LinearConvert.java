package com.techelevator;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print( "Please enter a length: ");
		String length = input.next();
		int value = parseInt(length);

		System.out.print( "Is the measurement in (m)eters m, or (f)eet? f: ");
		String measurementValue =input.next();

		String str1 = "m";
		String str2 = "f";

		if (measurementValue.equals(str1)) {
			double lengthInFeet = value * 3.2808399;
			int feetInLengthNoDecimals = (int) lengthInFeet;
			System.out.println(length + measurementValue + " is " + feetInLengthNoDecimals + "f");
		}
		if (measurementValue.equals(str2)){
			double lengthInMeters = value  * 0.3048;
			int MetersInLengthNoDecimals = (int) lengthInMeters;
			System.out.println(length + measurementValue + " is " + MetersInLengthNoDecimals + "m");

		}
	}

}
