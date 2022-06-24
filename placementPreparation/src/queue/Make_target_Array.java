package queue;
/**
 * @Leetcode_1354
 * @Priority_Queue
 * @Bottom_Up_Approach_is_Optimised
 * @Hard
 * -------------------------------------1354. Construct Target Array With Multiple Sums--------------------------------------------
 * 
 * [1,1,1] to [9,3,5] is possible or not
 * 
 * You are given an array target of n integers. From a starting array arr consisting of n 1's, 
 * you may perform the following procedure :

	->	let x be the sum of all elements currently in your array.
	->	choose index i, such that 0 <= i < n and set the value of arr at index i to x.
	->	You may repeat this procedure as many times as needed.

	Return TRUE if possible otherwise FALSE
 */
import java.util.*;
public class Make_target_Array {

	//Main method
	public static void main(String[] args) {
		int[] target = new int[] {9,3,5};

		//result -> TRUE
		System.out.println(isPossible(target));
	}

	//Method
    public static boolean isPossible(int[] target) {
        //max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b-a);
        int sum = 0;
        
        //Adding value in Priority Queue and sum up
        for(int i: target){
            pq.offer(i);
            sum+=i;
        }

        //while max element in queue is not 1
        while(pq.peek() != 1){
            int max = pq.poll();
            sum -= max;
            
            //not possible to convert this array to [1,1,1] 
            //bottom Up approach
            if(sum <=0 || sum >= max){
                return false;
            }
            
            //calculating difference
            max %= sum;
            sum += max;
            
            //adding value if its OK!
            pq.offer(max>0? max : sum);
        }
        return true;
    }
}
