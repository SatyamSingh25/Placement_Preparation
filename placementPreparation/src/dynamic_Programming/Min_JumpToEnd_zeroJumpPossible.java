package dynamic_Programming;

/**
 * Link : https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * Discription: Reach till end from start of the array, you can jump from 'i' to arr[i] max.
 * 				arr[i] can be a '0' which means you can't move forword from there i-th position.
 * 				Find the minimum number of jumps you can react till END of array if not return -1.
 * 
 * Approach: take 3 var [maxRaech(arr[0]), means from start we jump max till [0+arr[i]]
 * 						 steps (arr[0])
 * 						 Jumps (1)]
 * 
 */
import java.util.*;
public class Min_JumpToEnd_zeroJumpPossible {
	
	public static int minimumJumpsToReachEnd(int[] arr) {
		if(arr.length <= 0) return -1;
		
		if(arr[0] == 0) return 0;
		
		int maxReach = arr[0];
		int steps = arr[0];
		int jump = 1;
		
		for(int i=1; i<arr.length; i++) {
			//reached at the end - so stop
			if(i == arr.length-1) 
				return jump;
			
			//max we can jump 
			maxReach = Math.max(maxReach, i+arr[i]);
			steps--; //one steps is taken i.e steps are decreasing
			
			//no more steps are available to take so
			//its time to JUMP
			if(steps == 0) {
				jump++;				
				steps = maxReach - i;
			}	
		}
		return -1; //never reach till end
	}
	
	//can we reach till end [JUMP GAME]
	public static boolean canReachTillEnd(int[] arr) {
		int maxReach = 0;
		
		for(int i=0; i<=maxReach; i++) {			
			maxReach = Math.max(maxReach, i+arr[i]);
			
			if(maxReach >= arr.length-1)
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(minimumJumpsToReachEnd(arr)); //3 jumps
		
		System.out.println(canReachTillEnd(new int[] {1, 2, 0, 3, 0, 0})); //true
		System.out.println(canReachTillEnd(new int[] {1,0,3})); //false
	}

}
