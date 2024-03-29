package array;
/**
 * Leetcode 135(Candy)
 */
/*
 * There are n children standing in a line.
 * Each child is assigned a rating value given in the integer array ratings.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 		** Each child must have at least one candy.
 * 		** Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 */
import java.util.*;
public class DistributingCandies_accTo_ratings {
	
	public static int distributeCandies(int[] ratings) {
		int size = ratings.length;
		int[] right = new int[size];
		int[] left = new int[size];
		
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);		
				
		for(int i=1; i<size; i++) {
			if(ratings[i] > ratings[i-1]) {
				left[i] = left[i-1]+1;
			}
		}
		
		for(int i=size-2; i>=0; i--) {
			if(ratings[i] > ratings[i+1]) {
				right[i] = right[i+1] + 1;
			}
		}
		
		int sum = 0;
		for(int i=0; i<size; i++) {
			sum += 	Math.max(left[i], right[i]);
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] ratings = new int[]{1,0,2};
		System.out.println(distributeCandies(ratings)); //result 5
	}

}