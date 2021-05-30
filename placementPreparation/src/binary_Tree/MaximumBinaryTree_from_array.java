package binary_Tree;
/**
 * @author Satyam Singh
 * -------------------------------LEETCODE 654--------------------------
 * Problem link : https://leetcode.com/problems/maximum-binary-tree/
 * 
 * Description : You are given an integer array nums with no duplicates.
 *               A maximum binary tree can be built recursively from nums
 *               using the following algorithm:

                 1. Create a root node whose value is the maximum value in nums.
                 2. Recursively build the left subtree on the subarray prefix to the left of the maximum value.
                 3. Recursively build the right subtree on the subarray suffix to the right of the maximum value.
                 
                 Return the maximum binary tree built from nums.
                 
   Difficulty : Medium
 */
public class MaximumBinaryTree_from_array {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int data;
	 *     Node left;
	 *     Node right;
	 *     Node() {} 
	 *     Node(int data) { this.data = data; }
	 *     Node(int data, Node left, Node right) {
	 *         this.data = data;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */

	//recursive approach
	//helper method
	public Node solve(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        
        int maxIndex = left;
        int maxVal = nums[left];
        for(int i=left+1; i<=right; i++){
            if(maxVal < nums[i]){
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        Node newNode = new Node(maxVal);
        newNode.left = solve(nums, left, maxIndex-1);
        newNode.right = solve(nums, maxIndex+1, right);
        return newNode;
    }
	//main method
    public Node constructMaximumBinaryTree(int[] nums) {
        return solve(nums, 0, nums.length-1);
    }
}
