package dfs_bfs;
import java.util.*;
/**
 * @Where_will_ball_fall
 * @if_arr[i][j] == 1 then fall right
 * @if_arr[i][j] == -1  then fall left 
 * @return array i-th ball fall from which column 
 */
/*----------------------------------1706. Where Will the Ball Fall----------------------------------
 * You have a 2-D grid of size m x n representing a box, and you have n balls. 
   The box is open on the top and bottom sides.

   Each cell in the box has a diagonal board spanning two corners of the cell that can redirect
   a ball to the right or to the left.

   A board that redirects the ball to the right spans the top-left corner to the bottom-right corner 
   and is represented in the grid as 1.
   A board that redirects the ball to the left spans the top-right corner to the bottom-left corner 
   and is represented in the grid as -1.
   We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. 
   A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.

   Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping the ball 
   from the ith column at the top, or -1 if the ball gets stuck in the box.
 */
public class Where_will_Ball_fall {
	//Appraoch
	public static int[] whereWillBall_fall(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		
		int[] result = new int[col];
		for(int i=0; i<col; i++) {
			result[i] = dfs(0, i, grid, row, col);
		}
		return result;
	}
	
	public static int dfs(int i, int j, int[][] grid, int row, int col) {
		if(i >= row)
			return j;
		
		if(grid[i][j] == 1 && j+1<col && grid[i][j+1] == 1)
			return dfs(i+1, j+1, grid, row, col);
		
		if(grid[i][j] == -1 && j-1>=0 && grid[i][j-1] == -1)
			return dfs(i+1, j-1, grid, row, col);
		
		if(grid[i][j] == 1 && j+1 >= col)
			return -1;
		
		if(grid[i][j] == -1 && j-1 < 0)
			return -1;
		
		return -1;
	}

	//Main Method
	public static void main(String[] args) {
		int[][] arr = new int[][] {{1,1,1,-1,-1},
								   {1,1,1,-1,-1},
								   {-1,-1,-1,1,1},
								   {1,1,1,1,-1},
								   {-1,-1,-1,-1,-1}};
		int[] result = whereWillBall_fall(arr);
		System.out.println(Arrays.toString(result));
	}

}
