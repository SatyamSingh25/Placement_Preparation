package graph;
import java.util.Scanner;
/**
 * @Contributor Satyam Singh
 * Problem link : https://leetcode.com/problems/number-of-islands/
 * Statement : find number of iceLands present in given O-1 map.
 * 
 * Diffibulty : Medium
 * 
 * input : 1 1 1 0 0
           1 0 1 0 1
           0 0 1 1 0
           0 0 0 0 0
           1 1 1 1 1
 *
 * Output: 3 
 */

public class NumberOf_IceLands {
	//main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] map = new int[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int count = countIceLand(map, row, col);
		System.out.println(count);
	}
	//counting number of isLands
	public static int countIceLand(int[][] map, int row, int col) {
		int count = 0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(map[i][j] == 1) {
					findFullIceLand(map, i , j);
					count++;
				}
			}
		}
		return count;
	}
	
	//using DFS to find area of isLand
	public static void findFullIceLand(int[][] map, int i, int j) {
		int row = map.length;
		int col = map[0].length;
		
		if(i<0 || i>=row || j<0 || j>=col) {
			return;
		}
		
		if(map[i][j] ==0) {
			return;
		}
		
		map[i][j] = 0;
		
		findFullIceLand(map, i+1, j);
		findFullIceLand(map, i-1, j);
		findFullIceLand(map, i, j+1);
		findFullIceLand(map, i, j-1);
	}

}
