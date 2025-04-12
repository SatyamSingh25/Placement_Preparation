package greedy;

import java.util.Arrays;

/**
 * @StriverSheet
 * @unbounded_Knapsack
 * @Greedy
 * @Coin_Change – Minimum Coins to Make a Given Sum
 * Problem : You are given: An array coins[] of n distinct coin denominations, 
 *           where each coins[i] is a positive integer.
 *           An integer amount representing the total value you need to make.
 * Input :         
 * coins = [25, 3, 7]
 * amount = 30
 * 
 * output : 6 => [7*3 + 3*3]
 */
public class _6_Min_Coin_for_Amount {
	//Recursion
	// TC : O(2^capacity)
	// SC : O(capacity) -> (stack space)
	public static int minCoins(int start, int[] coins, int capacity) {	
		if(capacity == 0) return 0;
		
		if(start == 0) 
			if(capacity % coins[start] == 0) 
				return capacity / coins[start];
			else
				return (int)1e9;
		
		int notTake = minCoins(start - 1, coins, capacity);
		
		int take = (int)1e9;
		if(coins[start] <= capacity)
			take = 1 + minCoins(start, coins, capacity - coins[start]);
		
		return Math.min(notTake, take);
	}
	
	//Memoization
	//TC : O(n * capacity)
	//Sc : O(n * capacity)
	public static int minCoins_Memoization(int start, int[] coins, int capacity, int[][] dp) {	
		if(capacity == 0) return 0;
		
		if(start == 0)
			if(capacity % coins[start] == 0)
				return capacity / coins[start];
			else
				return (int)1e9;
		
		if(dp[start][capacity] != -1) return dp[start][capacity];
		
		int notTake = minCoins_Memoization(start - 1, coins, capacity, dp);
		
		int take = (int)1e9;
		if(coins[start] <= capacity)
			take = 1 + minCoins_Memoization(start, coins, capacity - coins[start], dp);
		
		return dp[start][capacity] = Math.min(notTake, take);
		
	}

	public static void main(String[] args) {
		System.out.println(minCoins(2, new int[] {25, 3, 7}, 30)); //6 => [7*3 + 3*3]
		
		int[][] dp = new int[3][30+1];
		for(int[] d: dp)
			Arrays.fill(d, -1);
		System.out.println(minCoins_Memoization(2, new int[] {25, 3, 7}, 30, dp)); //6 => [7*3 + 3*3]
	}

}
