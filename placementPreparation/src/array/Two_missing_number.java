package array;

public class Two_missing_number {
	public static int getSum(int[] arr) {
		int sum = 0;
		for(int i: arr) {
			sum += i;
		}
		return sum;
	}
	public static void findTwoMissing_numbers(int[] arr) {
		//arr with n-2 length
		int n = arr.length+2;
		
		
		int sum = ((n * (n + 1)) /2) - getSum(arr);

	    int avg = (sum / 2);
	 
	    int sumSmallerHalf = 0, sumGreaterHalf = 0;
	    for (int i = 0; i < n - 2; i++){
	        if (arr[i] <= avg)
	            sumSmallerHalf += arr[i];
	        else
	            sumGreaterHalf += arr[i];
	    }
	 
	    System.out.println("Two Missing Numbers are");
	    int totalSmallerHalf = (avg *(avg + 1)) / 2;
	    
	    System.out.print(totalSmallerHalf - sumSmallerHalf + " ");

	    System.out.println(((n * (n + 1)) / 2 - totalSmallerHalf) - sumGreaterHalf);
	    
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,3,5,6};
		findTwoMissing_numbers(arr);
	}

}
