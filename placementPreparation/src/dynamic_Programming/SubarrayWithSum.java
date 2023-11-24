package dynamic_Programming;
/**
 * Unsorted array
 * find subarray with sum
 * return first subarray from left to right if multiple subarray are possible
 * 
 * Approach 1 O(n^2) = nested for loop
 * Approach 2 O(N) = Sliding window
 */
import java.util.*;
public class SubarrayWithSum {
	
	public static ArrayList<Integer> subarrayWithSum(int[] arr, int sum) {
		int currentSum = 0;
		int start = 0;
		ArrayList<Integer> res = new ArrayList<>();
		
		for(int i=0; i<=arr.length; i++) {
			
			while(currentSum > sum &&  start < i-1) {
				currentSum -= arr[start];
				start++;
			}
			
			if(currentSum == sum) {
				int end = i-1;
				res.add(start);
				res.add(end);
				return res;
			}
			
			if(i<arr.length)
				currentSum += arr[i];
		}
		res.add(-1);
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[] {1,2,3,7,5};
		int sum = 12;
		System.out.println(SubarrayWithSum.subarrayWithSum(arr, sum));
		
	}

}
