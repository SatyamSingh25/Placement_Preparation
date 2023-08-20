package string;
/**
 * @Sliding_Window
 * @Two_Pointer
 * @HashMap
 */
/*---------------------------Longest Substring with At Most K Distinct Characters------------------------------
 * Given a string s, find the length of the longest substring t that contains at most k distinct characters.
 * 
 * Input: "aaccbbbeefff"
 * Output: 10
 * Explanation: t is "ccbbbeefff" which its length is 10.
 */
import java.util.*;
public class Longest_substring_with_at_most_K_distinct_characters {
	
	public static int lengthOfLongestSubstringWith_k_distinct(String str, int k) {
		if(str == null || k==0 || str.length() ==0) return 0;
		
		if(str.length() < k) return str.length();
		
		HashMap<Character, Integer> count = new HashMap<>();
		
		int n = str.length();
		char[] ch = str.toCharArray();
		int maxSizeSubstring = 0;
		int firstIndex = 0;
		
		for(int i=0; i<n; i++) {
			count.put(ch[i], count.getOrDefault(ch[i], 0)+1);
			
			if(count.size() > k) {
				count.put(ch[firstIndex], count.get(ch[firstIndex])-1);
				
				if(count.get(ch[firstIndex]) == 0) {
					count.remove(ch[firstIndex]);
				}
				firstIndex++;
			}
			maxSizeSubstring = Math.max(maxSizeSubstring, i - firstIndex +  1);
		}
		
		System.out.println(str.substring(firstIndex, firstIndex + maxSizeSubstring));
		return maxSizeSubstring;
		
	}

	public static void main(String[] args) {
		String str = "aaccbbbeefff";
		//ccbbbeefff
		//10
		System.out.println(lengthOfLongestSubstringWith_k_distinct(str, 4));
				
	}

}
