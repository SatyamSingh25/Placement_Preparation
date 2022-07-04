package dynamic_Programming;
/**
 * @Leetcode_135
 * @Left_Right_Array
 * @DP
 * @Single_Array_is_for_Space_Optimised
 */
/*
 * -----------------------------------------------135. Candy--------------------------------------------------------
 * There are n children standing in a line. 
 * Each child is assigned a rating value given in the integer array ratings.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 		* Each child must have at least one candy.
		* Children with a higher rating get more candies than their neighbors.
	Return the minimum number of candies you need to have to distribute the candies to the children.
	
 ratings[] = {1,0,2}
 answer= 5
 Explanation: candies = {2,1,2} distributed
 */
import java.util.*;
public class Max_Candies_than_Neighbors {
	
	//time: O(n) Space: O(n)
	public static int candy(int[] ratings) {
		int size = ratings.length;
		int[] dp = new int[size];
		
		Arrays.fill(dp, 1);
		
		for(int i=1; i<size; i++) {
			if(ratings[i] >ratings[i-1]) {
				dp[i] = dp[i-1]+1;
			}
		}
		
		int sum = dp[size-1];
		for(int i=size-2; i>=0; i--) {
			if(ratings[i] > ratings[i+1]) {
				dp[i] = Math.max(dp[i], dp[i+1]+1);
			}
			sum += dp[i];
		}
		System.out.println("Dp[]: "+Arrays.toString(dp)); //[1, 2, 3, 1, 3, 2, 1]
		return sum;		
	}
	
	//time: O(n) Spcae: O(2n)
	public static int candy2(int[] ratings){
        int size = ratings.length;
        int[] left = new int[size];
        int[] right = new int[size];
        
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        
        for(int i=1; i<size; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        
        for(int i=size-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                right[i] = right[i+1]+1;
            }
        }
        
        int sum = 0;
        for(int i=0; i<size; i++){
            sum += Math.max(left[i], right[i]);
        }
        
        return sum;
    }

	public static void main(String[] args) {
		int[] ratings = new int[] {1,2,87,87,87,2,1};
		System.out.println("ratings[]: "+Arrays.toString(ratings));
		//result -> 13
		System.out.println(candy(ratings));
		System.out.println(candy2(ratings));
	}

}
