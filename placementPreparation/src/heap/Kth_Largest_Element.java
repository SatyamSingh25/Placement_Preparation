package heap;
import java.util.*;
/**
 * @author Satyam Singh
 * -------------------------------LEETCODE 215---------------------------------------
 * Problem link : https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * Description : Given an integer array nums and an integer k, return the kth largest
 *               element in the array.
                 Note that it is the kth largest element in the sorted order, not the
                 kth distinct element.
                 
 * Difficulty : Medium
 */
public class Kth_Largest_Element {
	//Time complexity : O(n log(k))
	//space complexity : O(K)
	//using MAX HEAP
	public int findKthLargest(int[] nums, int k) {  
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(k);
        int x = k;
        int i =0;
        while(x != 0){
            pQueue.add(nums[i]);
            i++;
            x--;
        }
        for(i=k; i<nums.length; i++){
            if(pQueue.peek() < nums[i]){
                pQueue.poll();
                pQueue.add(nums[i]);
            }
        }
        return pQueue.peek();   
    }
}
