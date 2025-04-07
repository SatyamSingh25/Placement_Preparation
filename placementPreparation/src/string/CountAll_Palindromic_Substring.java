package string;
/**
 * @CountNumber_of_Palindrome_substring_are_possible
 * @Substring
 * @DP
 * @2D_DP
 */
import java.util.*;
public class CountAll_Palindromic_Substring {
	
	public static int countPalindromic_Substring(String str) {
		boolean[][] dp = new boolean[str.length()][str.length()];
		int count = 0;
		
		for(int g=0; g<str.length(); g++) {
			for(int i=0, j=g; j<str.length(); i++, j++) {
				if(g==0) {
					dp[i][j] = true;
				}
				else if(g==1) {
					if(str.charAt(i) == str.charAt(j)) {
						dp[i][j] = true;
					}
					else {
						dp[i][j] = false;
					}
				}
				else {
					if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true) {
						dp[i][j] = true;
					}
					else {
						dp[i][j] = false;
					}	
				}
				if(dp[i][j] == true)
					count++;
			}
		}
		return count;
	}
	
	//better written code
	public static int countPalindromeUsePreprocessedApproach(String s) {
		int size = s.length();
		boolean[][] dp = new boolean[size][size];
		
		int count = s.length();
		
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
				
				if(dp[i][j]== true) 
					count++;
			}
		}
		
		return count;	
	}

	public static void main(String[] args) {
		String str = "aaa";
		//reuslt -> 6 [a, a, a, aa, aa, aaa]
		System.out.println(countPalindromic_Substring(str));
		System.out.println(countPalindromeUsePreprocessedApproach(str));
	}

}
