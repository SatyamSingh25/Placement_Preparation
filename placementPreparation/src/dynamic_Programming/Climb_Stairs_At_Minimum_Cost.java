package dynamic_Programming;

import java.util.Arrays;

/**
 * @Climbing_Stairs_variation
 * @Climbing_Stairs_at_min_Cost
 * @React_at_the_End
 * @EASY
 */
/*
 * ---------------------------------746. Min Cost Climbing Stairs------------------------------
 * You are given an integer array cost where cost[i] is the cost of I-th step on a staircase. 
 * Once you pay the cost, you can either climb ONE or TWO STEPS.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 * 
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
	Output: 6
	Explanation: You will start at index 0.
	- Pay 1 and climb two steps to reach index 2.
	- Pay 1 and climb two steps to reach index 4.
	- Pay 1 and climb two steps to reach index 6.
	- Pay 1 and climb one step to reach index 7.
	- Pay 1 and climb two steps to reach index 9.
	- Pay 1 and climb one step to reach the top.
	The total cost is 6.
 */
public class Climb_Stairs_At_Minimum_Cost {
	
	public static int minCostClimbStairs(int[] cost) {
		
		int[] dp = new int[cost.length];
		dp[0] = cost[0];
		dp[1] = cost[1];
		
		for(int i=2; i<cost.length; i++) {
			dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
		}
		//[1, 100, 2, 3, 3, 103, 4, 5, 104, 6]
		System.out.println(Arrays.toString(dp));
		
		return Math.min(dp[dp.length-1], dp[dp.length-2]);
	}

	public static void main(String[] args) {
		int[] stairsCost = new int[] {1,100,1,1,1,100,1,1,100,1};
		//result -> 6
		System.out.println(minCostClimbStairs(stairsCost));
	}

}
