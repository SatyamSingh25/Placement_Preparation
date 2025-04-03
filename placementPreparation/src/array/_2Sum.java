package array;
/**
 * @2_SUM
 * @Leetcode_1
 * Problem : Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
import java.util.*;
public class _2Sum {
	//TC : O(n)
	//SC : O(n)
	public static int[] twoSum(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			int rem = target - arr[i];
			
			if(map.containsKey(rem))
				return new int[]{i, map.get(rem)};
			
			map.put(arr[i], i);
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9))); // result : [1,0]
		System.out.println(Arrays.toString(twoSum(new int[] {3,3}, 6))); // result : [1,0]
		System.out.println(Arrays.toString(twoSum(new int[] {3,2,4}, 6))); // result : [2,1]
	}

}
