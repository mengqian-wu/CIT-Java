import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Class with various methods for using different kinds of Collections. 
 * @author fengliang
 *
 */
public class CollectionClass {
	
	/**
	 * Takes a given list and removes elements in the range min through max(inclusive)
	 * Demonstrates use of Iterator. 
	 * @param List of values 
	 * @param min of range 
	 * @param max of range 
	 */
	public static void removeRange(ArrayList<Integer> list, int min, int max) {
		
		//create iterator to iterate over list and remove items in place 
		Iterator<Integer> iterator = list.iterator(); 
		
		//iterator interface has many methods like: hasNext(); next(); remove(); forEachRemaining(); 
		//hasNext() will returns true(boolean) if the iteration has more elements, otherwise it returns false
		while(iterator.hasNext()) {
			//next() method will return the next element in the iteration 
			Integer next = iterator.next(); 
			//check if the next element is between min and max 
			if(next >= min && next <= max) {
				
				//remove() method is straightforward, which doesn't return anything 
				//it removes from the underlying collection the last element returned by this iterator 
				//Reminder: it can only be called once per call to next()
				//Exceptions to throw: 
				//- UnsupportedOperationException 
				//- IllegalStateException 
				iterator.remove(); 
			}
		}
	}
	
	//Count words using a HashMap
	//This is similar to Dictionary, just the key is the word type, and the value is the frequency, like how many words appeared 
	/**
	 * Takes the given array of strings and returns a map with a key for each different string. 
	 * and a value for the count of the number of times that string appears in the array.
	 * 
	 * Demonstrations use of HashMap 
	 * 
	 * @param strings to count
	 * @return map of word counts, where key is word and value is count 
	 */
	public static Map<String, Integer> wordCount(String[] strings){
	
		//create a hashmap (has no order)
		//see, we create Map interface with the implementation of HashMap
		//Hash table based implementation of the Map interface. THe implementation provides all of the optional map operations, and permits null values and the null key. 
		//HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		
		
		
		//iterate over array of strings 
		for(String s : strings) {
			//if map doesn't contain key for string, add it
			if(!map.containsKey(s)) {
				
				//the key is S, the value at this point will be 1 (default)
				map.put(s, 1); 
			}else {
				
				//replace old count with incremented count 
				map.replace(s, map.get(s) + 1); 
			}
		}
		
		return map; 
	}
	
	
	
	/**
	 * Takes given ArrayList and modifies the list by placing a "*" in between each element, and at the beginning and the end. 
	 * and at the beginning and the end 
	 * 
	 * @param list of values to add stars 
	 */
	public static void addStars(ArrayList<String> list) {
		
		//create an empty array, copy all values in arrayList in array 
		//String[] - this means create a array of String element called array
		//list.toArray method of LIST interface return an array containing all the elements present in the list in proper order. 
		//<T> T[] toArray(T[] a) returns an array containing all of the element in this list where runtime type of the returned array is that of the specified array
		//toArray() doesn't know the return type, so new String[number] means it structures as list of String element at a size of the number 
		//toArray takes as input an empty array into which the values will be stored 
		
		String[] array = list.toArray(new String[list.size()]);
	
		//empty original arrayList 
		//removeAll in java takes 1 parameter: the collection that contains elements to be rmeoved from the list 
		//asList() method of java.util.Arrays class is used to return a fixed-size list backed by the specified array. 
		//it is a bridge between array-based and collection-based APIs, in combination with Collection.toArray()
		list.removeAll(Arrays.asList(array)); 
		
		//add stars and values back into original arrayList 
		list.add("*");
		
		//loop for each element in the array and add it to the list and add "*" after 
		for (String s: array) {
			list.add(s); 
			list.add("*"); 
		}
	}
	
