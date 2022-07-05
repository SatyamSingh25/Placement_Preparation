package array;
/**
 * @author Satyam
 * @Leetcode_128
 * @Longest_Consecutive_Subsequence
 * @HashSet_or_HashMap Both can be used
 */
/**
 * ---------------------------------------------128. Longest Consecutive Subsequence-----------------------------
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * Input: array[] {100, 1, 102, 2, 3}
 * output: 3
 * Explanation: longest consecutive subsequence is {1,2,3} which is length is 3.
 */
import java.util.*;
public class Longest_Consecutive_Subsequence {
	//Time: O(n) + O(n) + O(n)
	//Space: O(n)
	public static int longestConsecutiveSubsequence(int[] array) {
		//storing all the element in set to check in O(1) time 
		//to whether search number is present in the array or not 
		HashSet<Integer> set = new HashSet<>();
		
		for(int num: array) {//adding elements in SET
			set.add(num);
		}
		
		int maxCount = 0; //maxCount = max longest Consecutive subsequence length
		
		for(int num: array) {
			if(set.contains(num-1) == false) { //means it is a starting point of a subsequence
				
				int currNum = num;
				int currCount = 1; //current consecutive subsequence length 
				
				while(set.contains(currNum+1)) { //while next possible number is available in SET
					currNum++;
					currCount++;
				}
				
				maxCount = Math.max(maxCount, currCount); // max Consecutive subsequence length
				
			}
		}
		
		return maxCount; //result
	}

	//Main Method
	public static void main(String[] args) {
		int[] arr = new int[] {100, 1, 101, 2, 3};
		//result -> 3
		System.out.print(longestConsecutiveSubsequence(arr));
		
	}

}
