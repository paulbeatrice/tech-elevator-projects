package com.techelevator;

import java.util.Scanner;

public class Lecture {

    // Lecture() { }


    public double hotelCharge(String reservationName, int numberOfGuests, int numberOfNights) {
        System.out.println("WELCOME, " + reservationName.toUpperCase() + "!!!");

        if (numberOfGuests < 1 || numberOfNights < 1) {
            throw new IllegalArgumentException("Guests or Nights are incorrect");
        }


        return (numberOfGuests * 25) + (numberOfNights * 100);
    }



    public int squareIt(int x) {
        return x * x;
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        boolean weHaveGoodInput = false;

        while (!weHaveGoodInput) {
            System.out.print("Enter a number >>> ");
            String userNumber = keyboard.nextLine();
            try {
                int number = Integer.parseInt(userNumber);

                weHaveGoodInput = true;

                System.out.println(number + " in Celsius is " + number * number + " in Fahrenheit");
            } catch (Exception e) {
                System.out.println("Hey! Play nice.");
            }
        }




        try {
            int x = 5 / 5;
            System.out.println("Calculating ....");
            System.out.println(x);
        } catch (Exception e) {
            System.out.println("You mathed wrong!");
        }



//        System.out.println("Tom failing to make his point");
//        System.out.println(Integer.MAX_VALUE);
//        int max = 5_000_000;
//
//        long answerShort = (long)max * (long)max;
//
//        System.out.println(answerShort);
    }
}
