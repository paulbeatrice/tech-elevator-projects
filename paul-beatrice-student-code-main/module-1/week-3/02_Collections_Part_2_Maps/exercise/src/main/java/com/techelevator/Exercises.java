package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Exercises {

	/*
	 * Create and return a Map that contains the following data
	 * of animals and the name of a group of that animal.
	 *
	 * rhino -> crash
	 * giraffe -> tower
	 * elephant -> herd
	 * lion -> pride
	 * crow -> murder
	 * pigeon -> kit
	 * flamingo -> pat
	 * deer -> herd
	 * dog -> pack
	 * crocodile -> float
	 *
	 */
	public Map<String, String> animalGroupName() {

		Map<String, String> animalsGroupName = new HashMap<String, String>();

		animalsGroupName.put("rhino", "crash");
		animalsGroupName.put("giraffe", "tower");
		animalsGroupName.put("elephant", "herd");
		animalsGroupName.put("lion", "pride");
		animalsGroupName.put("crow", "murder");
		animalsGroupName.put("pigeon", "kit");
		animalsGroupName.put("flamingo", "pat");
		animalsGroupName.put("deer", "herd");
		animalsGroupName.put("dog", "pack");
		animalsGroupName.put("crocodile", "float");

		return animalsGroupName;
	}

	/*
	 * Given a Map and a String item number, look for the item number in the Map
	 * and return its value that represents the discount percentage if the item is on sale.
	 *
	 * If the item number isn't in the map, or is empty, or is null, return 0.00 instead.
	 *
	 * For example, the Map might have keys and values such as:
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 *
	 * The item number should be case-insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale({"KITCHEN4001": 0.20, "GARAGE1070": 0.15}, "kitchen4001") → 0.20
	 * isItOnSale({"LIVINGROOM": 0.10, "KITCHEN6073": 0.40}, "") → 0.00
	 * isItOnSale({"BEDROOM3434": 0.60, "GARAGE1070": 0.15}, "GARAGE1070") → 0.15
	 * isItOnSale({"KITCHEN4001": 0.20, "BATH0073": 0.15}, "spaceship9999") → 0.00
	 *
	 */
	public double isItOnSale(Map<String, Double> itemsOnSale, String itemNumber) {


		if (itemsOnSale == null || itemNumber == null || itemNumber.isEmpty()) {
			return 0.00;
		}
		// convert the itemNumber to lowercase to allow case insensitive manner
		String lowerCaseItemNumber = itemNumber.toLowerCase();

		for(Map.Entry<String, Double> entry : itemsOnSale.entrySet()) {
			if (entry.getKey().toLowerCase().equals(lowerCaseItemNumber)){
				return entry.getValue();
			}
		}


		return 0.00;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 * robPeterToPayPaul({"Peter": 101, "Paul": 500}) → {"Peter": 51, "Paul": 550}
	 * robPeterToPayPaul({"Peter": 0, "Paul": 500}) → {"Peter": 0, "Paul": 500}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {

		peterPaul = new HashMap<>(peterPaul);

		if (peterPaul.containsKey("Peter") && peterPaul.containsKey("Paul")) {
		int petersMoney = peterPaul.get("Peter");
		int paulMoney = peterPaul.get("Paul");

		if( petersMoney > 0 && paulMoney < 1000) {
			int transferAmount = (petersMoney / 2);
			peterPaul.put("Peter", petersMoney - transferAmount);
			peterPaul.put("Paul", paulMoney + transferAmount);

		}
		}
		return peterPaul;

	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "Partnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "Partnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {


		if (peterPaul.containsKey("Peter") && peterPaul.containsKey("Paul")) {
			int petersMoney = peterPaul.get("Peter");
			int paulsMoney = peterPaul.get("Paul");

			if( petersMoney >= 5000 && paulsMoney >= 10000) {
				int peterPaulPartnership = (petersMoney/4) + (paulsMoney/4);
				int petersContribution = petersMoney/4;
				int paulsContribution = paulsMoney/4;

				peterPaul.put("Peter", petersMoney - petersContribution);
				peterPaul.put("Paul", paulsMoney -  paulsContribution);
				peterPaul.put("Partnership", peterPaulPartnership);

			}
		}
		return peterPaul;
	}

	/*
	 * Given an array of non-empty strings, return a Map<String, String> where, for every String in the array,
	 * there is an entry whose key is the first character of the string.
	 *
	 * The value of the entry is the last character of the String. If multiple Strings start with the same letter, then the
	 * value for that key should be the later String's last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["code", "bug", "cat"]) → {"b": "g", "c": "t"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {

		Map<String, String> beginningAndEnding = new HashMap<String, String>();

		for (String word : words){
			if (word != null && word.length() > 0){
				String key = String.valueOf(word.charAt(0));
				String value = String.valueOf(word.charAt(word.length()-1));
				beginningAndEnding.put(key, value);
			}
		}
		return beginningAndEnding;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {

		Map<String, Integer> wordCount = new HashMap<String, Integer>();

		for (String word : words) {
			if (wordCount.containsKey(word)){
				wordCount.put(word, wordCount.get(word)+1);
			}
			else {
				wordCount.put (word, 1);
			}

		}
		return wordCount;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {

		Map<Integer, Integer> integerCount = new HashMap<Integer, Integer>();

		for (int number : ints) {
			if (integerCount.containsKey(number)){
				integerCount.put(number, integerCount.get(number)+1);
			}
			else {
				integerCount.put (number, 1);
			}

		}
		return integerCount;

	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["apple", "banana", "apple", "carrot", "banana"]) → {"banana": true, "carrot": false, "apple": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {

		Map<String, Integer> wordCount= new HashMap<String, Integer>();
		Map<String, Boolean> wordMultiple= new HashMap<String, Boolean>();

		for (String key : words) {
			if (wordCount.containsKey(key)) {
				wordCount.put(key, wordCount.get(key) + 1);
			} else {
				wordCount.put(key, 1);
			}
		}

		for (String key : wordCount.keySet()){
			wordMultiple.put(key, wordCount.get(key) >=2);
		}

		return wordMultiple;

	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {

		Map<String, Integer> consolidateInventory = new HashMap<>(mainWarehouse);

		for (String key : remoteWarehouse.keySet()){
			if (consolidateInventory.containsKey(key)){
				consolidateInventory.put(key, consolidateInventory.get(key) + remoteWarehouse.get(key));
			}
			else{
				consolidateInventory.put(key, remoteWarehouse.get(key));
			}
		}

		return consolidateInventory;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, its last2 count is the number of times that a subString length 2
	 * appears in the String and also as the last 2 chars of the String.
	 *
	 * We don't count the end subString, so "hixxxhi" has a last2 count of 1, but the subString may overlap a prior
	 * position by one.  For instance, "xxxx" has a count of 2: one pair at position 0, and the second at position 1.
	 * The third pair at position 2 is the end subString, which we don't count.
	 *
	 * Return a Map<String, Integer> where the keys are the Strings from the array and the values are the last2 counts.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {

		Map<String, Integer> last2Revisted = new HashMap<>();
		for (String last2Revisited : words) {
			// Skip words with less than 2 characters
			if (last2Revisited.length() < 2) {
				last2Revisted.put(last2Revisited, 0);
				continue;
			}
			String last2 = last2Revisited.substring(last2Revisited.length() - 2);
			int count = 0;

			// Iterate over the string to find occurrences of last2
			for(int i = 0; i < last2Revisited.length() - 2; i++) {
				if (last2Revisited.substring(i, i + 2).equals(last2)) {
					count++;
				}
			}

			last2Revisted.put(last2Revisited, count);

		}
		return last2Revisted;
	}

}
