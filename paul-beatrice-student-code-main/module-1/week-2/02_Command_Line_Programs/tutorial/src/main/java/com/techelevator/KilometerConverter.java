package com.techelevator;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class   KilometerConverter {

    public static void main (String[] args) {
        Scanner input = new Scanner( System.in);

        System.out.print( "ENTER A KILOMETER VALUE TO START AT: ");
        String value  = input.nextLine();
        int kilometerStart = parseInt(value);


        System.out.print( "ENTER A KILOMETER VALUE TO END WITH: ");
        value = input.nextLine();
        int kilometerEnd = parseInt(value);

        System.out.print( "HOW MANY SHOULD IT INCREMENT BY: ");
        value = input.nextLine();
        int incrementBy = parseInt(value);

        System.out.println( "GOING FROM " + kilometerStart + "KM TO " + kilometerEnd +
                "KM IN INCREMENTS OF " + incrementBy + "KM. ");

        for (int km = kilometerStart; km <= kilometerEnd; km += incrementBy) {
            double miles = kilometersToMiles(km);

            System.out.println( km + "KM IS " + miles + "mi. ");
        }
    }

    public static double kilometersToMiles(int kilometers) {
        final double MILES_PER_KILOMETER = 0.621371;
        return kilometers * MILES_PER_KILOMETER;

    }


    
}
