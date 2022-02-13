package dynamic_Programming;
/**
 * @author Satyam
 * @Coin_Change_2
 * Problem statement: number of combination to make amopunt with given coins.
 *                    infinite number of coins is used.
 * 
 * Input: amount = 5, coins = [1,2,5]
   Output: 4
   Explanation: there are four ways to make up the amount:
				   5=5
				   5=2+2+1
				   5=2+1+1+1
				   5=1+1+1+1+1
 *
 * Difficulty: Medium
 * tag: DP
 */
public class Coin_Change_2 {
	//number of combination to make amopunt with given coins
	public static int CountAllConbiationsToMakeAmount(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		dp[0] =1;
		for(int coin: coins) {
			for(int i=coin; i<=amount; i++) {
				dp[i] = dp[i]+dp[i-coin];
			}
		}
		return dp[amount];
	}
	//Driver code
	public static void main(String[] args) {
		int[] coins = new int[] {1,2,5};
		int amount = 15;
		System.out.println(CountAllConbiationsToMakeAmount(coins, amount));
	}

}
