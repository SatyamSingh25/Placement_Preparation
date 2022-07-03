package string;
/**
 * @author Satyam
 * @Leetcode_583
 * @Dynamic_Programming
 * @2D
 * @Delete_Operation_to_make_String_Same
 */

/*
 * -----------------------------583. Delete Operation for Two Strings---------------------------------
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 
 * the same.

	In one step, you can delete exactly one character in either string.
	
	Input: word1 = "sea", word2 = "eat"
	Output: 2
	Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 */

public class Minimum_deletion_to_make_string_equals {
	
	//Approach
	public static int minDeletion_to_makeSame_Strings(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		
		int[][] dp = new int[len1+1][len2+1];
		
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return len1+len2 - 2*dp[len1][len2];
	}
	
	//main method
	public static void main(String[] args) {
		//result -> 2
		System.out.println(minDeletion_to_makeSame_Strings("sea", "eat"));
		
		//result -> 4
		System.out.println(minDeletion_to_makeSame_Strings("leetcode", "etco"));

	}

}
