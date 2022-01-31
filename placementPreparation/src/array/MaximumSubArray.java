package array;
import java.util.*;

public class MaximumSubArray {
	//max subarray sum
	public static int maxSubarraySum(int[] arr) {
		int currMax = arr[0];
		int maxSoFar = arr[1];
		
		for(int i=1; i<arr.length; i++) {
			currMax = Math.max(arr[i], currMax+arr[i]);
			maxSoFar = Math.max(maxSoFar, currMax);
		}
		
		return maxSoFar;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(maxSubarraySum(arr));
	}

}
