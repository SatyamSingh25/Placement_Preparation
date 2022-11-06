package string;
/**
 * @String
 * @hashMap<String , count>
 * link: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/
 */
/* -------------------------2131. Longest Palindrome by Concatenating Two Letter Words--------------------
 * 	You are given an array of strings words. Each element of words consists of two lowercase English letters.

	Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. 
	Each element can be selected at most once.

	Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome,
	return 0.

	A palindrome is a string that reads the same forward and backward.
 */

import java.util.*;
public class Longest_Palindrome_by_Concatenating_Two_Letter_Word {
	//time: O(word) + O(26)
	//space: O(word)
	public static int longestPalindrome_by_concatinating_two_words(String[] words) {
		HashMap<String, Integer> map = new HashMap<>();
		int size = 0;
		for(String word: words) {
			String reverseString = new StringBuilder(word).reverse().toString();
			
			if(map.containsKey(reverseString)) {
				size += 4;
				map.put(reverseString, map.get(reverseString)-1);
				if(map.get(reverseString) <= 0)
						map.remove(reverseString);
			}
			else {
				map.put(word, map.getOrDefault(word, 0)+1);
			}
		}
		for(int i=0; i<26; i++) {
			String pair = "" + (char)('a'+i) + (char)('a'+i);
			if(map.containsKey(pair) && map.get(pair) > 0) {
				size += 2;
				break;
			}				
		}
		return size;
	}
	
	public static void main(String[] args) {
		String[] words = new String[] {"ab","ty","yt","lc","cl","ab"};
		System.out.println(longestPalindrome_by_concatinating_two_words(words)); //result 8 [tylcclyt]
		
		words = new String[] {"lc","cl","gg"};
		System.out.println(longestPalindrome_by_concatinating_two_words(words)); //result 6 [lcggcl]
		
		words = new String[] {"cc","ll","xx"};
		System.out.println(longestPalindrome_by_concatinating_two_words(words)); // result 2 [cc]

	}

}
