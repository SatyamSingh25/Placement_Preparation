package array;

public class Subset_with_targetSum {
	
	public static boolean subsetSumToTarget(int[] arr, int target) {		
		 return helper(arr.length-1, arr, target);
	}
	
	public static boolean helper(int start, int[] arr, int target) {
		if(target == 0)
			return true;
		
		if(start == 0)
			return arr[start] == target;
		
		
		boolean pick = false;
		if(arr[start] <= target)
			pick = helper(start - 1, arr, target - arr[start]);
		
		boolean noPick = helper(start - 1, arr, target);
		
		return pick || noPick;
	}

	public static void main(String[] args) {
		 int arr[] = { 1, 2, 3, 4 };
	     int target = 9;
	     int n = arr.length;

	        // Check if there exists a subset with the given target sum
	     if (subsetSumToTarget(arr, target))
	    	 System.out.println("Subset with the given target found");
	     else
	         System.out.println("Subset with the given target not found");
	}

}
