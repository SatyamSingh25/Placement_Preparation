package graph;
import java.util.Scanner;
/**
 * @Contributor Satyam Singh
 * problem link : https://leetcode.com/problems/flood-fill/
 * Statement : fill connect nodes with different color.
 * Difficulty : Easy
 */

public class FloodFill {
	//main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] grid = new int[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		int x = sc.nextInt();
		int y = sc.nextInt();
		int newColor = sc.nextInt();
		
		grid = floodFill(grid, x, y, newColor);
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
	//find colors in neighbour
	public static int[][] floodFill(int[][] grid, int i, int j, int newColor) {
		int curr = grid[i][j];
		if(curr == newColor) {
			return grid;
		}
		fillAreaColor(grid, i, j, curr, newColor);
		return grid;
	}
	//finding neighbour and filing colors using DFS.
	public static void fillAreaColor(int[][] grid,int i,int j,int curr,int newColor) {
		
		int row = grid.length;
		int col = grid[0].length;
		
		if(i<0 || i>=row || j<0 || j>=col) {
			return;
		}
		if(grid[i][j] != curr) {
			return;
		}
		
		grid[i][j] = newColor;
		
		fillAreaColor(grid, i+1, j, curr, newColor);
		fillAreaColor(grid, i-1, j, curr, newColor);
		fillAreaColor(grid, i, j+1, curr, newColor);
		fillAreaColor(grid, i, j-1, curr, newColor);
	}

}
