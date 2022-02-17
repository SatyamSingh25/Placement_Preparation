package array;

public class DivideArray_into_two_equal_array_sum {
	
	public static boolean divideInto2equalArray(int[] arr) {
		int sum=0;
        for(int i: arr){
            sum += i;
        }
        
        if(sum%2 != 0)
            return false;
        
        int target = sum/2;
        
        Boolean dp[][]=new Boolean[arr.length+1][target + 1];
        
        return subsetSum(arr,target,0,dp);
    }
    
    public static boolean subsetSum(int arr[], int target, int index, Boolean dp[][]){
        if(target==0)
            return true;
        
		if(index >= arr.length || target<0)
            return false;
        
        if(dp[index][target] != null)
            return dp[index][target];
        
        return dp[index][target] = (subsetSum(arr,target-arr[index],index+1,dp) ||
        							subsetSum(arr,target,index+1,dp));
    }

	public static void main(String[] args) {
		int[] arr = new int[] {1,5,11,5};
		System.out.println(divideInto2equalArray(arr));
	}

}
