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
import java.util.*;
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
	
	//Binary Search 
	//TC : O(nlog(n))
	//SC : O(n)
	public static int LIS_BinarySearch(int[] arr) {
		List<Integer> result = new ArrayList<>(); //result array
		
		for(int num: arr) {
			int possibleIndex = lowerBound(result, num); //exact place or just greate element index will be returned
			
			if(possibleIndex < result.size()) //if place found in existing array
				result.set(possibleIndex, num);
			else
				result.add(num); //add at last
		}
		
		return result.size();
	}
	
	//exact place or just greate element index will be returned
	//LowerBound -> BinarySearch
	public static int lowerBound(List<Integer> arr, int target) {
		int ans = arr.size(); //default at the last
		int start = 0, end = arr.size()-1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr.get(mid) >= target) {
				ans = mid;
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {10,9,2,5,3,7,101,18}; //4
		System.out.println(LIS(arr));
		System.out.println(LIS_BinarySearch(arr));
	}
}
