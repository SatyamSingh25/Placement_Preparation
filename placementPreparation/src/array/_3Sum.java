package array;
/**
 * @3_SUM
 * @Leetcode_15
 * 
 * Problem : Given an integer array nums, return all the triplets 
 *           [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *           Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: 
 *    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 *    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 *    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 *    
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */
import java.util.*;
public class _3Sum {
	// TC : O(nLog(n)) + O(n^2)
	// SC :  O(no. of quadruplets) = O(1)
	public static List<List<Integer>> printAllTripetSumSubsequence(int[] arr){
		
		Set<List<Integer>> ans = new HashSet<>(); // because no duplicate is required
		
		Arrays.sort(arr); // because two point j and k , when k point to max value
		
		for(int i=0; i<arr.length-2; i++) {
			int j = i+1;
			int k = arr.length-1;
			
			while(j < k) {
				
				int sum = arr[j] + arr[k];
				
				if(sum == -arr[i]) {
					List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
					ans.add(temp);
					j++;
					k--;
				}
				else if(sum > -arr[i]){
					k--;
				}
				else if(sum < -arr[i]){
					j++;
				}
			}
		}
		
		return new ArrayList<>(ans);
		
	}
	
	//Driver code
	public static void main(String[] args) {
		System.out.println(printAllTripetSumSubsequence(new int[] {-1,0,1,2,-1,-4}));//result : [[-1,-1,2],[-1,0,1]]
		System.out.println(printAllTripetSumSubsequence(new int[] {0,1,1}));//result : []
		System.out.println(printAllTripetSumSubsequence(new int[] {0,0,0}));//result : [[0,0,0]]
	}
}
