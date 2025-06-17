package com.techelevator;

import javax.security.sasl.SaslClient;
import java.util.Random;
import java.util.Scanner;

public class RandomExample {

    public static void main(String[] args) {

        Random randomGenerator = new Random();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a sentence >>> ");
        String input = keyboard.nextLine();
        input = input.toLowerCase();

        for (String letter : input.split("")) {
            if(randomGenerator.nextBoolean()) {
                letter = letter.toUpperCase();
            }
            System.out.print(letter);
        }

    }
}
