package array;
/**
 * Leetcode 2444 (hard)
 * Count Subarrays with fixed Bound
 * ---> Count all possible subarrays who have min value as Min and max as MAX
 * 
 * **find break point (invalid element to update index variables)
 * 
 * **FORMULA:::
 * 				result = result + (min(minIndex, maxIndex)-start+1); 
 */
public class CountSubarrays_With_FixedBound {
	
	public static long countSubarrays(int[] arr, int min, int max) {
		long result = 0;
		int minIndex = -1;
		int maxIndex = -1;
		int start = 0;
		
		for(int i=0; i<arr.length; i++) {
			//element is invalid to add it into the subarray
			if(arr[i] < min || arr[i] > max) {
				minIndex = -1;
				maxIndex = -1;
				start = i + 1;
			}
			
			//min OR max found then updates its index with latest index
			//because till now this index we have counted possible subarrays 
			if(arr[i] == min) 
				minIndex = i;
			if(arr[i] == max)
				maxIndex = i;
			
			//updating
			result = result + Math.max(0L, Math.min(minIndex, maxIndex)-start + 1);
		}
		
		//result
		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,1,2,3,5,7,5,1,3};
		System.out.println(countSubarrays(arr, 1, 5)); //output -> 4
		
	}

}
