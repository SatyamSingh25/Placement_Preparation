package backtrack_or_recursion;
/**
 * @CombinationSum_1
 * @StriverSheet : https://takeuforward.org/data-structure/combination-sum-1/
 * @Leetcode_39
 * 
 * Problem:-  Given an array of distinct integers candidates and a target integer target, 
 *         -  return a list of all unique combinations of candidates where the chosen numbers sum to target. 
 *         -  You may return the combinations in any order.
 *         -  The same number may be chosen from candidates an unlimited number of times. 
 *         -  Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * ------------------------------------------------------------------------------------------------------------------------------
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 *              2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 *              7 is a candidate, and 7 = 7.
 *              These are the only two combinations.
 * -------------------------------------------------------------------------------------------------------------------------------
 */
import java.util.*;
public class CombinationSum {
	//Recursive approach
	public static List<List<Integer>> combinationSum(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<>(); // result
		
		helper(0, 0, target, new ArrayList<>(), res, arr);
		
		return res;
	}
	
	public static void helper(int start, int currSum, int target, List<Integer> innerList, List<List<Integer>> res, int[] arr) {
		if(currSum < 0 || currSum > target)	return; //Edge cases
		
		if(currSum == target) { //Reach to target
			res.add(new ArrayList<>(innerList));
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			currSum = currSum + arr[i]; //taking arr[i] in calculation
			innerList.add(arr[i]); //adding into innerList as taking current element into consideration
			
			
			helper(i, currSum, target, innerList, res, arr); //not i+1 because we can use same number any number of time
			
			currSum = currSum - arr[i]; //removing as part of backtracking
			innerList.remove(innerList.size()-1); // removing as part of backtracking
		}
	}

	//Driver Code
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,6,7};
		int target = 7;
		
		System.out.println(combinationSum(arr, target)); //[[2, 2, 3], [7]]
		
			
	}

}
