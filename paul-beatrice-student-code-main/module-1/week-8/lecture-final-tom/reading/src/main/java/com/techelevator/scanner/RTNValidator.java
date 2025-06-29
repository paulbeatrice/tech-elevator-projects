package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) {

		printApplicationBanner();
		
		File inputFile = getInputFileFromUser();


		// try-with-resources (coming up)
		try (Scanner fileScanner = new Scanner(inputFile)) {

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String rtn = line.substring(0, 9);

				System.out.print(line + " is ");
				if (!checksumIsValid(rtn)) {
					System.out.print("NOT ");
				}
				System.out.println("valid!");

			}
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't open the file! " + e.getMessage());
		}
	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 2000");
		System.out.println("******************");
		System.out.println();
	}

	private static File getInputFileFromUser() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = keyboard.nextLine();
		
		File inputFile = new File(path);  // turn String to a File object

		if (inputFile.exists() == false) { // checks for the existence of a file
            System.out.println(path + " does not exist");
            return null;
		} else if (inputFile.isFile() == false) {
            System.out.println(path + " is not a file");
            return null;
		}

		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for (int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
