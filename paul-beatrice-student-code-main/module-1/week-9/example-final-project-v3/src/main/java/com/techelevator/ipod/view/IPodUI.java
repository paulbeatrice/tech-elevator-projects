package com.techelevator.ipod.view;

import com.techelevator.ipod.model.Listenable;

import java.util.List;
import java.util.Scanner;

public class IPodUI {

    private final Scanner keyboard = new Scanner(System.in);

    public String welcomeScreen() {
        System.out.println("==============================");
        System.out.println("Welcome to your iPod Playlist!");
        System.out.println("==============================");
        System.out.print("Let's create a new playlist! Enter the name of it >>> ");
        return keyboard.nextLine().trim();
    }

    public void mainMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Display all available songs");
        System.out.println("2. Display all available podcasts");
        System.out.println("3. Add to your playlist");
        System.out.println("4. Play your playlist");
        System.out.println("0. Exit");
    }

    public void displayListenableOptions(List<Listenable> input) {
        for (int i = 0; i < input.size(); i++) {
            System.out.println((i + 1) + ". " + input.get(i));
        }
    }

    public int promptForChoiceNumber(int lower, int upper) {
        boolean weHaveValidInput = false;
        int choice = lower - 1;

        while (!weHaveValidInput) {
            System.out.print("Enter your choice >>> ");
            String choiceAsString = keyboard.nextLine();
            try {
                choice = Integer.parseInt(choiceAsString);
                if (choice >= lower && choice <= upper) {
                    weHaveValidInput = true;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid number!");
            }
        }

        return choice;
    }

    public String promptForPlaylistName() {
        System.out.print("What is the name of your playlist? >>> ");
        String playlistName = keyboard.nextLine();

        return playlistName;
    }

    public String promptForFileName() {
        System.out.print("Enter the path to your data file >>> ");
        String fileName = keyboard.nextLine();
        return fileName;
    }

}
