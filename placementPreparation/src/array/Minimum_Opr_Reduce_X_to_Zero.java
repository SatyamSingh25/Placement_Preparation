package array;
/**
 * @Minimum_Opr_Reduce_X_to_Zero
 * @Take_left_or_Right_only
 * @Make_X_to_ZERO_by_using_lef_or_right_at_time
 * @PrefixSum
 * @HashMap
 * @MaxSubarray_with_sum_K
 */
/*-----------------------------------1658. Minimum Operations to Reduce X to Zero----------------------------------------
 * You are given an integer array nums and an integer x. In one operation, 
 * you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. 
 * 
 * Note that this modifies the array for future operations.
 * 
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
 * 
 * Example 1:
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 * 
 * Example 2:
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * 
 * Example 3:
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements 
 *              (5 operations in total) to reduce x to zero.
 */
import java.util.*;
public class Minimum_Opr_Reduce_X_to_Zero {
	
	public int minOperation(int[] nums, int k) {
		int targetSum = Arrays.stream(nums).sum() - k;
		
		if(targetSum == 0) return nums.length;
		
		int maxLen = maxSubarrayLenSumK(nums, targetSum);
		return maxLen == -1 ? -1 : nums.length - maxLen;
	}
	
	public static int maxSubarrayLenSumK(int[] nums, int k) {
		int maxLen = -1;
		int prefixSum = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		
		for(int i=0; i<nums.length; i++) {
			prefixSum += nums[i];
			int target = prefixSum - k;
			
			if(map.containsKey(target)) {
				maxLen = Math.max(maxLen, (i - map.get(target)));
			}
			
			map.put(prefixSum, i);
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		Minimum_Opr_Reduce_X_to_Zero obj = new Minimum_Opr_Reduce_X_to_Zero();
		System.out.println(obj.minOperation(new int[] {1,1,4,2,3}, 5)); //2
		System.out.println(obj.minOperation(new int[] {5,6,7,8,}, 4)); //-1
		System.out.println(obj.minOperation(new int[] {3,2,20,1,1,3}, 10)); //5
		
	}

}
