package dynamic_Programming;
/**
 * @Dynamic_Programming
 * @contributer_Satyam_Singh
 *
 * counting all paths form start of matrix to end of the matrix.
 */
import java.util.Scanner;
public class All_paths_from_Start_to_END {
	//recursive approach
	//exponential time complexity
	public static void recursiveAppraoch(int[][] dp) {
		System.out.println(recursiveHelper(dp.length, dp[0].length));
	}
	public static int recursiveHelper(int n, int m) {
		if(n==1 || m==1) {
			return 1;
		}
		return  recursiveHelper(n-1, m)+recursiveHelper(n, m-1);
	}
	
	//Dynamic programming approach
	//O(n^2) time complexity
	public static void DynamicApproach(int[][] dp) {
		//first row all are marking 1
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = 1;
		}
		//first column all are marking 1
		for(int j=0; j<dp[0].length; j++) {
			dp[0][j] = 1;
		}
		//counting all down or right paths
		for(int i=1; i<dp.length; i++) {
			for(int j=1 ; j<dp[0].length; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		//printing dp array
		for(int i=0; i<dp.length; i++) {
			for(int j =0 ; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		//result on dp[n-1][m-1]
		System.out.println("Total number of path ussingh DYNAMIC PROGRAMMING: "+dp[dp.length-1][dp[0].length-1]+ "\n");
	}
	//main Method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] dp = new int[sc.nextInt()][sc.nextInt()];
		
		/*
		 * 3
		 * 3
		 * 1 1 1 
		 * 1 2 3 
		 * 1 3 6 
		 * Total number of path ussingh DYNAMIC PROGRAMMING: 6
		 */
		DynamicApproach(dp);
		recursiveAppraoch(dp); // 6
		sc.close();
	}
}
