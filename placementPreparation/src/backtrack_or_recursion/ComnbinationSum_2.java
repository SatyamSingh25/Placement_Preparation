package backtrack_or_recursion;
/**
 * @CombinationSum_2_print_unique_combintation_sum
 * @StriverSheet : https://takeuforward.org/data-structure/combination-sum-ii-find-all-unique-combinations/
 * @leetcode_40
 * 
 * Problem : Given a collection of candidate numbers (candidates) and a target number (target), 
 *           find all unique combinations in candidates where the candidate numbers sum to target.
 *           
 *           Each number in candidates may only be used once in the combination.
 *           
 *    Note: The solution set must not contain duplicate combinations.
 * ------------------------------------------------------------------------------------------------------------------------
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output: 
 * [
 *  [1,1,6],
 *  [1,2,5],
 *  [1,7],
 *  [2,6]
 * ]
 * ------------------------------------------------------------------------------------------------------------------------
 */
import java.util.*;
public class ComnbinationSum_2 {
	//Recursion with backtrack
	// TC : O(2^n * n )
	public static List<List<Integer>> CombinationSum_print_unique_combination(int[] arr, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		
		Arrays.sort(arr); // help to avoid duplicates
		
		solve(0, 0, target, new ArrayList<>(), arr, ans);
		
		return ans;
	}
	
	public static void solve(int start, int currSum, int target, List<Integer> innerList, int[] arr, List<List<Integer>> ans) {
		if(currSum < 0 || currSum > target) return; //Edge cases
		
		if(currSum == target) { //reach till target
			ans.add(new ArrayList<>(innerList));
			return;
		}
		
		for(int i = start; i<arr.length; i++) {
			if(i > start && arr[i] == arr[i-1]) continue; //avoiding duplicates
			
			currSum = currSum + arr[i]; //considering current element into calculation
			innerList.add(arr[i]); //adding into list as considered the current element in calculation
			
			solve(i + 1, currSum, target, innerList, arr, ans); // i + 1 because we can use a element single time only
			
			currSum = currSum - arr[i]; //removing as part of backtracking
			innerList.remove(innerList.size()-1); //removing as part of backtracking
		}
	}

	//Driver Code
	public static void main(String[] args) {
		
		//[[1,1,6],[1,2,5],[1,7],[2,6]]
		System.out.println(CombinationSum_print_unique_combination(new int[] {10,1,2,7,6,1,5}, 8));
	}

}
