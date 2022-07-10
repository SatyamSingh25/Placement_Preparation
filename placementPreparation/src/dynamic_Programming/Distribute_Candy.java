package dynamic_Programming;

import java.util.Arrays;

/**
 * @Candy
 * @Distribute_Candies_at_least_1_or_if_Higher_then_its_Neighbours_Give_it_More
 * @Array
 * @Implementions
 * @Good_Idiology
 * @Left_Right_Array
 */
/*
 * -------------------------------------------------135. Candy--------------------------------------------------------
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 		-> Each child must have at least one candy.
 * 		-> Children with a higher rating get more candies than their neighbors.
 * 
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * 
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with [2, 1, 2] candies respectively
 */
public class Distribute_Candy {
	
	//Time: O(n)
	//Spcae: O(n)
	public static int[] candyDistribution_Optimised(int[] ratings) {
		
		int[] left = new int[ratings.length];
		
		Arrays.fill(left, 1);
		
		for(int i=1; i<ratings.length; i++) {
			if(ratings[i] > ratings[i-1]) {
				left[i] = left[i-1]+1;
			}
		}
		
		for(int i=ratings.length-2; i>=0; i--) {
			if(ratings[i] > ratings[i+1]) {
				left[i] = Math.max(left[i], left[i+1]+1);
			}
		}
		return left;
	}
	
	//Time: O(n)
	//Spcae: O(2n)
	public static  int[] candyDistribution(int[] ratings) {
		
		int[] left = new int[ratings.length];
		int[] right = new int[ratings.length];
		
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		
		for(int i=1; i<ratings.length; i++) {
			if(ratings[i] > ratings[i-1]) {
				left[i] = left[i-1]+1;
			}
		}
		
		for(int i=ratings.length-2; i>=0; i--) {
			if(ratings[i] > ratings[i+1]) {
				right[i] = right[i+1]+1;
			}
		}
		
		for(int i=0; i<ratings.length; i++) {
			ratings[i] = Math.max(left[i], right[i]);
		}
		return ratings;
	}

	public static void main(String[] args) {
		int[] ratings = new int[] {1,0,2};
		//result -> [2,1,2]
		System.out.println(Arrays.toString(candyDistribution(ratings)));
		System.out.println(Arrays.toString(candyDistribution_Optimised(ratings)));
	}

}
