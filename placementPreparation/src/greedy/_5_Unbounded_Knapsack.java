package greedy;

import java.util.Arrays;

/**
 * @Unbounded_Knapsack
 * @Greedy
 * @Unilimited_Supply
 * @Recursion_Memoization_Tabulation
 */
public class _5_Unbounded_Knapsack {
	
	//Recursion
	public static int unboundedKnapsack_Recursion(int end, int capacity, int[] weight, int[] value) {
		if(capacity == 0) 
			return 0;
		
		if(end == 0) {
			if(weight[end] <= capacity)
				return capacity/weight[end]*value[end];
			else
				return 0;
		}
		
		int notTake = unboundedKnapsack_Recursion(end-1, capacity, weight, value);
		
		int take = 0;
		if(weight[end-1] <= capacity)
			take = value[end-1] + unboundedKnapsack_Recursion(end-1, capacity - weight[end-1], weight, value);
		
		return Math.max(take, notTake);
	}
	
	//Recursion + memoization
	public static int unboundedKnapsack_Memoization(int end, int capacity, int[] weight, int[] value, int[][] dp) {
		if(capacity == 0) 
			return 0;
		
		if(end == 0) {
			if(weight[end] <= capacity)
				return capacity/weight[end]*value[end];
			else
				return 0;
		}
		
		if(dp[end][capacity] != -1) return dp[end][capacity];
		
		int notTake = unboundedKnapsack_Memoization(end-1, capacity, weight, value, dp);
		
		int take = 0;
		if(weight[end-1] <= capacity)
			take = value[end-1] + unboundedKnapsack_Memoization(end-1, capacity - weight[end-1], weight, value, dp);
		
		return dp[end][capacity] = Math.max(take, notTake);
	}
	
	//Tabulation
	public static int unboundedKnapsack_Tabulation(int[] weight, int[] value, int capacity) {
		int n = weight.length;
		
		// 2D dp array where dp[i][w] represents maximum value for first i items and capacity w
	    int[][] dp = new int[n+1][capacity+1];
	    
	    // Build the dp table
	    for (int i = 1; i <= n; i++) {
	        for (int w = 0; w <= capacity; w++) {
	            if (weight[i-1] <= w) {
	                dp[i][w] = Math.max(dp[i-1][w], dp[i][w - weight[i-1]] + value[i-1]);
	            } else {
	                dp[i][w] = dp[i-1][w];
	            }
	        }
	    }
	    
	    return dp[n][capacity];
	}
	
	//Driver code
	public static void main(String[] args) { 
		int[] weight = {1, 3, 4, 5};
		int[] value = {20, 30, 50, 70};
		int capacity = 8;
		
		int[][] dp = new int[weight.length+1][capacity+1];
		for(int[] d: dp)
			Arrays.fill(d,  -1);
		
		//160
		System.out.println("Maximum value in knapsack Recursion: " + unboundedKnapsack_Recursion(weight.length, capacity, weight, value));
		System.out.println("Maximum value in knapsack Memoization: " + unboundedKnapsack_Memoization(weight.length, capacity, weight, value, dp));
		System.out.println("Maximum value in knapsack Tabulation: " + unboundedKnapsack_Tabulation(weight, value, capacity));
	}

}
