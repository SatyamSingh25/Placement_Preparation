package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.*;

public class KthLargestFrequencyElement {
	
	public static void KFrequency(String S, int K) {
		// Creating a TreeMap containing char
        // as a key and occurrences as  a value
		// storing them lexicographically.
        TreeMap<Character, Integer> CharCountMap = new TreeMap<Character, Integer>();
        
        // Converting given string to char array
        char[] str = S.toCharArray();
        
        // checking each char of strArray
        for(char ch: str){
            if(CharCountMap.containsKey(ch) == true){
            	// If char is present in charCountMap,
                // incrementing it's count by 1
            	CharCountMap.put(ch, CharCountMap.get(ch)+1);
            }
            else {
            	// If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
            	CharCountMap.put(ch, 1);
            }
        }
        // creating set for counting or storing number of distinct occurrences.  
        HashSet<Integer> set = new HashSet<>();
        
        
        for(Entry<Character, Integer> entry : CharCountMap.entrySet()) {
        	set.add(entry.getValue());
        }
        // if number of occurrences smaller the K them 
        // it is not possible to find kth largest frequency element 
        if(set.size()<K){
        	System.out.println("Not Possible");
        	return;
        }
        
        // Creating an iterator 
        Iterator<Integer> itr = set.iterator();
        
        // adding the set values into an array
        ArrayList<Integer> arr = new ArrayList<>();
        while(itr.hasNext()) {
        	arr.add((Integer) itr.next());
        }
        
        //sorting 
        Collections.sort(arr);
        
        // Kth largest frequency
        int kth = arr.get(arr.size()-K);
        
        //finding the kth largest frequency character
        for(Entry<Character, Integer> entry : CharCountMap.entrySet()) {	
        	if(entry.getValue()==kth) {
        		System.out.println(entry.getKey());
        		break;
        	}
        } 
    }

	public static void main(String[] args) {
		KFrequency("aabcd", 3);
		KFrequency("aabcd", 3);
	}
	//this code contributed by Satyam Singh
	
	public static void method2(String s, int k) {
		char[] arr = s.toCharArray();
		if(arr.length < k) {
			System.out.println("not posible");
			return;
		}
		Arrays.sort(arr);
		int count = 1;
		int min = Integer.MAX_VALUE; 
		char ch = arr[0];
		for(int i = 1; i<arr.length && k!=0; i++) {
			if(arr[i-1] == arr[i]) {
				count++;
				k--;
			}
			else {
				if(count < min) {
					ch = arr[i-1];
					min = count;
					count = 1;
				}
			}
		}
		System.out.println(ch);
	}
}
