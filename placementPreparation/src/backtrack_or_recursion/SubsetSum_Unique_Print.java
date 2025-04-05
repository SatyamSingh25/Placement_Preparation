package backtrack_or_recursion;
/**
 * @Print_all_the_Unique_Subsets
 * @Striver_Sheet : https://takeuforward.org/data-structure/subset-ii-print-all-the-unique-subsets/
 * @Leetcod_78
 * 
 * Problem : Given an array of integers that may contain duplicates the task is to return all possible subsets. 
 *           Return only unique subsets and they can be in any order.
 * ------------------------------------------------------------------------------------------------------------------------------------------
 * Input: array[] = [1,2,2]
 * Output: [ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]
 * 
 * Explanation: We can have subsets ranging from  length 0 to 3. 
 *              which are listed above. Also the subset [1,2] appears twice but is printed only once as we require only unique subsets.
 * ------------------------------------------------------------------------------------------------------------------------------------------
 */
import java.util.*;
public class SubsetSum_Unique_Print {

	//Recursive approach
	// TC : O(2^n)
	public static List<List<Integer>> printAllUniqueSubsets(int[] arr) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(arr); // help to avoid duplicates
		
		solve(0, new ArrayList<>(), arr, res);
		
		return res;
	}
	
	public static void solve(int start, ArrayList<Integer> innerList, int[] arr, List<List<Integer>> ans) {
		ans.add(new ArrayList<>(innerList)); //adding current list, because its a subset as well
		
		for(int i=start; i<arr.length; i++) {
			if(i > start && arr[i] == arr[i-1]) continue; //avoiding duplicates
			
			innerList.add(arr[i]); //pick current element
			
			solve(start + 1, innerList, arr, ans);
			
			innerList.remove(innerList.size()-1); //remove curr element post recursion = backtracking
		}
	}
	
	
	//Driver Code
	public static void main(String[] args) {
		//recursive approach
		System.out.println(printAllUniqueSubsets(new int[] {1,2,2}));//[ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]
	}

}
