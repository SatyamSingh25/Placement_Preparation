package array;
/**
 * @LongestSubarrayWithSumK
 * https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_6682399
 * 
 * Problem : You are given an array 'a' of size 'n' and an integer 'k'.
 *           Find the length of the longest subarray of 'a' whose sum is equal to 'k'.
 * ---------------------------------------------------------------------------------------------------------------
 * Example :
 * Input: n = 7 , target = 3
 * arr = [1, 2, 3, 1, 1, 1, 1]
 * 
 * Output: 3
 * Explanation: 
 *     Subarrays whose sum = ‘3’ are:
 *     [1, 2], [3], [1, 1, 1] and [1, 1, 1]
 *     Here, the length of the longest subarray is 3, which is our final answer.
 * ---------------------------------------------------------------------------------------------------------------
 */
import java.util.*;
public final class LongestSubarrayWithSumK {

	// Optimal if Array has +ve and -ve both this is the best solution
	// TC : O(n)
	// SC : O(n)
	static int count  =0;
	public static int longestSubarryWithSumK(int[] arr, int target) {
		HashMap<Long, Integer> map = new HashMap<>(); //sum -> till current index
		
		long sum = 0l; //long because sum can increase the limit of int in java
		int max = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
			
			if(sum == target) {
				max = Math.max(max, i + 1);
				count++;//currSum = target that means ki yaha tak saara poora subarray ban gya 0 to i tak
			}
			
			long remaining = sum - target;
			if(map.containsKey(remaining)) {
				max = Math.max(max, i - map.get(remaining)); //found a prev index from where we can find our curr subarray whose sum is target
				count++;
			}
			
			if(!map.containsKey(sum))
				map.put(sum, i); //till now we this much prefixSum
		}
		return max;
	}
	
	// Optimal if Array contain only +ve numbers
	// TC : O(n)
	// SC : O(1)
	public static int LongestSubarrayWithSumZero_only_positive_Number(int[] arr, int target) {
		int start = 0;
		int end = 0;
		int sum = arr[0];
		int max = 0;
		
		while(end < arr.length) {
			
			if(start <= end && sum > target) {
				sum -= arr[start];
				start++;
			}
			
			if(sum == target)
				max = Math.max(max, end - start + 1);
			
			end++;
			if(end < arr.length)
				sum = sum + arr[end];
		}
		return max;
	}

	//Driver Code
	public static void main(String[] args) {
		System.out.println(longestSubarryWithSumK(new int[] {1, 2, 3, 1, 1, 1, 1}, 3));// result 3
		System.out.println(LongestSubarrayWithSumZero_only_positive_Number(new int[] {1, 2, 3, 1, 1, 1, 1}, 3));// result 3
		System.out.println(count);
	}

}
