package string;
/**
 * @author Satyam
 * Problem statement: Find the minimum number of deletion to make string palindrome.
 * Difficulty: Medium
 * tag: String, LCS, Recursion
 */
import java.util.*;
public class MinimumDeletionToPalindrome {
	//recursive Method for Minimum Deletion to make it Palindrome O(2^n) time
	public static int MinDelPalindromeRecursion(String str, int start, int end) {
		if(start >= end) {
			return 0;
		}
		if(str.charAt(start) ==  str.charAt(end)) {
			return MinDelPalindromeRecursion(str, start+1, end-1);
		}
		return 1+Math.min(MinDelPalindromeRecursion(str, start+1, end), MinDelPalindromeRecursion(str, start, end-1));
	}
	
	//recursion + memorisation means Use of HashMap in recurison O(n^2) time and space
	public static int MinDelPalindromeMemorisation(String str, int start, int end, HashMap<String, Integer> lookup) {
		if(start >= end) {
			return 0;
		}
		//generating unique key
		String key = start + "|"+end;
		
		if(lookup.containsKey(key) == false) {
			
			if(str.charAt(start) == str.charAt(end)) {
				lookup.put(key, MinDelPalindromeMemorisation(str, start+1, end-1, lookup));
			}
			
			else {
				int result = 1 + Math.min(MinDelPalindromeMemorisation(str, start+1, end, lookup), MinDelPalindromeMemorisation(str, start, end-1, lookup));
				lookup.put(key, result);
			}
		}
		return lookup.get(key);
	}
	
	//Dynamic Approach [LCS variation problem] O(n^2) time and space
	public static int Min_Deletion_to_Palindrome_DP(String str) {
		int size = str.length();
		
		String reverse = new StringBuilder(str).reverse().toString();
		
		int[][] dp = new int[size+1][size+1];
		
		for(int i=1; i<=size; i++) {
			for(int j=1; j<=size; j++) {
				
				if(str.charAt(i-1) == reverse.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return size - dp[size][size];
	}
	
	//Driver Code
	public static void main(String[] args) {
		String str = "ACBCDBAA";
		System.out.println("String: " + str);//                        start    end
		System.out.println("Recursion: " + MinDelPalindromeRecursion(str, 0, str.length()-1));
		//                                                                        start   end             unique key
		System.out.println("Recursion + memo :" + MinDelPalindromeMemorisation(str, 0, str.length()-1, new HashMap<String, Integer>()));
		System.out.println("DP approach: " + Min_Deletion_to_Palindrome_DP(str));
		
	}

}
