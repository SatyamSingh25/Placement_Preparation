package array;
/**
 * @Divide_Array_Into_2_Equal_Sum_Array [TRUE / FALSE]
 * @Subset_Sum
 * @TotalSum/2 = target_Sum
 * @Memorization_DP
 */
/*
 * ------------------------------------------416. Partition Equal Subset Sum---------------------------------------------
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets 
 * such that the sum of elements in both subsets is equal.
 * 
 * 	Input: nums = [1,5,11,5]
	Output: true
	Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */
public class DivideArray_into_two_equal_array_sum {
	
	//Time: O(length of Array * (Sum/2))
	//Space: O(length of Array * (Sum/2))
	public static boolean divideInto2equalArray(int[] arr) {
		//taking sum whole Array
		//is Sum&2 != 0 that means Array cannot be divided in two in Equal sum array
		int sum=0;
        for(int i: arr){
            sum += i;
        }
        
        //Edge Case [if sum is ODD then its not possible to divide array in 2 equal array]
        if(sum%2 != 0)
            return false;
        
        //target Sum for an Array is (Sum/2);
        int target = sum/2;
        
        //Visited array for overcoming from Overlapped situtations  
        Boolean dp[][] = new Boolean[arr.length+1][target + 1];
        
        return subsetSum(arr,target,0,dp); //dividing into Two can be Possible or NOT
    }
    
    public static boolean subsetSum(int arr[], int target, int index, Boolean dp[][]){
        if(target==0) //can be divided into to array
            return true; 
        
        //if target sum not reached and Index reached the (Len+1) then its not possible
		if(index >= arr.length || target<0) 
            return false;
        
		//overlapped situation
        if(dp[index][target] != null)
            return dp[index][target];
        
        //                            adding the Current element and move forward
        return dp[index][target] = (subsetSum(arr,target-arr[index],index+1,dp) ||
        							subsetSum(arr,target,index+1,dp)); 
        //                               NOT adding the Current and Move forward
    }

	public static void main(String[] args) {
		int[] arr = new int[] {1,5,11,5};
		
		//result -> True
		System.out.println(divideInto2equalArray(arr));
	}

}
