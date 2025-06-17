package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");


		// 1. Declaration, 2. Instantiation, 3. Initialization : making an Object out of a Class
		//Scanner keyboard = new Scanner(System.in); // use scanner class to build object in memory
		// 1. Scanner Keyboard
		// 2. new
		// 3. System.in ----- initial values object has
		// create a new (empty) List
		// Interfaces: 1. Not Classes! 2. Cannot be instantiated meaning you can't make an object out of it.

		List<String> instructors = new ArrayList<String>(); // points to an empty arrayList // size : 0

		// now we can instantiate

			instructors.add("Tom");                   //adds tom to list   // size: 1
			instructors.add("Daniel");               // adds daniel to list  // size : 2
			instructors.add("Myron");				// adds myron // size: 3
			instructors.add("Tom");					// adds Tom // size: 4





		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		instructors.get(0); // Tom
		instructors.get(1); // Daniel
		instructors.get(2); // Myron
		instructors.get(3); // Tom

		for (int i = 0; i < instructors.size(); i++){
			instructors.get(i); // get method says pick one thing out at a time and do something with that
			System.out.println(instructors.get(i) + " is an Instructor at Tech Elevator.");

		}



		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		instructors.add(2, "Walt");

		System.out.println("==========\nAfter adding Walt:");
		for (int i = 0; i < instructors.size(); i++) {
			instructors.get(i);
			System.out.println(instructors.get(i) + " is an Instructor at Tech Elevator.");
		}




		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		instructors.remove(3);

		for (int i = 0; i < instructors.size(); i++) {
			instructors.get(i); // get method says pick one thing out at a time and do something with that
			System.out.println(instructors.get(i) + " is an Instructor at Tech Elevator.");
		}




		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		System.out.println("Instructors.contains Walt: " + instructors.contains("Walt"));
		System.out.println("Instructors.contains Walt: " + instructors.contains("Daniel"));




		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");


		System.out.println("Instructors.indexOf Walt: " + instructors.indexOf("Walt"));
		System.out.println("Instructors.indexOf Walt: " + instructors.indexOf("Daniel"));




		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// DIY: List -> Array

		// 1. Create new array

		String[] arrayOfInstructors = new String[instructors.size()]; //  1. create an array big enough to hold everyone

		for (int i = 0; i < instructors.size(); i++) {
			// left side of = memory write
			                    // right side of = memory read
			arrayOfInstructors[i] = instructors.get(i);            // 2. copies over all the data
		}
		// array of Instructors at index 0 will receive instructor at index 0

		// use a list method
		String[] array = instructors.toArray(new String[0]); // data types must match on both left and right // pas a new, empty array into the toArray() method to get what you want
		//  the toArray method returns array of objects -- object to generic -- need list of strings
		//  Object[] array 2 = instructors.toArray(); Objects  (the default return value of toArray() method are too generic to be useful
		// Integer [} whyNot = instructors.toArray(new Integer[0]); // this works, even though my List does not contain Integers ---> .toArray() doesn't know that.




		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(instructors);  // belongs to Collections class // sorts the List in-place meaning only one piece of memory in the Heap and it will mess with it. Make a copy of list before sorting.
		// once you sort you cannot go back
		// sort: 0, 1, 2, 3, 4 (Ascending)
		//sort : a, b, c, d, e, (Ascending)




		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");


		Collections.reverse(instructors); // reverses the List in-place
		// if you don't sort it you gotta reverse it again and then you're right back where you started.
		System.out.println("================\nAfter reversing:");




		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		// for loop (using the index) ---> when u don't cary about the element ---> it shines with the index in order to get the element

		// foreach loop (using the element) ---> when you don't care about the index --->

			System.out.println("for loop:");
		for (int i = 0; i < instructors.size(); i++) {
			String instructor = instructors.get(i);
			System.out.println(instructor + " is an Instructor at Tech Elevator");

		}

		System.out.println("foreach loop:");
		// for (String inst : list) { inst ---> element }
		for (String instructor : instructors){
			System.out.println(instructor + " is an Instructor at Tech Elevator");
		}

		System.exit(0);
	}
}
