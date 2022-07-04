package string;
/**
 * ---------------------------------1048. Longest String Chain-----------------------------------
 * You are given an array of words where each word consists of lowercase English letters.
 * 
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in word'A 
 * without changing the order of the other characters to make it equal to wordB.

	->For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
	  A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is 
	  a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

   Return the length of the longest possible word chain with words chosen from the given list of words.
   
  -> Input: words = ["a","b","ba","bca","bda","bdca"]
  -> Output: 4
  -> Explanation: One of the longest word chains is ["a","ba","bda","bdca"]
 */
import java.util.*;
import java.io.*;
public class Longest_String_chain {

	public static void main(String[] args) {
		String[] words = new String[] {"a","b","ba","bca","bda","bdca"};
		//result -> 4
		System.out.println(longestStringChain(words));
	}
	
	public static int longestStringChain(String[] words) {
		//sorting array according to size of words
		Arrays.sort(words, (a, b)->a.length()-b.length());
		System.out.println(Arrays.toString(words));
		
		int maxSize = 1;
		HashMap<String, Integer> map = new HashMap<>();
		
		for(String word: words) {
			map.put(word, 1);
			
			for(int i=0; i<word.length(); i++) {
				StringBuilder curr = new StringBuilder(word);
				String predecessor = curr.deleteCharAt(i).toString();
				
				if(map.containsKey(predecessor)) {
					map.put(word, Math.max(map.get(word), map.get(predecessor)+1));
				}
			}
			
			maxSize = Math.max(maxSize, map.get(word));
		}
		
		System.out.println(map);
		return maxSize;
	}

}