	/**
	 * Takes an array of strings and returns a count of the unique words int eh array.
	 * Case-sensitive. e.g., "Hello" and "hello" are considered different word
	 * Demonstrates use of HashSet
	 * @param words to count
	 * @return count of unique words 
	 */
	public static int countUniqueWords(String[] words) {
		
		//create hashset (has no order) of words in given array
		Set<String> hashSetWords = new HashSet<String>(Arrays.asList(words)); 
		
		//return count of unique elements in give array 
		return hashSetWords.size(); 
		
	}
	
	/**
	 * Takes an array of strings and returns a count of the unique words in the array.
	 * Case-insensitive. e.g., "Hello" and "hello" are considered the same words 
	 * 
	 * Demonstrates user of TreeSet. 
	 * @param words
	 * @return
	 */
	public static int countUniqueWordsCaseInsensitive(String[] words) {
		
		//create a treeset (like a hashset, but ordered)
		//String.CASE_INSENTITIVE_ORDER forces treeset to compare its elements 
		//in a case-insensitive way 
		//CASE_INSENSITIVE_ORDER signature has a source in CaseInsensitiveComparator
		Set<String> treeSetWords = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER); 
		
		treeSetWords.addAll(Arrays.asList(words)); 
		
		//add all elements from provided array to TreeSet 
		treeSetWords.addAll(Arrays.asList(words)); 
		
