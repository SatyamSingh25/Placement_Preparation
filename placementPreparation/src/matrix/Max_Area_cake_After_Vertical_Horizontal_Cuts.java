package matrix;
/**
 * @Leetcode_1465
 * @matrix
 * @Sort
 * @Max_difference_(arr[i],arr[i-1])
 * @Max_Height
 * @Max_weight
 */
import java.util.*;
public class Max_Area_cake_After_Vertical_Horizontal_Cuts {
	
	//Parameter Values->           (5)         (4)            {1, 2, 4}             {1, 3}
	public static int maxArea(int height, int weight, int[] horizontalCuts, int[] verticalCuts) {
		
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		
		int maxHeight = Math.max(horizontalCuts[0], 
									height - horizontalCuts[horizontalCuts.length-1]);
		
		int maxWeight = Math.max(verticalCuts[0],
									weight - verticalCuts[verticalCuts.length-1]);
		
		for(int i=1; i<horizontalCuts.length; i++)
			maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i-1]);
		
		for(int i=1; i<verticalCuts.length; i++)
			maxWeight = Math.max(maxWeight, verticalCuts[i] - verticalCuts[i-1]);
			
		return maxHeight * maxWeight % 1000000007;
	}

	//main method
	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,4};
		int[] arr2 = new int[] {1,3};
		System.out.println(maxArea(5, 4, arr1, arr2));
	}

}
