package dynamic_Programming;
/**
 * @author Satyam
 * @Leetcode_45  @Jump_Game_2
 * Problem Statement: Given an array you have to reach at the end of the array in minimum jumps.
 *                    Each element in the array represents your maximum jump length at that position
 *                    Note: You can assume that you can always reach the last index.

	Input: nums = [2,3,1,1,4]
	Output: 2
	Explaination: 2->3->4 (2 jumps)	
 *                    
 */
public class MinimumStepsTo_reach_end {
	//Minimum jumps to reach end in O(n) time O(1) space
	public static int minJumpsToEnd(int[] arr) {
		int jumps =0 ;
		int canReach =0;
		int max = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			if(i+arr[i] > max) {
				max = i+arr[i];
			}
			if(i==canReach) {
				jumps++;
				canReach = max;
			}
		}
		
		return jumps;
	}
	
	//minimum jumps to reach end in O(n^2) time O(n) space [DP]
	public static int minJumpsToEnd_DP(int[] arr) {
		
		Integer[] dp = new Integer[arr.length];
		
		dp[dp.length-1] = 0;
		
		for(int i=dp.length-2; i>=0; i--) {
			
			int steps = arr[i];
			int min = Integer.MAX_VALUE;
			
			for(int j=1; j<=steps && i+j < arr.length; j++) {
				
				if(dp[i+j] != null && min > dp[i+j]) {
					min = dp[i+j];
				}
			}
			
			if(min != Integer.MAX_VALUE) {
				dp[i] = min+1;
			}
		}
		
		
		return dp[0];
	}

	//Driver Code
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,1,1,4};
		System.out.println(minJumpsToEnd(arr)); //2 jumps minimum to reach end O(n) time O(1) space
		System.out.println(minJumpsToEnd_DP(arr)); //2 jumps minimum to reach end O(n^2) time O(n) space
	}

}
