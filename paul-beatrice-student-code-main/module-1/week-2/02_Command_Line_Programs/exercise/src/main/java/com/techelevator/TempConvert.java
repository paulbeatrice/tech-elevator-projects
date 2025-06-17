package com.techelevator;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TempConvert {

	public static void main(String[] args) {


		Scanner input = new Scanner(System.in);

		System.out.print( "Enter a temperature: ");
		String temperature=input.next();
		int value = parseInt(temperature);


		System.out.print( "Is the temperature in (C)elsius C, or (F)ahrenheit? F: ");
		String temperatureValue =input.next();

		String str1 = "C";
		String str2 = "F";

			if (temperatureValue.equals(str1)) {
				double temperatureFahrenheit = value * 1.8 + 32;
				int temperatureFahrenheitWithoutDecimals = (int) temperatureFahrenheit;
				System.out.println(temperature + temperatureValue + " is " + temperatureFahrenheitWithoutDecimals + "F");
			}

			if (temperatureValue.equals(str2)) {
				double temperatureCelsius = (value - 32) / 1.8;
				int temperatureCelsiusWithoutDecimals = (int) temperatureCelsius;
				System.out.println(temperature + temperatureValue + " is " + temperatureCelsiusWithoutDecimals + "C");
			}

	}

}
