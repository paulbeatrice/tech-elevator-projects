package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNExample {

    // "main" + Tab
    public static void main(String[] args) {
        // 1. Start with a String (represents the file name / path)
        String path = "rtn.txt";

        // 2. Turn the String into a File object
        File inputFile = new File(path);

        // 3. Turn the File object into a Scanner object (for streaming!)
        try {
            Scanner fileStreamer = new Scanner(inputFile);


            int lineCount = 0;

            // 4. while scanner.hasNextLine()
            while (fileStreamer.hasNextLine()) {
                // 5. scanner.nextLine() and process the String that comes back
                String line = fileStreamer.nextLine();

                System.out.print("Here's the next RTN: " + line + "\t");

                System.out.print("This RTN ");
                if (!line.contains("0")) {
                    System.out.print("does not ");
                }
                System.out.println("contains a zero.");

                lineCount++;
            }

            System.out.println("That file had " + lineCount + " lines of text!");

        } catch (FileNotFoundException e) {
            System.out.println("Could not find file! -- " + e.getMessage());
        }

        // Scanner keyboard = new Scanner(System.in);




//        if (inputFile.exists()) {
//            System.out.println("File exists!");
//
//            if (inputFile.isDirectory()) {
//                System.out.println("It's a Directory!");
//            } else if (inputFile.isFile()) {
//                System.out.println("It's a File!");
//            }
//
//            System.out.println("File size: " + inputFile.length());
//
//
//        } else {
//            System.out.println("File does not exist!");
//        }



    }

}
