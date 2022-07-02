package array;
/**
 * @Leetcode_462
 * @Minium_Operation_to_Make_All_Element_Equal
 * @Increase_or_Decrease_a_Number
 * @Array
 * @BinarySearch -> only to get an idea
 * @Middle_find
 * @Sorting
 */
import java.util.*;
public class Minimum_Opr_To_Make_Array_Element_Equal {

	//O(nlogN)
    public static int minMoves2(int[] nums) {
        int min = 0;            
        Arrays.sort(nums);
        int mid =nums[nums.length/2];
        for(int i: nums){
            min += Math.abs(mid - i);
        }
        return min;
    }
    
    //O(n^2) time
     public static int minMoves2_(int[] nums) {
         int min = Integer.MAX_VALUE;            
         for(int i=0; i<nums.length; i++){
             min = Math.min(min, solve(i, nums));
         }
         return min;
     }
     public static int solve(int source, int[] nums){
         int curr = nums[source];
         int count = 0;
         for(int i=0; i<nums.length; i++){
             if(i != source){
                 if(count + Math.abs(nums[i] - nums[source]) < 0)
                     return Integer.MAX_VALUE;
                 count += Math.abs(nums[i] - nums[source]);
             }
         }
         return count;
     }
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 10, 2, 9};
		//result -> 16
		System.out.println(minMoves2(arr));
		System.out.println(minMoves2_(arr));
	}

}
