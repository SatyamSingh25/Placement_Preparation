package string;
/**
 * @Two_Pointer
 */
//---------------------------3. Longest Substring Without Repeating Characters-------------------------
/* Given a string s, find the length of the longest substring without repeating characters.
 * 	
 * 	Input: s = "abcabcbb"
	Output: 3
	Explanation: The answer is "abc", with the length of 3.
 */

import java.util.*;
public class Longest_Substring_With_Unique_Characters {

	//Driver Code
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- != 0) {
			String str = sc.next();			
			System.out.println(countLongest_unique_char_substring(str));
		}		
	}

	//Approach Code
	//Two Pointers
	private static int countLongest_unique_char_substring(String str) {
		if(str.length() == 0 || str.length() == 1)
            return str.length();
        HashSet<Character> set = new HashSet<>();
		int i = 0, j = 0;
		int max = -1;
		while(j < str.length()){
			if(set.contains(str.charAt(j))) { //repeated character found
				set.remove(str.charAt(i));
				i++;
			}
			else { //it not in set
				set.add(str.charAt(j));
				j++;
				max = Math.max(max, set.size()); //number of character present in SET is the answer
			}	
		}
        return max;
	}

}
