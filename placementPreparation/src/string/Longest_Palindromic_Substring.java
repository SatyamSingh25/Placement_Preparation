package string;
/**
 * @author Satyam
 * Problem Statement: find the longest palindromic substring from the string [Leetcode 5]
 * Difficulty: Medium
 * Tag: String 
 */
public class Longest_Palindromic_Substring {
	public static String  longestPalindromicSubstring(String str) {
		if(str == null || str.length() <1) {
			return "";
		}
		int start = 0, end = 0;
		for(int i=0; i<str.length(); i++) {
			//for odd length palindrome
			int length1 = expandFromMiddle(str, i, i);
			//for even length palindrome
			int length2 = expandFromMiddle(str, i, i+1);
			//getting the max size palindrome
			int currMaxLength = Math.max(length1, length2);
			
			if(currMaxLength > end-start) {
			 	start = i-((currMaxLength-1)/2); 
				end = i+(currMaxLength/2);
			}
		}
		
		return str.substring(start, end+1);
		
	}
	//Expanding means goes left and right while we are have the same character at left and right
	public static int expandFromMiddle(String str, int left, int right) {
		
		while(left>=0 && right<str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}	
		return right - left -1;
	}
	//Driver Code
	public static void main(String[] args) {
		String str = "babad";
		System.out.println(longestPalindromicSubstring(str));
	}

}

