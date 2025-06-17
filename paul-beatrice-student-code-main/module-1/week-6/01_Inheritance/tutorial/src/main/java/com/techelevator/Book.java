package com.techelevator;

/**
 * Book
 */
public class MediaItem extends MediaItem {

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(String title, String author, double price) {
	   super(title, price);
	   this.author = author;
	}
	
	public Book() {
		super();
	}
	// Book.java
	@Override
	public String toString() {
		return "Title: " + this.getTitle() + ", Author: " + author + ", Price: $" + this.getPrice();
	}

}