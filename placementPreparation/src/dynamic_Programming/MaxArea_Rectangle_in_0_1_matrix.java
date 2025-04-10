 package dynamic_Programming;
/**
 * @author Satyam
 * @leetcode_85
 * @Largest_Rectangle_in_Histogram 
 * Problem statement: Given a rows x cols binary matrix filled with 0's and 1's,
 *                    find the largest rectangle containing only 1's and return its area.
 * 
 * Input: matrix = [["1","0","1","0","0"],
 *                  ["1","0","1","1","1"],
 *                  ["1","1","1","1","1"],
 *                  ["1","0","0","1","0"]]
   Output: 6
   
   Difficulty: Hard
   Tag: Stack, left smaller array, right smaller array, variation of Largest rectangular histogram
 */

import java.util.*;
public class MaxArea_Rectangle_in_0_1_matrix {
	
	public static int maxArea_rectangle_in_matrix(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(i!=0) {
					if(arr[i][j] !=0) {
						arr[i][j] += arr[i-1][j];
					}
				}
			}
		}
		
		for(int i=0; i<row; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		//calling largest rectangle histogram for every row and getting maxArea for row
		int maxArea = 0;
		for(int i=0; i<row; i++)
			maxArea = Math.max(maxArea, maxAreaHistogram(arr[i]));
		//returning result
		return maxArea;
	}
	
	//O(n)
	public static int maxAreaHistogram(int[] arr) {
		int n = arr.length;
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>(); //monotonic stack handle min height till now via storing index
		
		for(int i=0; i<=n; i++) {
			int currHeigth = (i == n) ? 0 : arr[i];
			
			while(!stack.isEmpty() && currHeigth <= arr[stack.peek()]) { //we got min height till now as compare to arr[0:i-1];
				int height = arr[stack.pop()]; //current height for computation
				int width = (stack.isEmpty()) ? i : i - stack.peek() -1; //width for rectangle
				
				int currArea = height * width; //current area
				maxArea = Math.max(maxArea, currArea); //maintaining maxArea
			}
			stack.push(i); //add min height index till now
		}
		
		return maxArea;		
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { {0, 1, 1, 0},
	         						{1, 1, 1, 1},
	         						{1, 1, 1, 1},
	         						{1, 1, 0, 0}};
		System.out.println(maxArea_rectangle_in_matrix(arr)); // 8
	}

}
