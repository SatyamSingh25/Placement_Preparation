package graph;
// https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1/?track=amazon-graphs&batchId=192
/**
 * @BFS_on_matrix
 */
import java.util.*;
public class RottenOranges {
	
	static class Pair{
		int i, j;
		Pair(int x, int y){
			this.i = x;
			this.j = y;
		}
	}
	public static int rottenMinutes(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		Queue<Pair> queue = new LinkedList<Pair>();
		
		//couting number of fresh oranges
		int oranges = 0, rotten = 0, rottenByMe = 0, minute = 0;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(grid[i][j] != 0) {
					oranges++;
				}
				if(grid[i][j] == 2) {
					rotten++;
					queue.offer(new Pair(i, j));
				}
			}
		}
		
		int[] dRow = new int[] {-1,0,1,0};
		int[] dCol = new int[] {0,1,0,-1};
		
		while(queue.isEmpty() == false) {
			int currRotten = queue.size();
			rottenByMe += currRotten;
			
			while(currRotten-- != 0) {
				Pair curr = queue.poll();
				int x = curr.i;
				int y = curr.j;
				
				for(int i=0; i<4; i++) {
					int adj_x = x + dRow[i];
					int adj_y = y + dCol[i];
					
					if(adj_x<0 || adj_x >= row || adj_y<0 || adj_y >= col || grid[adj_x][adj_y]!=1) {
						continue;
					}
					
					grid[adj_x][adj_y] = 2;
					queue.offer(new Pair(adj_x, adj_y));
				}
				
			}
			if(queue.isEmpty() == false) {
				minute++;
			}
		}
		if(oranges == rottenByMe) {
			return minute;
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
		
		System.out.println(rottenMinutes(grid)); //4
	}

}
