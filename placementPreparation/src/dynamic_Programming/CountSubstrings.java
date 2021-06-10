package dynamic_Programming;
/**
 * @Contributed_By Satyam Singh
 * ------------------------------------LEETCODE 647------------------------------------
 * Problem link : https://leetcode.com/problems/palindromic-substrings/
 * Description : Given a string s, return the number of palindromic substrings in it.
                 A string is a palindrome when it reads the same backward as forward.
                 A substring is a contiguous sequence of characters within the string.
   
   Input: s = "abc"
   Output: 3
   Explanation: Three palindromic strings: "a", "b", "c".
   
   Input: s = "aaa"
   Output: 6
   Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
   
   Difficulty : Medium
 *
 */
public class CountSubstrings {

	//Dynamic Programming - Diagonal Traversal - O(n^2)
	public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count=0;
        for(int g=0; g<s.length(); g++)
            for(int i=0,j=g; j<dp.length; i++, j++){
                if(g == 0){
                    dp[i][j] = true;
                }
                else if(g==1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j]){
                    count++;
                }
            }
        return count;
    }
}
