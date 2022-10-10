package backtrack_or_recursion;
/*
 * -----------------------------------------------131. Palindrome Partitioning----------------------------------------------------------------
 * 	Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
	A palindrome string is a string that reads the same backward as forward.
	
	Example 1:
	Input: s = "aab"
	Output: [["a","a","b"],["aa","b"]]
 */
import java.util.*;
public class PartitionPalindrome {
	
	public static List<List<String>> partition(String str) {
		List<List<String>> result = new ArrayList<>();
		List<String> path = new ArrayList<>();
		
		partitionHelper(0, str, path, result);
		return result;
	}
	public static void partitionHelper(int start, String str, List<String> path, List<List<String>> result) {
		if(start == str.length()) {
			result.add(new ArrayList<>(path));
			return;
		}
		
		for(int i=start; i<str.length(); i++) {
			if(isPalindrome(str, start, i)) {
				path.add(str.substring(start, i+1));
				partitionHelper(i+1, str, path, result);
				path.remove(path.size()-1);
			}
		}
	}
	public static boolean isPalindrome(String str, int start, int end) {
		while(start <= end) {
			if(str.charAt(start++) != str.charAt(end--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "aabb";
		List<List<String>> result = partition(str);
		for(List<String> res: result)
			System.out.println(res);
		
	}

}
