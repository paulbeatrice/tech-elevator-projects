package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class Tutorial {

    public static void main(String[] args) {

        // ***********  Step 1: Use the *new* operator to create Strings on the Heap  *************

        // Create a new string from an array of characters
        char[] helloChars = new char[] {'h', 'e', 'l', 'l', 'o', '!'};
        String greeting = new String(helloChars);
        System.out.println(greeting);

        // You can also use a string by passing in a literal value in double-quotes
        String salutation = new String( "Welcome my friend");
        System.out.println(salutation);

        // Java allows you to skip the *new* operator when creating a *new* String
        String toast = "May the compiler rise up to meet you. ";
        System.out.println(toast);





        // ***********  Step 2: Try out some String methods  *************
        System.out.print(" PLEASE ENTER A SENTENCE: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        // Print the sentence back to the user
        System.out.println(sentence);

        // Print the sentence in all upper case
        String upperCaseSentence = sentence.toUpperCase();
        System.out.println(sentence.toUpperCase());

        // Print the sentence in all lower case
        System.out.println(sentence.toLowerCase());

        // find the first space character
        int firstSpace = sentence.indexOf( " " );
        // report the length of the first word
        if( firstSpace == -1) {
            // indexOf returns -1 when the string is not found
            // if there is no space assume the whole sentence is one word.
            System.out.println("The first word is " + sentence.length() + " characters long. ");
        } else {
            // report the length of the first word
            System.out.println("The first word is " + firstSpace + " characters long. ");
        }

        // Replace the word "the" with "the one and only".
        System.out.println(sentence.replace("the" , "the one and only"));


        // list the words (split)
        String[] words = sentence.split(" ");
        System.out.println("The words in this sentence:");
        for (int i = 0; i < words.length; i++){
            System.out.println(words[i]);
        }

        // Re-assemble the sentence with a new delimiter
        String dashSentence = String.join("-->", words);
        System.out.println(dashSentence);

        // Print the initial sentence. Notice it has not changed.
        System.out.println(sentence);





        // ***********  Step 3: Compare Strings  *************

        String secretWord = "Secret!";
        System.out.println("Enter the secret word (hint it's '" + secretWord + "')");
        String userSecretWord = scanner.nextLine();

        // Compare using ==
        boolean matchEqualityOperator = secretWord == userSecretWord;
        System.out.println("Using '==': " + matchEqualityOperator);

// Compare using equals()
        boolean matchEquals = secretWord.equals(userSecretWord);
        System.out.println("Using '.equals(): " + matchEquals);

        // Compare using equalsIgnoreCase()
        boolean matchEqualsIgnoreCase = secretWord.equalsIgnoreCase(userSecretWord);
        System.out.println("Using '.equalsIgnoreCase(): " + matchEqualsIgnoreCase);





    }
}



