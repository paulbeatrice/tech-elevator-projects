package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.print("Enter the name of a folder >>> ");
		String folderName = keyboard.nextLine();

		// Make a File object from the String
		File newFolder = new File(folderName);

		newFolder.mkdir();

		System.out.println("Let's put a file in that folder!");
		System.out.print("Enter the name of the file >>> ");

		String newFileName = keyboard.nextLine();               // get String from user
		File newFileObject = new File(folderName, newFileName); // turn String to File

		try {
			newFileObject.createNewFile();
		} catch (IOException e) {
			System.out.println("You're not allowed to create that file!");
		}



		// try-with-resources: cleans up after you

		System.out.print("Enter a new file name >>> ");
		String overwrittenFile = keyboard.nextLine();

		// if we want to OVERWRITE a file, just use PrintWriter (throws FileNotFoundException, which is-a IOException)

		// if we want to APPEND to a file (rather than OVERWRITE a file), we use FileOutputStream (throws IOException)
		//   1. create a FileOutputStream object from the String, and pass in true for the "append" value
		//   2. put the FileOutputStream object into the constructor of the PrintWriter

//		try ( FileOutputStream fileOutputStream = new FileOutputStream(overwrittenFile, true);
//			  PrintWriter pw = new PrintWriter(fileOutputStream)) {


		// condensed APPEND mode try-with-resources line:
		try ( PrintWriter pw = new PrintWriter(new FileOutputStream(overwrittenFile, true))) {

			System.out.println("Let's put some text into that file!");
			String message = "";

			while (!message.equalsIgnoreCase("q")) {

				System.out.print("Enter a message to put in the file ('q' to quit) >>> ");
				message = keyboard.nextLine();
				pw.println(message);
			}

//			for (int i = 1; i <= 10_000 ; i++) {
//				pw.println(i);
//			}

			// pw.flush();  // Empty the buffer
			// pw.close();  // Releasing the resource

		} catch (IOException e) {
			System.out.println("Problem opening your file -- " + e.getMessage());
		}

		System.out.println("Done!");
	}

}
