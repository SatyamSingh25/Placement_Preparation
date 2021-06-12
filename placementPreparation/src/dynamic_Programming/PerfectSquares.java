package dynamic_Programming;
/**
 * @contributedBY-SATYAM SINGH
 * --------------------------------------LEETCODE 279-------------------------------------------------
 * Problem link : https://leetcode.com/problems/perfect-squares/
 * Description: Given an integer n, return the least number of perfect square numbers that sum to n.
 *              A perfect square is an integer that is the square of an integer; in other words,
 *              it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect
 *              squares while 3 and 11 are not.
 *  Approach: 
 *  |0| |1| |2| |3| |4| |5| |6| |7| |8| |9| |10| |11| |12| 
 *   0   1   2   3   1   2   3   4   2   1   2    3    3
 *   
 *  Input: n = 12
    Output: 3
    Explanation: 12 = 4 + 4 + 4.
    
    Difficulty : Medium
 */
public class PerfectSquares {
	//dynamic programming
	public static int numSquares(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2; i<=n; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1; j*j<=i; j++) {
				int currPerfect = i - j*j;
				min = Math.min(min, dp[currPerfect]);
			}
			dp[i] = min+1;
		}
		for(int i=0; i<n+1; i++)
			System.out.print(dp[i] +" ");
		System.out.println();
		return dp[n];
	}
	public static void main(String[] args) {
		int n = numSquares(12);
		System.out.println(n);
	}
}
