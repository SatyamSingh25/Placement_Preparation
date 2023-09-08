package array;
import java.util.HashMap;
/**
 * @Count_Number_of_contiguous_Subarrays_whose_Sums_is_Divisible_By_K
 * @Leetcode_974
 * @Prefix_Sum
 * @CurrentSum_reminder
 */
/*--------------------------------------974. Subarray Sums Divisible by K---------------------------------------------------
 * 	Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
	A subarray is a contiguous part of an array.
	
	Input: nums = [4,5,0,-2,-3,1], k = 5
	Output: 7
	Explanation: There are 7 subarrays with a sum divisible by k = 5:
				[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 
 */
//Time complexity: O(n)
//Space Complexity: O(n)

public class CountContiguous_Subarrays_Sum_divisible_by_K {
	
	public static int countSubarrays_sum_div_by_k(int[] arr, int k) {
		int count = 0;
		int sum = 0; //sum till now - basically [Prefix-Sum] 
		int rem = 0; //remaining value to add 
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		
		for(int i: arr) {
			sum += i;
			rem = sum % k; //how much value is left to added to it divisible by k
			if(rem < 0) {
				rem += k; //if remider is negative then add k
			}
			
			if(map.containsKey(rem)) {
				count += map.get(rem); //first add the till now possible subarrays
				map.put(rem, map.get(rem)+1); //then increase the count of frequency
			}
			else {
				map.put(rem, 1); //first time reminder coming means it's just the starting of subarray
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {4,5,0,-2,-3,1};
		System.out.println(countSubarrays_sum_div_by_k(arr, 5));
	}

}
