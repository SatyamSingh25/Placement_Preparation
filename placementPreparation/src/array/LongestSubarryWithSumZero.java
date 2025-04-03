package array;
/**
 * @Longest_Subarray_with_Sum_0
 * https://www.naukri.com/code360/problems/longest-subarray-with-zero-sum_6783450
 * 
 * Problem :Ninja is given an array ‘Arr’ of size ‘N’. 
 *          You have to help him find the longest subarray of ‘Arr’, whose sum is 0. 
 *          You must return the length of the longest subarray whose sum is 0.
 * ------------------------------------------------------------------------------------------------------------------------------------------------         
 * Sample Input 1:
 * 4
 * 1 0 -1 1
 * 
 * Sample Output 1:
 * 3
 * 
 * Explanation of Sample Input 1:
 *      The subarrays with sums equal to zero are: {{1, 0, -1}, {0}, {0, -1, 1}, {-1, 1}}.
 *      Among these, {1, 0, -1} and {0, -1, 1} are the longest with length equal to 3.
 *      Hence the answer is 3.
 * ------------------------------------------------------------------------------------------------------------------------------------------------ 
 */
import java.util.*;
public class LongestSubarryWithSumZero {

	// if Array has +ve and -ve both this is the best solution
	// TC : O(n)
	// SC : O(n)
	public static int LongestSubarrayWithSumZero(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>(); // sum -> index
		map.put(0, -1); // initially we don't have any that why -1
		
		int max = 0;
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
			
			if(map.containsKey(sum)) { // means we seen this sum earlier which says start from that index
				max = Math.max(max, i - map.get(sum));
			}
			else 
				map.put(sum, i);
		}
		
		return max;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LongestSubarrayWithSumZero(new int[] {1,0,-1, 1})); //result 3 because {1, 0, -1}, {0, -1, 1}
	}

}
