package set;
/**
 * @Sliding_Window
 * @Set
 * @Remove arr[start] while arr[end] present at the set
 * @Time: O(n)
 * @Space: O(k) Set Size  
 */
/*--------------------------------2461. Maximum Sum of Distinct Subarrays With Length K----------------------------------------
 * You are given an integer array nums and an integer k. 
 * Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
 * 
		* The length of the subarray is k, and
		* All the elements of the subarray are distinct.
	
   Return the maximum subarray sum of all the subarrays that meet the conditions. 
   If no subarray meets the conditions, return 0.
   A subarray is a contiguous non-empty sequence of elements within an array.
   
   Input: nums = [1,5,4,2,9,9,9], k = 3
   Output: 15 
   explaination = [5,4,9] = 15 which is max with distinct elements of subarray size 3
 */
import java.util.*;
public class MaxSum_Subarray_with_Distinct_Elements_size_K {
	
	public static long MaxSum_Subarray_K_size_distinc_element(int[] arr, int k) {
		int size = arr.length;
		
		HashSet<Integer> set = new HashSet<>();
		int start = 0, end = 0;
		long currSum = 0l, max = 0l;
		
		
		while(end < size) {
			int currVal = arr[end];
			System.out.println("currval = " + currVal);
			
			while((set.contains(currVal) || (end - start + 1) > k) && start < end) {
				currSum -= arr[start];
				set.remove(start);
				System.out.println("currSum after removing: " + currSum);
				start++;
			}
			
			currSum += currVal;
			set.add(currVal);
			System.out.println("set: " + set);
			System.out.println("currSum: " + currSum);
			
			if(end - start + 1 == k) {
				max = Math.max(max, currSum);
			}
			System.out.println("max: " + max + "\n");
			end++;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,5,4,2,9,9,9};
		System.out.println(MaxSum_Subarray_K_size_distinc_element(arr, 3)); //result -> 15
		
		arr = new int[] {4,4,4};
		System.out.println(MaxSum_Subarray_K_size_distinc_element(arr, 3)); //result -> 0
	}

}
