package sliding_Window;
/**
 * @Sliding_Window
 * Leetcode 485 - Max Consecutive Ones
 * Problem : Given a binary array nums, return the maximum number of consecutive 1's in the array.
 */
public class Max_Consecutive_one_1 {
	
	//Sliding window
	//TC : O(n)
	//SC : O(1)
	public static int maxOnes(int[] arr) {
		int start = 0;
		int window = 0;
		int res = -1;
		
		for(int end=0; end<arr.length; end++) {
			window = window + arr[end];
			
			if(window != (end - start + 1)) {
				window = window - arr[start];
				start++;
			}
			
			res = Math.max(res, (end - start + 1));
		}
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println(maxOnes(new int[] {1,1,0,1,1,1})); //3
	}

}
