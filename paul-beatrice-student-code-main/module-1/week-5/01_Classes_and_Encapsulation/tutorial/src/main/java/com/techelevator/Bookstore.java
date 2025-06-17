package com.techelevator;

/**
 * Bookstore
 */
public class Bookstore {

    public static void main(String[] args) {

        System.out.println("Welcome to the Tech Elevator Bookstore");
        System.out.println();

        // Step Three: Test the getters and setters

        // declares TwoCities as a Book
        Book twoCities = new Book();
        // Sets title to "A Tale Of Two Cities"
        twoCities.setTitle(" A Tale Of Two Cities");
        //Sets Author to Charles Dickens
        twoCities.setAuthor("Charles Dickens");
        //Sets Price to 14.99
        twoCities.setPrice(14.99);
        // System.out.println("Title: " + twoCities.getTitle() + ", Author: " + twoCities.getAuthor() + ", Price: $" + twoCities.getPrice());
        System.out.println(twoCities.bookInfo());


        // Step Five: Test the Book constructor
        Book threeMusketeers = new Book( "The Three Musketeers", "Alexandre Dumas", 12.95);

        Book childhoodEnd = new Book("Childhood's End", "Arthur C. Clark", 5.99);

        // System.out.println("Title: " + threeMusketeers.getTitle() + ", Author: " + threeMusketeers.getAuthor() + ", Price: $" + threeMusketeers.getPrice());

        System.out.println(threeMusketeers.bookInfo());

        //System.out.println("Title: " + childhoodEnd.getTitle() + ", Author: " + childhoodEnd.getAuthor() + ", Price: $" + childhoodEnd.getPrice());

        System.out.println(childhoodEnd.bookInfo());

        // Step Nine: Test the ShoppingCart class
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(twoCities);
        shoppingCart.add(threeMusketeers);
        shoppingCart.add(childhoodEnd);
        System.out.println(shoppingCart.receipt());
        
    }
}