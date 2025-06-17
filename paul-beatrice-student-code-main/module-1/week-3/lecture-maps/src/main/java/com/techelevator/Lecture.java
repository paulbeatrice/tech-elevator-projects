package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();


		// Create a new, empty map
		//   Key     Value
		Map<String, String> vending = new HashMap<String, String>();

		// now add data by using methods

		// Adding kv Pairs
		vending.put("A1", "Oreos");  // Size: 1, A1 ---> Oreos
		vending.put("A2", "Doritos");
		vending.put("A3", "Peanuts");
		vending.put("A4", "Oreos");

		String oreos = vending.get("A1"); // .get(Key) returns corresponding value
		String dorits = vending.get("A2");  // etc


		// Iterate over the Map!

		// .keySet() returns all of the keys of the Map

		for (String key : vending.keySet()) {// gives us all keys
		String value =	vending.get(key);

		System.out.println("Key " + key + " has a Value of: " + value);

		}

		vending.get("Hello World");            // returns null
		vending.containsKey("Hello World");    // return false





	}
	public boolean yourExercises(Map < String, String> incomingMap){

		for (String Key: incomingMap.keySet()){
			System.out.println(Key + " is a Key of this Map, and ");
			String value = incomingMap.get(Key);
			System.out.println(value + " is its corresponding Value");
		}


		return false;
	}

}
