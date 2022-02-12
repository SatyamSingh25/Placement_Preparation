package stack;
/**
 * @author Satyam
 * @Leetcode_84 @Largest_Rectangle_in_Histogram
 * Problem statement: Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 *                    return the area of the largest rectangle in the histogram.
 *                    
 *            _  
     6      _| |   
     5     | | |
     4     | | |  _
     3  _  | | |_| |
     2 | |_| | | | | 
     1 |_|_|_|_|_|_|
      0 1 2 3 4 5 6
      
    Input: heights = [2,1,5,6,2,3]
    Output: 10
 *	
 *  Difficulty: Hard
 *  tag: DP, Stack, Left smaller array, Right Smaller array
 */
import java.util.*;
public class LargestRectangle_in_Histogram {
	//Largest Rectangle in Histogram
    public static int largestRectangleArea(int[] heights) {
    	
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
        //calculating the max rectable area
        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, (heights[i] * (rightSmaller[i]-leftSmaller[i]+1)));
        }
        //result
        return maxArea;
    }
    //Driver Code
	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(heights));
	}
}