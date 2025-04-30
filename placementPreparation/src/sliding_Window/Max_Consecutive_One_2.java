package sliding_Window;
/**
 * @Sliding_Window
 * Leetcode 487 (Premium)
 * Problem : Given a binary array, return count maximum length consecutive 1's in a array if you can flip at most one 0.
 *
 * Input : [1,0,1,1,0]
 * output : 4 
 * Explanation : [1, 0, 1, 1] -> [1, 1, 1, 1]
 */

public class Max_Consecutive_One_2 {
	
	//Sliding window
	//TC : O(n)
	//Sc : O(1)
	public static int maxConsicutiveOnceWithOneZero(int[] arr) {
		int start = 0;
		int window = 0;
		int res = -1;
		
		for(int end=0; end < arr.length; end++) {
			window =  window + arr[end];
			
			//shrink window till not valid subarray
			if(!(window == (end - start + 1) || window == (end - start))) {
				window = window - arr[start];
				start++;
			}
			
			res = Math.max(res, (end - start + 1));
		}
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println(maxConsicutiveOnceWithOneZero(new int[] {1,0,1,1,0})); //4
	}

}
