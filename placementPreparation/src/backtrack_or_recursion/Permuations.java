package backtrack_or_recursion;
import java.util.*;
/**
 * @author Satyam
 * Leetcode Permutations
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 * 
 * Examples:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]
 */
public class Permuations {
	private static List<List<Integer>> res = new ArrayList<>();
	
	public static List<List<Integer>> permute(int[] arr){
		boolean[] vis = new boolean[arr.length];
		
		solve(arr.length, vis, arr, new ArrayList<>());
		return res;
	}
	
	public static void solve(int n, boolean[] vis, int[] arr, ArrayList<Integer> innerList) {
		
		if(innerList.size() == n) {
			res.add(new ArrayList<>(innerList));
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(vis[i] == false) {
				innerList.add(arr[i]);
				vis[i] = true;
				solve(n, vis, arr, innerList);
				vis[i] = false;
				innerList.remove(innerList.size()-1);
			}
		}
		
	}

	public static void main(String[] args) {
		int[] arr =  new int[]{1,2,3};
		
		//[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
		System.out.println(permute(arr));
	}

}
