package array;
/**
 * @4_Sum
 * @Leetcode_18
 * Problem : Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *   -  0 <= a, b, c, d < n
 *   - a, b, c, and d are distinct.
 *   - nums[a] + nums[b] + nums[c] + nums[d] == target
 *   
 * You may return the answer in any order
 * 
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * Example 2:
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 */
import java.util.*;
public class _4Sum {
	
	//TC : O(n^3)
	//SC : O(no.of quadrants) = O(1)
	public static List<List<Integer>> fourSumToTarget(int[] arr, int target){
		Set<List<Integer>> ans = new HashSet<>();
		
		Arrays.sort(arr); //becuase third point(start) and forth pointer(end) when end need to point to max value
		
		for(int i=0; i<arr.length-3; i++) {
			if(i>0 && arr[i] == arr[i-1]) continue; //avoiding duplicate
			
			for(int j=i+1; j<arr.length-2; j++) {
				if(j>i+1 && arr[j] == arr[j-1]) continue; //avoiding duplicate
				
				int remaining = target - (arr[i] + arr[j]);
				
				int start = j + 1;
				int end = arr.length - 1;
				
				while(start < end) {
					if(remaining == (arr[start] + arr[end])) {
						List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[start], arr[end]);
						ans.add(temp);
						start++;
						end--;
						
						while(start < end && arr[start] == arr[start - 1]) start++; //avoiding duplicate
						while(start < end && arr[end] == arr[end + 1]) end--; //avoiding duplicate
					}
					else if(remaining > (arr[start] + arr[end])) {
						start++;
					}
					else 
						end--;
				}
			}
		}
		
		return new ArrayList<>(ans);
	}
	
	public static void main(String[] args) {
		//Order can be anything of quadrants
		System.out.println(fourSumToTarget(new int[] {1,0,-1,0,-2,2}, 0)); // [[-2,0,0,2],[-2,-1,1,2],[-1,0,0,1]]
		System.out.println(fourSumToTarget(new int[] {2,2,2,2,2}, 8)); // [[2, 2, 2, 2]]
	}

}
