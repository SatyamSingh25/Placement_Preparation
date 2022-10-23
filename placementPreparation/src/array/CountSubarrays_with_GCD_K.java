package array;

public class CountSubarrays_with_GCD_K {
	public static int gcd(int a, int b) {
		if(b==0)
			return a;
		return gcd(b, a%b);
	}
	
	public static int countSubArrays_With_GCD_K(int[] arr, int k) {
		int count = 0;
		
		for(int i=0; i<arr.length; i++) {
			int currGcd = arr[i];
			
			if(arr[i] == k) count++;
			
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < k) break;
				
				currGcd = gcd(currGcd, arr[j]);
				
				if(currGcd == k)
					count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{9,3,1,2,6,3};
		System.out.println(countSubArrays_With_GCD_K(arr, 3)); //result 4
	}

}
