package dynamic_Programming;

import java.util.Arrays;

/**
 * @Paint_Fence_Algorithm
 * @Paint_Walls_with_K_colors_where_NOT_More_than_two_consecutive_walls_are_same_Color
 * @Recusion -> Exponential
 * @Memorization -> O(n) & O(n)+O(n)auxiliary
 * @DP -> O(n) & O(n)
 * @Optimised -> O(n) & O(1)
 */

public class Paint_fence {

	//Time & Space: Exponential
	public static int paint_wall_recusion(int walls, int colors) {
		if(walls == 1)
			return colors;
		
		if(walls == 2) 
			return colors + (colors*(colors-1));
		
		int result = (paint_wall_recusion(walls-2, colors)*(colors-1)) +
				                         (paint_wall_recusion(walls-1, colors)*(colors-1));
		
		return result;		
	}
	
	//time: O(walls)
	//space: O(walls) + O(wall) auxiliary
	public static int paintWalls_Memorization(int walls, int colors, int[] memo) {
		if(walls == 1)
			return colors;
		
		if(walls == 2)
			return colors + (colors*(colors-1));
		
		if(memo[walls] != 0)
			return memo[walls];
		
		memo[walls] = (paintWalls_Memorization(walls-2, colors, memo)*(colors-1)) +
                                        (paintWalls_Memorization(walls-1, colors, memo)*(colors-1));
		
		return memo[walls];
	}
	
	//time: O(walls)
	//space: O(walls)
	public static int paintWalls_DP(int walls, int colors) {
		int[] dp = new int[walls+1];
		dp[1] = colors; //if only 1 wall then total N(colors) ways to paint wall
		dp[2] = colors + (colors*(colors-1)); //if 2 walls then -> colors * (colors-1) ways are possible
		
		for(int i=3; i<=walls; i++) {
			dp[i] = (dp[i-2]*(colors-1)) + (dp[i-1]*(colors-1));
		}
		
		return dp[walls];
	}
	
	//time: O(walls)
	//space: O(1)
	public static int paintWalls_1_space(int walls, int colors) {
		int prev2 = colors; //initial 0t (Two steps before)
		int prev1 = colors + (colors*(colors-1)); //1st (1 step before)
		
		for(int i=3; i<=walls; i++) {
			int temp = (prev2*(colors-1)) + (prev1 * (colors-1));
			prev2 = prev1;
			prev1 = temp;
		}
		return prev1;
	}
	
	public static void main(String[] args) {
		System.out.println("recursion: "+ paint_wall_recusion(4,5));
		
		int[] memo = new int[5];
//		Arrays.fill(memo, -1);
		System.out.println("memorization: " + paintWalls_Memorization(4,5, memo));
		
		System.out.println("dp: " + paintWalls_DP(4,5));
		
		System.out.println("optimised: " + paintWalls_1_space(4,5));
	}

}
