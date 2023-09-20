package array;
/**
 * @560_Subarray_Sum_Equals_K
 * @PrefixSum-targetSum
 * @HashMap(sum -> time of came)
 */
/*----------------------------------560. Subarray Sum Equals K-----------------------------------
 * Count all subarrays who has sum equal to K.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * 
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
import java.util.*;
public class CountSubarray_sum_K {
	
	public int countSubarray(int[] arr, int targetSum) {
		HashMap<Integer, Integer> map = new HashMap<>();
		//0 comes 1 time
		map.put(0, 1);
		
		int prefixSum = 0;
		int count = 0;
		
		for(int i=0; i<arr.length; i++) {
			prefixSum += arr[i];
			int target = prefixSum - targetSum;
			
			if(map.containsKey(target)) {
				count += map.get(target);
			}
			map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
		}
		return count;
	}

	public static void main(String[] args) {
		CountSubarray_sum_K obj = new CountSubarray_sum_K();
		System.out.println(obj.countSubarray(new int[]{1,1,1}, 2)); //2 [1,1][1,1]
		System.out.println(obj.countSubarray(new int[]{1,2,3}, 3)); //2 [1,2][3]
	}

}
