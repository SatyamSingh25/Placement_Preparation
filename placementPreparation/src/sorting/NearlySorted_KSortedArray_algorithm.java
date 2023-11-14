package sorting;
import java.util.*;

/**
 * @NearlySorted_array
 * @KSortred_array
 * @MinHeap_PriorityQueue
 */
/*----------------------Sort a nearly sorted (or K sorted) array-------------------------------------------
 * Given an array of N elements, where each element is at most K away from its target position,
 * devise an algorithm that sorts in O(N log K) time.
 * 
 * Input: arr[] = {6, 5, 3, 2, 8, 10, 9}, K = 3 
 * Output: arr[] = {2, 3, 5, 6, 8, 9, 10}
 * 
 * Input: arr[] = {10, 9, 8, 7, 4, 70, 60, 50}, k = 4
 * Output: arr[] = {4, 7, 8, 9, 10, 50, 60, 70}
 */

/*
 * Approach: TC: O(K)+O(m *log(k)) where m = n-k
 * 	added first k+1 element to min-heap
 * 	then from i=k+1 to n
 * 		add pq.peek from min-heap and remove
 * 		add arr[i] to min-heap
 *  now add whole min-heap till it got empty.
 *  
 */
public class NearlySorted_KSortedArray_algorithm {
	
	public static int[] nearlySortedArray(int[] arr, int k) {
		if(arr == null || arr.length == 0) 
			return null;
		
		int n = arr.length;
		int[] res = new int[n];
		
		//min heap
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		//adding first k+1 element to min-heap
		for(int i=0; i<k+1; i++)
			pq.offer(arr[i]);
		
		//add pq.peek from min-heap to result array and remove from min-heap
		//add arr[i] to min-heap
		int index = 0;
		for(int i=k+1; i<n; i++) {
			res[index++] = pq.poll();
			pq.offer(arr[i]);
		}
		
		//now adding whole min-heap till it got empty.
		while(!pq.isEmpty())
			res[index++] = pq.poll();
		
		return res;	
	}

	public static void main(String[] args) {
		int[] arr = new int[] {2, 6, 3, 12, 56, 8};
		int k = 3;
		System.out.print(Arrays.toString(nearlySortedArray(arr, k)));
	}

}