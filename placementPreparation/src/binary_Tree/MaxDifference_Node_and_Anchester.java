package binary_Tree;
import java.util.*;
/**
 * @Leetcode_102 Maximum Difference Between Node and Ancestor
 * @PostOrder
 * @Left_right_min_max_AND_left_Right_result
 */
/*
 * ------------------------------------------1026. Maximum Difference Between Node and Ancestor---------------------------------------
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| 
 * and a is an ancestor of b.
 * 
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 */
public class MaxDifference_Node_and_Anchester {

	//method
	public static int maxAncestorDiff(TreeNode root) {
		return postOrder(root, root.val, root.val);
	}
	
	public static int postOrder(TreeNode root, int min, int max) {
		if(root == null)
			return Integer.MIN_VALUE;
		
		//collecting current path MIN and MAX
		min = Math.min(min, root.val);
		max = Math.max(max, root.val);
		
		//collecting result left and right subtree
		int left = postOrder(root.left, min, max);
		int right = postOrder(root.right, min, max);
		
		//result
		return Math.max(max-min, Math.max(left, right));
	}
	
	
	static class TreeNode{
		int val;
		TreeNode left, right;
		
		TreeNode(){
			this.val = 0;
			this.left = null;
			this.right = null;
		}
		
		TreeNode(int val, TreeNode left, TreeNode right){
			this.val = val;
			this.left = left;
			this.right =  right;
		}
	}
}
