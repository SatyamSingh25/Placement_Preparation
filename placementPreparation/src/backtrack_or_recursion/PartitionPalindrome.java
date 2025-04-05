package backtrack_or_recursion;
/*
 * -----------------------------------------------131. Palindrome Partitioning----------------------------------------------------------------
 * 	Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
	A palindrome string is a string that reads the same backward as forward.
	
	Example 1:
	Input: s = "aab"
	Output: [["a","a","b"],["aa","b"]]
   --------------------------------------------------------------------------------------------------------------------------------------------
 */
import java.util.*;
public class PartitionPalindrome {
	
	//Recursive approach
	public static List<List<String>> partition(String str) {
		List<List<String>> result = new ArrayList<>();
		
		solve(0, str, new ArrayList<>(), result);
		
		return result;
	}
	
	public static void solve(int start, String str, List<String> path, List<List<String>> result) {
		if(start == str.length()) { // reach till end & got all palindrome substrings till now.
			result.add(new ArrayList<>(path));
			return;
		}
		
		for(int i=start; i<str.length(); i++) {
			if(isPalindrome(str.substring(start,  i+1))) { //checking current substring was palindrome or NOT
				
				path.add(str.substring(start, i+1)); //considering current substring into answer
				
				solve(i+1, str, path, result);
				
				path.remove(path.size()-1); //removing as part of backtracking
			}
		}
	}
	
	public static boolean isPalindrome(String str) {
		int start = 0, end = str.length()-1;
		while(start <= end) {
			if(str.charAt(start++) != str.charAt(end--))
				return false;
		}
		return true;
	}

	//Dirver code
	public static void main(String[] args) {
		System.out.print(partition("aabb")); //[["a","a","b","b"],["a","a","bb"],["aa","b","b"],["aa","bb"]]		
	}

}
