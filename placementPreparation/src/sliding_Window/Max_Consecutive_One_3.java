package sliding_Window;

public class Max_Consecutive_One_3 {
	
	//Sliding window
	public static int maxOnesSubarrayWithKFlips(int[] arr, int k) {
		int start = 0;
		int window = 0;
		int res = -1;
		
		//shrink until we found valid subarray
		for(int end=0; end<arr.length; end++) {
			window = window + arr[end];
			
			//shrink till window is not valid
			while(window + k < (end - start + 1)) {
				window = window - arr[start];
				start++;
			}
			
			res = Math.max(res, end - start + 1);
		}
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println(maxOnesSubarrayWithKFlips(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2)); //6 [0,1,1,1,1,0]
	}

}
