package dynamic_Programming;
/**
 * @contributed Satyam Singh
 * -----------------------LEETCODE 392----------------------------------------------------------------------
 *	Problem link : https://leetcode.com/problems/is-subsequence/
 *	Description : Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
                  A subsequence of a string is a new string that is formed from the original string by
                  deleting some (can be none) of the characters without disturbing the relative positions
                  of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *	Input: s = "abc", t = "ahbgdc"
	Output: true
	
 *	Difficulty : Easy
 */
public class Is_Subsequence {
	//method
	public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        int curr = 0;
        for(int i=0; i<t.length(); i++){
            if(s.charAt(curr)==t.charAt(i)){
                curr++;                
            }
            if(curr == s.length()){
                return true;
            }
        }
        return false;
    }
}
