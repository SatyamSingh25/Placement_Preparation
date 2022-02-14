package array;
/**
 * @author Satyam
 * @Leetcode_525 Contiguous Array
 * link: https://leetcode.com/problems/contiguous-array/
 * Problem Statement: Given a binary array nums,return the maximum length of a contiguous subarray
 *                    with an equal number of 0 and 1.
 *                    
 *  Input: nums = [0,1,0]
	Output: 2
	Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
	
	Difficulty: Medium
	Tag: Array, Map, Prefix Sum
 */
import java.util.HashMap;
public class LongestArray_with_same_count_of_0_and_1 {
	//Method
	public static int longestContiguousArray(int[] arr) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0,  -1);
		
		int count = 0, max = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 1) {
				count++;
			}
			else {
				count--;
			}
			
			if(map.containsKey(count)) {
				max = Math.max(max, i-map.get(count));
			}
			else {
				map.put(count, i);
			}
		}
		
		return max;
	}
	//Driver Code
	public static void main(String[] args) {
		int[] arr = new int[] {0,1,0};
		System.out.println(longestContiguousArray(arr));
	}

}
