package dynamic_Programming;

import java.util.Arrays;
/*
 * --------------------------------312. Burst Balloons----------------------------------------
 * You are given n balloons, indexed from 0 to n - 1. 
 * Each balloon is painted with a number on it represented by an array nums. 
 * You are asked to burst all the balloons.
 * 
 * If you burst the ith balloon, 
 * you will get nums[i - 1] * nums[i] * nums[i + 1] coins. 
 * If i - 1 or i + 1 goes out of bounds of the array, 
 * then treat it as if there is a balloon with a 1 painted on it.
 * 
 * Return the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * 	nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * 	coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 */
public class BurstBalloons {

	//TC: O(n*n*n)
	//SC: O(n*n) + aux space for recursion O(n) depth
	public static int maxCoins(int[] coins) {
		int[] arr = new int[coins.length+2];
		arr[0] = 1;
		arr[arr.length-1] = 1;
		
		for(int i=0; i<coins.length; i++) {
			arr[i+1] = coins[i];
		}
		
		int[][] dp = new int[coins.length+1][coins.length+1];
		for(int[] itr: dp)
			Arrays.fill(itr, -1);
		
		return helper(1, coins.length, arr, dp);
	}
	
	public static int helper(int start, int end, int[] arr, int[][] dp) {
		
		if(start > end) return 0;
		
		if(dp[start][end] != -1)
			return dp[start][end];
		
		int max = -1;
		for(int i=start; i<=end; i++) {
			int cost = arr[start-1] * arr[i] * arr[end+1];
			cost += helper(start, i-1, arr, dp) + helper(i+1, end, arr, dp);
			
			max = Math.max(max, cost);
		}
		
		return dp[start][end] = max;
		
	}
	
	public static void main(String[] args) {		
		int[] coins = new int[] {3,1,5,8};
		System.out.println(maxCoins(coins)); //167
	}

}
