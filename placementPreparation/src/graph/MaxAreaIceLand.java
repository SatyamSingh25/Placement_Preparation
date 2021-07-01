package graph;
import java.util.Scanner;
/**
 * @Contributor Satyam Singh
 * problem link : https://leetcode.com/problems/max-area-of-island/
 * statement : find the max are island.
 * Difficulty : Medium.
 * @DFS
 */
public class MaxAreaIceLand {
	//main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] map = new int[row][col];
		
		for(int i=0; i<row; i++) {
			for(int j=0; i<col; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int maxArea = maxAreaOfIsland(map);
		System.out.println(maxArea);
		sc.close();
	}
	//find max area of every point were value is 1
	public static int maxAreaOfIsland(int[][] map) {
		int row = map.length;
		int col = map[0].length;
		int count = 0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(map[i][j] == 1) {
					count = Math.max(count, findArea(map, i, j, 0));
				}
			}
		}
		return count;
	}
	//using DFS approach to find the area  
	public static int findArea(int[][] map, int i, int j, int area) {
		int row = map.length;
		int col = map[0].length;
		
		if(i<0 || i>=row || j<0 || j>=col) {
			return 0;
		}
		if(map[i][j] == 0) {
			return 0;
		}
		map[i][j] = 0;
		return 1+ findArea(map, i+1, j, area)
				+ findArea(map, i-1, j, area)
				+ findArea(map, i, j+1, area) 
				+ findArea(map, i, j-1, area);
		
	}
}
