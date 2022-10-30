package matrix;
/**
 * time: O(row * col)
 * Space: O(row*col)
 */
/* -------------------------------1293. Shortest Path in a Grid with Obstacles Elimination------------------------------
 * 
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). 
 * You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) 
given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 */
import java.util.*;
public class Shortest_from_startToEnd_with_atmost_K {
	
	static class Pair{
		int i, j, steps, k;
		Pair(){}
		Pair(int i, int j, int steps, int k){
			this.i = i;
			this.j = j;
			this.steps = steps;
			this.k = k;
		}
	}
	
	//function
	public static int shortestPath_with_K(int[][] grid, int k) {
		int row = grid.length;
		int col = grid[0].length;
		
		int[][] visited = new int[row][col];
		for(int[] vis: visited)
			Arrays.fill(vis, -1);
		
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(0, 0, 0, k));
		visited[0][0] = k;
		
		//                      U   R  D  L
		int[] dRow = new int[] {-1, 0, 1, 0};
		int[] dCol = new int[] {0, 1, 0, -1};
		
		while(queue.isEmpty() == false) {
			Pair curr = queue.poll();
			
			if(curr.i == row-1 && curr.j == col-1) //at last block of matrix
				return curr.steps;
			
			for(int i=0; i<4; i++) { //traversing 4 directions Up-Right-Down-Left
				int x = curr.i + dRow[i];
				int y = curr.j + dCol[i];
				
				if(x<0 || x>=row || y<0 || y>=col) //checking out of scope
					continue;
				
				int updatedK = curr.k - grid[x][y]; //breaking the blocker
				
				if(updatedK <= visited[x][y])
					continue;
				
				visited[x][y] = updatedK;
				queue.offer(new Pair(x, y, curr.steps+1, updatedK));
				
			}
			
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] {{0,0,0},
									{1,1,0},
									{0,0,0},
									{0,1,1},
									{0,0,0}};
									
		System.out.println(shortestPath_with_K(grid, 1));
		
	}

}
 