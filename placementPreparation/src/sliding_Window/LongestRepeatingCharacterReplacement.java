package sliding_Window;
/**
 * @SLiding_Window
 * @Leetcode_424_Longest_Repeating_Character_Replacement
 * Problem : You are given a string s and an integer k. 
 *           You can choose any character of the string and change it to any other uppercase English character. 
 *           You can perform this operation at most k times.
 *           
 *           Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *           
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 */
import java.util.*;
public class LongestRepeatingCharacterReplacement {
	
	//Sliding Window
	//TC : O(2n)
	//Sc : O(k)
	public static int characterReplacement(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;
        int maxFreq = 0;

        for(int end=0; end<str.length(); end++){
            map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(str.charAt(end)));

            //till we not get valid window
            while((end - start + 1) - maxFreq > k){
                map.put(str.charAt(start), map.get(str.charAt(start))-1);
                start++;
            }

            res = Math.max(res, end - start + 1);
        }

        return res;
    }

	public static void main(String[] args) {
		System.out.println(characterReplacement("AABABBA", 2)); //5 [AABAB] or [BABBA]
		System.out.println(characterReplacement("AAABBCCD", 2)); //5 [AAABB]
	}

}
