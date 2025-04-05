package backtrack_or_recursion;
/**
 * @Subset Sum : Sum of all Subsets
 * @StriverSheet : https://takeuforward.org/data-structure/subset-sum-sum-of-all-subsets/
 * Problem : Given an array print all the sum of the subset generated from it, in the increasing order.
 * 
 * Input: 
 * N = 3, 
 * arr[] = {5,2,1}
 * 
 * Output: 0,1,2,3,5,6,7,8
 * Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are 
 *              [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8
 * -------------------------------------------------------------------------------------------------------------
 */
import java.util.*;
public class SubsetSum_All {
	
	//Recursive
	// TC : O(2^n)
	// SC : recursive stack
	public static ArrayList<Integer> sumOfAllsubsets(int[] arr){
		ArrayList<Integer> res = new ArrayList<>();
		
		solve(0, 0, arr, res);
		Collections.sort(res);
		
		return res;
	}
	
	//Recursive Helper
	public static void solve(int start, int sum, int[] arr, ArrayList<Integer> res) {
		if(start == arr.length) {
			res.add(sum);
			return;
		}
		
		solve(start + 1, sum + arr[start], arr, res);
		solve(start + 1, sum, arr, res);
	}
	
	/*----------------------------------------------------------------------------------------------------*/
	
	//BSF approach
	//TC : O(n)
	//SC : O(n)
	public static ArrayList<Integer> sumOfAllSubset_iterative(int[] arr) {
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(0);
		
		for(int num: arr) {
			int size = ans.size(); // till curr sum we will add
			
			for(int i=0; i<size; i++) {
				ans.add(num + ans.get(i)); // adding curr + existing sum to result
			}
		}
		
		return ans;
	}
	

	//Driver Code
	public static void main(String[] args) {
		//Recurive Approach
		System.out.println(sumOfAllsubsets(new int[] {1, 2, 3})); //[0, 1, 2, 3, 3, 4, 5, 6]
		
		//BSF approach
		System.out.println(sumOfAllSubset_iterative(new int[] {1, 2, 3})); //[0, 1, 2, 3, 3, 4, 5, 6]
	}

}
