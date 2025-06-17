package com.techelevator;

import java.util.List;
import java.util.ArrayList;


public class ShoppingCart {

    private List<Book> booksToBuy = new ArrayList<>();

    public void add(Book bookToAdd) {
        booksToBuy.add(bookToAdd);
    }

    public double getTotalPrice() {
        double total = 0.0;
        for(Book book : booksToBuy) {
            total += book.getPrice();
        }
        return total;
    }

    /* Finally, the ShoppingCart needs a receipt() method that returns a receipt-like string
    representation of the shopping cart, with a listing of all the books in the cart and, at the end,
    the total price of everything in the cart:

     */

    public String receipt() {
        String receipt = "\nReceipt\n";
        for(Book book : booksToBuy) {
            receipt += book.bookInfo();
            receipt += "\n";
        }

        receipt += "\nTotal: $" + getTotalPrice();

        return receipt;
    }
}
