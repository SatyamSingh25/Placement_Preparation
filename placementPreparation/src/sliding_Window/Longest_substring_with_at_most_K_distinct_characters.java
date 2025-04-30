package sliding_Window;
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
		HashMap<Character, Integer> map = new HashMap<>();
		int start = 0;
		int res = 0;
		
		for(int end=0; end<str.length(); end++) {
			map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0)+1);
			
			if(map.size() > k) {
				map.put(str.charAt(start), map.get(str.charAt(start))-1);
				
				if(map.get(str.charAt(start)) <= 0) {
					map.remove(str.charAt(start));
				}
				start++;
			}
			res = Math.max(res, end - start +  1);
		}
		
		System.out.println(str.substring(start, start + res));
		return res;
		
	}

	public static void main(String[] args) {
		String str = "aaccbbbeefff";
		//ccbbbeefff
		//10
		System.out.println(lengthOfLongestSubstringWith_k_distinct(str, 4));
				
	}

}
