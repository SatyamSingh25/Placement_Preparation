package backtrack_or_recursion;
/**
 * @Stiver_Video : https://www.youtube.com/watch?v=_H8V5hJUGd0
 * ----------------------------------------------------Palindrome Partitioning II---------------------------------------------------
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * Example 1:
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * ---------------------------------------------------------------------------------------------------------------------------------
 */
import java.util.*;
public class PartitionPalindrome2 {
	
	//Approach
	public static int minCuts(String s) {
		int[] dp = new int[s.length()];  //memoization because only start is changing
		Arrays.fill(dp, -1);
		
		boolean[][] isPalindrome = preprocessedPalindrome(s);
		
		return solve(0, s, dp, isPalindrome) - 1; //why -1 because if whole string is palindrome, then no need to cut anything
	}
	
	//helper
	public static int solve(int start, String s, int[] dp, boolean[][] isPalindrome) {
		if(start >= s.length()) return 0; //base case
		
		if(dp[start] != -1) return dp[start];
		
		int min = Integer.MAX_VALUE; //max number of cuts which are possible
		
		for(int i=start; i<s.length(); i++) {
			
			if(isPalindrome[start][i]) { //is current string is palindrome then only consider for computation			
				int cost = 1 + solve(i + 1, s, dp, isPalindrome); // 1 + ("ab") because "a" is palindrome
				
				min = Math.min(min, cost);
			}
		}
		return dp[start] = min;
	}
	
	//Pre computing Palindrome
	public static boolean[][] preprocessedPalindrome(String s){
		int size = s.length();
		boolean[][] dp = new boolean[size][size];
		
		//for length 1
		for(int i=0; i<size; i++)
			dp[i][i] = true;
		
		//for length 2,3,4.... n
		for(int len = 2; len <= size; len++) {
			for(int i = 0; i<= size-len; i++) {
				int j = i + len -1;
				
				if(s.charAt(i) == s.charAt(j)) {
					if(len == 2)
						dp[i][j] = true;
					else 
						dp[i][j] = dp[i+1][j-1];
				}
			}
		}
		
		return dp;		
	}
	
	//Driver Code
	public static void main(String[] args) {
		System.out.println(minCuts("aab")); //1 [aa, b]
		System.out.println(minCuts("aaaaa")); //0 [aaaaa]
		System.out.println(minCuts("aabababa")); //1 [a, abababa]
	}

}
