package dynamic_Programming;
/**
 * @Max_Sum_of_Subset_with_non_Adjacent_Element
 * @Don_not_alterate_Element_For_sum
 * @Subset_sum_modifiation
 * @DP (2 array or 1 array) can be used
 */
/*
 * |Approach|
 * 
 * array[]:    5   10   10   100   5     6
 * include[]:  5   10   15   110   20   116
 *               X 	  X    X    X     X
 * Exclude[]:  0 ->5 ->10 -> 15 -->110->110
 */

import java.util.Arrays;
public class Max_Sum_of_Non_Adjacent_Elements {
	
	//Time: O(n)
	//Space: O(2n)
	public static int maxSumNonAdjacent_2n_Space(int[] arr) {
		int size = arr.length;
		int[] include = new int[arr.length];
		int[] exclude = new int[arr.length];
		
		include[0] = arr[0];
		exclude[0] = 0;
		
		for(int i=1; i<arr.length; i++) {
			include[i] = exclude[i-1] + arr[i];
			exclude[i] = Math.max(include[i-1], exclude[i-1]);
		}
		
		//include: [5, 10, 15, 110, 20, 116]
		System.out.println("include: " + Arrays.toString(include)); 
		//exclude: [0, 5, 10, 15, 110, 110]
		System.out.println("exclude: " + Arrays.toString(exclude)); 
		
		return Math.max(include[size-1], exclude[size-1]); //max(116, 110)
	}

	//Time: O(n)
	//Space: O(n)
	public static int maxSum_Non_Adjacent_Elements(int[] arr) {
		if(arr.length == 1) 
			return arr[0];
		
		if(arr.length == 2)
			return Math.max(arr[0], arr[1]);
		
		int[] dp = new int[arr.length];
		
		dp[0] = arr[0];
		dp[1] = arr[1];
		
		for(int i=2; i<arr.length; i++) {
			dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
		}
		
		//dp[]: [5, 10, 15, 110, 110, 116]
		System.out.println("dp[]: " + Arrays.toString(dp));
		return dp[arr.length-1];
	
	}
	
	//Main Method
	public static void main(String[] args) {
		int[] arr = new int[] {5, 10, 10, 100, 5, 6};
		//result -> 116
		System.out.println(maxSumNonAdjacent_2n_Space(arr));  //tm:O(n) sp:O(2n)
		System.out.println(maxSum_Non_Adjacent_Elements(arr)); //tm:O(n) sp:O(N)optimized
	}

}
