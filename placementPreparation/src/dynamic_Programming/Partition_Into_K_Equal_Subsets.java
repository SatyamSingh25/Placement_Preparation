package dynamic_Programming;

import java.util.*;

public class Partition_Into_K_Equal_Subsets {
	
	public static boolean canPartitionInto_K_Equal_Subsets(int[] arr, int k) {
		int totalSum = 0;
		for(int num: arr) {
			totalSum += num;
		}
		
		if(totalSum%k != 0 || arr.length < k) {
			return false;
		}
		
		int target = totalSum / k;
		Arrays.sort(arr);
		boolean[] vis = new boolean[arr.length];
		
		return solve(0, target, 0, arr, k, vis);
	}
	
	public static boolean solve(int source, int target, int currSum, int[] arr, int k, boolean[] vis) {
		if(k==1)
			return true;
		
		if(currSum == target)
			return solve(0, target, 0, arr, k-1, vis);
				
		for(int start = source; start<arr.length; start++) {
			if(vis[start] == false && arr[start] + currSum <= target) {
				vis[start] = true;
				
				if(solve(start, target, arr[start] + currSum, arr, k, vis))
					return true;
				vis[start] = false;
			}
		}
		return false;		
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,1,2,2,2};
		System.out.println(canPartitionInto_K_Equal_Subsets(arr, 4)); //True
		arr = new int[] {2,2,2,2,2,6};
		System.out.println(canPartitionInto_K_Equal_Subsets(arr, 4)); //false
	}

}
