package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		// 1. Declaration, 2. Instantiation, 3. Initialization:  making an Object out of a Class
		// Scanner keyboard = new Scanner(System.in);

		// Create a new (empty) List
		//    Interfaces: 1. Not classes! 2. Cannot be instantiated
		List<String> instructors = new ArrayList<String>();

		instructors.add("Tom");      // size: 1
		instructors.add("Daniel");   // size: 2
		instructors.add("Myron");    // size: 3
		instructors.add("Tom");      // size: 4


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

//		instructors.get(0); // Tom
//		instructors.get(1); // Daniel
//		instructors.get(2); // Myron
//		instructors.get(3); // Tom

		for (int i = 0; i < instructors.size(); i++) {
			System.out.println(i + ": " + instructors.get(i) + " is an Instructor at Tech Elevator.");
		}






		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		instructors.add(2, "Walt");

		System.out.println("===========\nAfter adding Walt:");

		for (int i = 0; i < instructors.size(); i++) {
			System.out.println(i + ": " + instructors.get(i) + " is an Instructor at Tech Elevator.");
		}



		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		instructors.remove(3);
		System.out.println("===========\nAfter removing index 3:");

		for (int i = 0; i < instructors.size(); i++) {
			System.out.println(i + ": " + instructors.get(i) + " is an Instructor at Tech Elevator.");
		}


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		System.out.println("Instructors.contains Walt: " + instructors.contains("Walt"));
		System.out.println("Instructors.contains Dan: " + instructors.contains("Dan"));


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("Instructors.indexOf Walt: " + instructors.indexOf("Walt"));
		System.out.println("Instructors.indexOf Dan: " + instructors.indexOf("Dan"));



		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// DIY: List -> Array
		String[] arrayOfInstructors = new String[instructors.size()];  // 1. create an array big enough to hold everyone
		for (int i = 0; i < instructors.size(); i++) {
			// memory write
			//                         memory read
			arrayOfInstructors[i] = instructors.get(i);                // 2. copies over all the data
		}

		// use a list method
		Object[] array2 = instructors.toArray();                       // Objects (the default return value of toArray() are too generic to be useful
		String[] array = instructors.toArray(new String[0]);           // so.... pass a new, empty array into the toArray() method, to get what you want
		// Integer[] whyNot = instructors.toArray(new Integer[0]);        //   this works, even though my List does not contain Integers ---> .toArray() doesn't know that



		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		// sort: 0, 1, 2, 3, 4 (Ascending)
		// sort: a, b, c, d, e (Ascending)
		Collections.sort(instructors);    // sorts the List in-place, once you sort you cannot go back
		System.out.println("===========\nAfter sorting:");

		for (int i = 0; i < instructors.size(); i++) {
			System.out.println(i + ": " + instructors.get(i) + " is an Instructor at Tech Elevator.");
		}
		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(instructors); // reverses the List in-place
		System.out.println("===========\nAfter reversing:");

		for (int i = 0; i < instructors.size(); i++) {
			System.out.println(i + ": " + instructors.get(i) + " is an Instructor at Tech Elevator.");
		}


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		System.out.println("for loop:");
		// for loop (using the index)   IntelliJ shortcut: "fori" + Tab
		for (int i = 0; i < instructors.size(); i++) {
			String instructor = instructors.get(i);
			System.out.println(i + ": " + instructor + " is an Instructor at Tech Elevator");
		}

		System.out.println("foreach loop:");
		// foreach loop (using the element)
		for (String instructor : instructors) {
			System.out.println(instructor + " is an Instructor at Tech Elevator");
		}

	}
}
