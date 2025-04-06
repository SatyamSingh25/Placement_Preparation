package string;

import java.util.*;
public class PalindromeDP {
	
	public static boolean[][] preprocessedPalindrome(String s){
		int size = s.length();
		boolean[][] dp = new boolean[size][size];
		
		for(int i=0; i<size; i++)
			dp[i][i] = true;
		
		for(int len = 2; len <= size; len++) {
			for(int i=0; i<=size-len; i++) {
				int j = i + len - 1;
				
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

	public static void main(String[] args) {
		boolean[][] dp = preprocessedPalindrome("ababa");
		for(boolean[] arr: dp)
			System.out.println(Arrays.toString(arr));

	}

}
