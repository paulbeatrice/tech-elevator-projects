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
		//    Key    Value
		Map<String, String> vending = new HashMap<String, String>();    // size: 0

		// Adding kv pairs
		vending.put("A1", "Oreos");   // size: 1,  A1 -> Oreos
		vending.put("A2", "Doritos"); // size: 2,  A1 -> Oreos, A2 -> Doritos
		vending.put("A3", "Peanuts");
		vending.put("A4", "Oreos");


		String oreos = vending.get("A1");  // .get(key) returns corresponding value
		String doritos = vending.get("A2"); // etc


		// Iterate over the Map!
		//     .keySet() returns allllll of the keys of the Map
		for (String key : vending.keySet()) {
			String value = vending.get(key);

			System.out.println("Key " + key + " has a Value of: " + value);
		}

		// Other way to iterate
		for (Map.Entry<String, String> kvPair : vending.entrySet()) {
			String key = kvPair.getKey();
			String value = kvPair.getValue();

			System.out.println(key + ": " + value);
		}

		vending.get("Hello World!");         // returns null
		vending.containsKey("Hello World!"); // return false

	}

	public boolean yourExercises(Map<String, String> incomingMap) {

		for (String key : incomingMap.keySet()) {
			System.out.print(key + " is a Key of this Map, and ");
			String value = incomingMap.get(key);
			System.out.println(value + " is its corresponding Value");
		}


		return false;
	}


}
