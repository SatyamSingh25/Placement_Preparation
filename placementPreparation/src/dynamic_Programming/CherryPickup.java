package dynamic_Programming;

import java.util.Arrays;

public class CherryPickup {
	
	public static int maximumChocolates(int row, int col, int[][] mat) {
		int[][][] dp = new int[row][col][col];
		
		for(int[][] arr: dp)
			for(int[] itr: arr)
				Arrays.fill(itr, -1);
		
		return helper(0, 0, col-1, row, col, mat, dp);
	}
	
	public static int helper(int i, int j1, int j2, int row, int col, int[][] mat, int[][][] dp) {
		//base case
		if(j1 < 0 || j1 >= col || j2 < 0 || j2 >= col)
			return Integer.MIN_VALUE;
		
		if(i == row-1)
			if(j1 == j2) //both alice and bob pointing to same cell
				return mat[i][j1];
			else 
				return mat[i][j1] + mat[i][j2];
		
		if(dp[i][j1][j2] != -1)
			return dp[i][j1][j2];
		
		//exploring all possible paths
		//for each Alice steps Bob has 3 steps
		int max = 0;
		for(int dj1 = -1; dj1 <= 1; dj1++) {
			for(int dj2 = -1; dj2 <=1; dj2++) {
				int res = 0;
				
				//both alice and bob pointing to same cell
				if(j1 == j2)
					res = mat[i][j1] + helper(i+1, j1 + dj1, j2 + dj2, row, col, mat, dp);
				else
					res = mat[i][j1] + mat[i][j2] + helper(i+1, j1 + dj1, j2 + dj2, row, col, mat, dp); 
				
				max = Math.max(max, res);
			}
		}
		
		return dp[i][j1][j2] = max;
	}

	public static void main(String[] args) {
		int mat[][] = {{2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}};
		int row = mat.length;
		int col = mat[0].length;
		
		System.out.println(maximumChocolates(row, col, mat));
	}

}
