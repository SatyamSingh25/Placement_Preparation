package array;
/**
 * @author Satyam
 * @Recursion
 * @Divide_array_Into_K_Equals_Subsets
 * @Add_or_not_to_add
 * @DFS
 */
public class DivideArray_Into_K_equal_Parts {
	
	public static boolean canPartitionIntoKEqualParts(int[] arr, int k) {
		int sum = 0;
		for(int i: arr)
			sum+=i;
		if(sum%k != 0)
			return false;
		
		boolean[] vis = new boolean[arr.length];
		return solve(arr, 0, sum/k, 0, k, vis);
	}
	
	public static boolean solve(int[] arr, int i, int target, int currSum, int k, boolean[] vis) {
		if(k==1)
			return true;
		
		if(target == currSum)
			return solve(arr, 0, target, 0, k-1, vis);
		
		for(int start = i; start < arr.length; start++) {
			if(vis[start] ==  false && currSum + arr[start] <= target) {
				vis[start] = true;
				if(solve(arr, start+1, target, currSum + arr[start], k, vis))
					return true;
				vis[start] = false; 
			}
		}
		return false;
		
	}

	public static void main(String[] args) {
		int[] arr = new int[] {4,3,2,3,5,2,1};
		System.out.println(canPartitionIntoKEqualParts(arr, 4)); //true
		arr = new int[] {1,2,3,4};
		System.out.println(canPartitionIntoKEqualParts(arr, 3)); //false
	}
	
}
