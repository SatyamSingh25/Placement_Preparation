package dynamic_Programming;
/**
 * @author Satyam Singh
 * 
 * Problem link (LEETCODE) : https://leetcode.com/problems/maximum-subarray/
 * InterviewBit problem name : Max sum contiguous subarray
 * input : [-2,1,-3,4,-1,2,1,-5,4]
 * output : 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *  
 * Difficulty: Easy
 */
public class MaximumSubArray {
	//same appraoch as sliding window problem 
	public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            max = Math.max(sum, max);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
