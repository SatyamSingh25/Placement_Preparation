package stack;
/**
 * @author Satyam
 * @Leetcode_735
 * Problem statement: We are given an array asteroids of integers representing asteroids in a row.
                      For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
                      Each asteroid moves at the same speed.

                      Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
                      If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
                 
   input: asteroids = [5,10,-5]
   output after explosion: [5, 10]
   
   Input: asteroids = [10,2,-5]
   Output: [10]
   
 */
import java.util.*;
public class AsteroidCollisions {
	
	//method in O(n) time & O(n) space
	public static int[] afterCollitions(int[] asteroids) {
		
		Stack<Integer> stack = new Stack<Integer>(); // stack is used
		
		for(int i=0; i<asteroids.length; i++) {
			//If asteroid is positive then simply push it into stack for further counter asteroid
			if(asteroids[i] > 0) {
				stack.add(asteroids[i]);
			}
			else {
				//here a negative charge asteroid destroying +ve asteroids until it can 
				while(stack.isEmpty() == false && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
					stack.pop();
				}
				//after destroying all check is stack is empty then then is mandatory to push that into the stack
				//because it defeated all the low power asteroids as compare to asteroid[i]
				if(stack.isEmpty() || stack.peek() < 0) {
					stack.push(asteroids[i]);
				}
				//condition for if both asteroids have same powers the both explodes, so simply the pop current top of the stack 
				else if(stack.peek() == Math.abs(asteroids[i])) {
					stack.pop();
				}
			}
		}
		
		//creating resultant array
		int[] result = new int[stack.size()];
		for(int i=stack.size()-1; i>=0; i--) {
			result[i] = stack.pop();
		}
		//result
		return result;
	}
	
	//Driver code
	public static void main(String[] args) {
		int[] asteroids = {5,10,-5}; //asteroid with its powers
		
		System.out.println(Arrays.toString(afterCollitions(asteroids))); //[5, 10]
	}

}
