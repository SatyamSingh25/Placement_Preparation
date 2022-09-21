package dynamic_Programming;
/**
 * @DP
 * @Longest_Repeated_Subarray
 * If found arr[i] == arr[j] then dp[i][i] = dp[i-1][j-1]+1 and take max till current
 */
/*---------------------------------718. Maximum Length of Repeated Subarray--------------------------------------
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 * 	
 * 	Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
	Output: 3
	Explanation: The repeated subarray with maximum length is [3,2,1].
 */
import java.util.*;
public class Longest_Repeared_Subarray {

	//Time and space: O(n^2)
	public static int longestReapeatedSubarray(int[] arr1, int[] arr2) {
		int[][] dp = new int[arr1.length+1][arr2.length+1];
		int max = 0;
		
		for(int i=1; i<arr1.length+1; i++) {
			for(int j=1; j<arr2.length+1; j++) {
				
				if(arr1[i-1] == arr2[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
					max = Math.max(max, dp[i][j]);
				}
				
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr1 = new int[]{1,2,3,2,1};
		int[] arr2 = new int[]{3,2,1,4,7};
		
		System.out.println(longestReapeatedSubarray(arr1, arr2)); //result = 3 (3,2,1)
		System.out.println(longestReapeatedSubarray(new int[] {0,0,0,0,0}, new int[] {0,0,0,0,0})); //result = 5 (0,0,0,0,0)
	}

}