		return treeSetWords.size(); 
	}
	
	/**
	 * Takes the given arraylist of integers and modifies it by removing duplicates 
	 * Maintains order of elements in arraylist. 
	 * 
	 * Demonstrates usage of LinkedHashSet. 
	 * 
	 * @param list of ints to remove duplicates from 
	 */
	public static void removeDuplicates(ArrayList<Integer> list) {
		
		//LinkedHashSet元素有序，且不能重复
		//LinkedHashSet is like HashSet but maintains the insertion order 
		//create linkedhashset (like a hasset, but maintains insertion order)
		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>(list); 
		
		//remove all items from original list 
		list.removeAll(list); 
		
		//add all elements from linkedhashset to original list 
		list.addAll(linkedHashSet); 

		
	}
	
	/**
	 * Takes a map of food keys and food topping values, and modifies and returns the map 
	 * as follows:
	 * if the key "ice cream" is present, set its value to "cherry"
	 * In all cases, set the key "bread" to have the value of "butter"
	 * 
	 * @param map of food items and toppings 
	 * @return updated map of food it
	 */
	//return a Map, with key string and value string, take a map as an argument 
	public static Map<String, String> setToppings(Map<String, String>map){
		//add key "bread" and value "butter", if its not in map 
		if(!map.containsKey("bread")) {
			map.put("bread", "butter"); 
		}
		
		if(map.containsKey("ice cream")) {
			map.replace("ice cream", "cherry");
		}
		
		return map;
		
	}
	
	
	/**
	 * Takes a map and reads friend relationships and stores them into a compound collection that is returned. 
	 * compound collection that is returned 
	 * Creates a new map where each key is a person's name and the value is set of all friends of that person. 
	 * 
	 * Friendships are bi-directional: 
	 * If Marty is friends with Danielle, then Danielle is friends with Marty 
	 * 
	 * Map parameter for the method: it contains one friend relationship per key value pair consisting of two names. 
	 * For example, if the map parameter friendMap 
	 * looks like this: {Marty: Cynthia, Danielle: Marty} 
	 * 
	 * The call of friendList(friendMap) should return a map with the following:
	 * {Cynthia: [Marty], Danielle: [Marty], Marty : [Cynthia, Danielle]}
	 * 
	 * Demonstrates use of a TreeMap of TreeSets 
	 * 
	 * 
	 * @param friendMap of friendships 
	 * @return map where the key is a person's name and the value is the set of all friends 
	 */
	public static TreeMap<String, TreeSet<String>> friendList(Map<String, String> friendMap){
		
		//create a treemap of treesets (like hashsets, but ordered)
		//TreeMap is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation, depending on which constructor is used.
		//<k, v>, k is the String of name, TreeSet<String> is a list of unique names 
		TreeMap<String, TreeSet<String>> treeMap = new TreeMap<String, TreeSet<String>>(); 
		
		//iterate over the entrySet(key/value pairs) for given friendMap {Marty: Cynthia, Danielle: Marty} 
		//the entrySet() method returns a collection-view of the map, with each Entry containing a key and associated value. 
		//import Entry from java.util.Map: a map entry (key-value pair)
		for(Entry<String, String> friendShip: friendMap.entrySet()) {
			
			//get key
			String friend1 = friendShip.getKey(); 
			
			//get value 
			String friend2 = friendShip.getValue(); 
			
			if(!treeMap.containsKey(friend1)) {
				//put friend1 with empty treeset as value 
				treeMap.put(friend1, new TreeSet<String>()); 
			}
			
			//add friend2 to treeset value for friend1
			treeMap.get(friend1).add(friend2); 
			
			//if treemap doesn't contain key for friend2
			if(!treeMap.containsKey(friend2)) {
				//put friend2 with empty treeset as value 
				treeMap.put(friend2, new TreeSet<String>()); 
			}
			
			//add friend1 to treeset value for friend2
			treeMap.get(friend2).add(friend1); 
		}
		
		return treeMap; 
	}
	public static void main(String[] args) {
		//removeRange 
		//create array of ints 
		Integer[] removeRangeArray = {7, 9, 4, 2, 7, 7, 5, 3, 5, 1, 7, 8, 6, 7}; 
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		
		//add all items from array to arraylist 
		list.addAll(Arrays.asList(removeRangeArray)); 
		
		CollectionClass.removeRange(list, 5, 7); 
		
		//print output 
		System.out.println("removeRnage: " + list); 
		System.out.println(); 
		
		//addStars 
		//create array of strings 
		String[] addStar = {"the", "quick", "brown", "fox"}; 
		
		//add all items in array to arraylist 
		ArrayList<String> sList = new ArrayList<String>(); 
		sList.addAll(Arrays.asList(addStar)); 
		
		//addStars method will make a given arraylist into star list  
		CollectionClass.addStars(sList); 
		
		System.out.println("addStars: " + sList); 
		System.out.println(); 
		
		//wordCount 
		String[] strings = {"a", "b", "a", "c", "b"}; 
		Map<String, Integer> ret = CollectionClass.wordCount(strings); 
		
		System.out.println("wordCount: " + ret); 
		System.out.println(); 
		
		//countUniqueWords 
		//the result is 6 because hello and Hello will be count as different things 
		String[] countUniqueWordsArray = {"hello", "izzy", "and", "Elise", "and", "Louise", "and", "Hello"};
		
		System.out.println("countUniqueWords: " 
				+ CollectionClass.countUniqueWords(countUniqueWordsArray)); 
		System.out.println(); 
		
		
		//countUniqueWordsCaseInsensitive 
		//hello and Hello will be the same thing 
		System.out.println("countUniqueWordsCaseInsensitive: "
				+ CollectionClass.countUniqueWordsCaseInsensitive(countUniqueWordsArray)); 
		
		//removeDuplicates 
		
			//create initial integer list 
		Integer[] removeDuplicatesArray = {4, 0, 2, 9, 4, 7, 2, 0, 0, 9, 6, 6};
		
		    //create an empty list to store results 
		ArrayList<Integer> list2 = new ArrayList<Integer>(); 
		
			//addAll elements in the list (transferred from arrays)
		list2.addAll(Arrays.asList(removeDuplicatesArray)); 
		
			//call the method removeDuplicates 
		CollectionClass.removeDuplicates(list2); 
			
			
		System.out.println("removeDuplicates: " + list2); 
		
		System.out.println(); 
		
		//setToppings 
		//create hashmap with food items and toppings 
		Map<String, String> food = new HashMap<String, String>(); 
		food.put("ice cream", "peanuts"); 
		
		Map<String, String> m = CollectionClass.setToppings(food); 
		System.out.println("setToppings: " + m); 
		System.out.println(); 
		
	
	
	
		
	}
}
