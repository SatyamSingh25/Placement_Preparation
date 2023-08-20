package string;
/**
 * @Sliding_Window
 * @Two_Pointer
 */
/*---------------------------Longest Substring with At Most Two Distinct Characters------------------------------
 * Given a string s, find the length of the longest substring t that contains at most 2 distinct characters.
 * 
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 */
import java.util.*;
public class Longest_substring_with_at_most_two_distinct_char {
	
	public static int lengthOfLongestSubstringTwoDistinct(String str) {
		
		if(str.length() == 0 || str.length() == 1) return str.length();
		
		char[] ch = str.toCharArray();
		
		int maxSizeSubstring = 0;
		int firstIndex = 0;
		
		HashMap<Character, Integer> count = new HashMap<>();
		
		for(int i=0; i<str.length(); i++) {
			count.put(ch[i], count.getOrDefault(ch[i], 0) + 1);
			
			while(count.size() > 2) {
				count.put(ch[firstIndex], count.get(ch[firstIndex]) - 1);
				
				if(count.get(ch[firstIndex]) == 0) {
					count.remove(ch[firstIndex]);
				}
				firstIndex++;
			}
			
			maxSizeSubstring = Math.max(maxSizeSubstring, i - firstIndex + 1);
		}
		
		System.out.println(str.substring(firstIndex, firstIndex + maxSizeSubstring));
		return maxSizeSubstring;
	}

	public static void main(String[] args) {
		String str = "ccaabbb";
		//aabbb
		//5
		System.out.println(lengthOfLongestSubstringTwoDistinct(str));
	}

}
