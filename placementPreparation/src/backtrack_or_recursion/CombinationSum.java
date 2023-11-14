package backtrack_or_recursion;
import java.util.*;
public class CombinationSum {
	
	public static List<List<Integer>> combinationSum(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<>();
		
		helper(0, 0, target, new ArrayList<>(), res, arr);
		
		return res;
	}
	
	public static void helper(int start, int currSum, int target, List<Integer> innerList, List<List<Integer>> res, int[] arr) {
		if(currSum == target) {
			res.add(new ArrayList<>(innerList));
			return;
		}
		
		if(currSum < 0 || currSum > target)	return;
		
		for(int i=start; i<arr.length; i++) {
			innerList.add(arr[i]);
			helper(i, currSum + arr[i], target, innerList, res, arr);
			innerList.remove(innerList.size()-1);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] {2,3,6,7};
		int target = 7;
		
		System.out.println(combinationSum(arr, target));
		
			
	}

}
