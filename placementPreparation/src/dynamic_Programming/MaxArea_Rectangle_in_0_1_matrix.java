 package dynamic_Programming;
/**
 * @author Satyam
 * @leetcode_85
 * @Largest_Rectangle 
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
				if(i!=0 || arr[i][j] != 0) {
					if(i!=0 && arr[i][j] !=0) {
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
	
	public static int maxAreaHistogram(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        
        //filling left smallers array
        for(int i=0; i<n; i++){
            while(stack.isEmpty() == false && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            
            if(stack.isEmpty() == true)
                leftSmaller[i] = 0;
            else
                leftSmaller[i] = stack.peek()+1;
            
            
            stack.push(i);
        }
        
        //filling right smaller array
        stack.clear();
        for(int i=n-1; i>=0; i--){
            while(stack.isEmpty() == false && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            
            if(stack.isEmpty() == true)
                rightSmaller[i] = n-1;
            else
                rightSmaller[i] = stack.peek()-1;
            
            
            stack.push(i);
        }
//        System.out.println(Arrays.toString(leftSmaller));
//        System.out.println(Arrays.toString(rightSmaller));
        
        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, (heights[i] * (rightSmaller[i]-leftSmaller[i]+1)));
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
