package sliding_Window;
/**
 * @Sliding_Window
 * @Leetcode_3_Longest_Substring_Without_Repeating_Characters
 * Problem :  Given a string s, find the length of the longest substring without repeating characters.
 * 	
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {

	//Sliding Window
	//TC : O(n)
	//Sc : O(n)
	public static int longestSubstringWithoutRepeatingCharacterson(String str) {
		HashSet<Character> set = new HashSet<>();
		int start = 0;
		int res = 0;
		
		for(int end=0; end<str.length(); end++) {
			while(set.contains(str.charAt(end))) {
				set.remove(str.charAt(start));
				start++;
			}
			
			set.add(str.charAt(end));
			res = Math.max(res, (end - start + 1));
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(longestSubstringWithoutRepeatingCharacterson("abcabcbb")); //3
	}

}
