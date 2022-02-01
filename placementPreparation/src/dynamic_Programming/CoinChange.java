package dynamic_Programming;
import java.util.*;
/**
 * @Contrinbuted Satyam Singh
 * Problem link : https://leetcode.com/problems/coin-change/
 * Difficulty : Medium
 * tag: DP, Array
 */
public class CoinChange {
	//dynamic programming approach
	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
		for(int i=1; i<=amount; i++) {
			for(int coin: coins) {
				if(i >= coin) {
					dp[i] = Math.min(dp[i], dp[i-coin]+1);
				}
			}
		}
		return dp[amount];
	}
	//Driver Code
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,5};
		System.out.println(coinChange(arr, 11));
	}
}
