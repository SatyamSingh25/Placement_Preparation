package sliding_Window;
/**
 * @Sliding_Window
 * @leetcode_1358_Number_of_Substrings_Containing_All_Three_Characters
 * Problem: Given a string s consisting only of characters a, b and c.
 *          Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *          
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the 
 * characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
 *
 */
public class Count_Substring_Containing_three_characters {

	//Sliding Window
	//TC : O(n)
	//Sc : O(3)
	public static int numberOfSubstrings(String s) {
        int[] count = new int[]{-1, -1, -1}; //store the index (a=-1, b=-1, c=-1) not yet scene yet in starting
        int start = 0;
        int res = 0;

        for(int end=0; end < s.length(); end++){
            count[s.charAt(end) - 'a'] = end;

            if(count[0] != -1 && count[0] != -1 && count[0] != -1){
                res = res + (1 + Math.min(count[0], Math.min(count[1], count[2])));
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(numberOfSubstrings("abcabc")); //10
	}

}
