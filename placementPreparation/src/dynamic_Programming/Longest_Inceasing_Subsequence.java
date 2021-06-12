package dynamic_Programming;
/**
 * @Contributer-Satyam Singh
 * ----------------------------------------------LEETCODE 300--------------------------------------------------
 * Problem link : https://leetcode.com/problems/longest-increasing-subsequence/
 * description : Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * 
 * INPUTS :- 
 * 	Input: nums = [10,9,2,5,3,7,101,18]
   	Output: 4
   
   	Input: nums = [7,7,7,7,7,7,7]
   	Output: 1
   
   difficuly = Medium   
 */
public class Longest_Inceasing_Subsequence {
	public static int LIS(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		dp[0] = 1;
		int finalMax = 1;
		for(int i=1; i<n; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max+1;
			finalMax = Math.max(finalMax, dp[i]);
		}
		return finalMax;
	}
}
