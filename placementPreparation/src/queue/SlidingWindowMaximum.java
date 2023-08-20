package queue;
/**
 * @Sliding_Window_Maximum
 * @Double_Ended_Queue
 * @Leetcode_Hard
 */
/*
 * ----------------------239. Sliding Window Maximum--------------------------------
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. 
 * Each time the sliding window moves right by one position.
 * 
 * Return the max sliding window.
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 */
import java.util.*;
public class SlidingWindowMaximum {
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] arr = new int[n - k + 1];
		int idx = 0;
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i=0; i<n; i++) {
			//maintaining window size
			while(!deque.isEmpty() && deque.peekFirst() < i-k) 
				deque.pollFirst();
			
			//maintaining the max at first in deque
			while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
				deque.pollLast();
				
			deque.offerLast(i);
			
			//eligible for getting max of current window
			if(i >= k - 1) 
				arr[idx++] = nums[deque.peekFirst()];			
		}
		return arr;
	}
	
	 public static void main(String[] args) {
	     int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
	     int[] result = maxSlidingWindow(nums, 3);
	     
	     //[3, 3, 5, 5, 6, 7]
	     System.out.println(Arrays.toString(result));
	}

}
