package binary_Tree;
/**
 * @MaxSum_BST_in_binaryTree
 * @BinaryTree
 * @PostOrder
 * Time: O(n)
 * Space: O(n)
 * @HARD
 */
/*-----------------------------------------1373. Maximum Sum BST in Binary Tree-------------------------------------------
 * Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
 * Assume a BST is defined as follows:-
		-> The left subtree of a node contains only nodes with keys less than the node's key.
		-> The right subtree of a node contains only nodes with keys greater than the node's key.
		-> Both the left and right subtrees must also be binary search trees.
 */
import java.util.*;
public class MaxSum_Valid_BST_in_BinaryTree {
	
    //solution
	int sum = 0;
	int valid = 0; //false
	
	public int maxSumBST(TreeNode root) {
		postOrder(root);
		return sum;
	}
	
	//valid, sum, min, max
	public int[] postOrder(TreeNode root) {
		if(root == null)
			return new int[]{valid, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
		
		int[] left = postOrder(root.left);
		int[] right = postOrder(root.right);
		
		int[] result = new int[4];
        //valid
		result[0] = (left[0] == valid && right[0] == valid && 
                            root.val < right[2] && root.val > left[3]) ? valid : 1;
        //sum
		result[1] = left[1] + right[1] + root.val;
        //min
		result[2] = Math.min(root.val, left[2]); //minium to minimum this has to be there
        //max
		result[3] = Math.max(root.val, right[3]); //max to max this amount has to be there
		
		if(result[0] == valid) {
			sum = Math.max(sum, result[1]);
		}
		return result;
	}	
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(){}
		TreeNode(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}
		TreeNode(int val, TreeNode left, TreeNode right){
			this.val = val;
			this.left = left;
			this.right = right;					
		}
	}
}
