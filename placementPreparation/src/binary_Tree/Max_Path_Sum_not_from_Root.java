package binary_Tree;
/**
 * @Max_Path_Sum_May_or_May_Not_Be_From_Root_Node
 * @Leetcode_Hard
 * @PostOrder
 * @Maintain_Max
 * ---> If left subtree or right subtree sum in negative consider that as 0
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) 
 */
/*---------------------------------124. Binary Tree Maximum Path Sum------------------------------------
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has 
 * an edge connecting them. A node can only appear in the sequence at most once. 
 * 	Note-> that the path does not need to pass through the root.

	The path sum of a path is the sum of the node's values in the path.

	Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * 
 *                (2)
 *               /   \
 *             (-1)   (3)
 *  output: 5 explanation: [2,3]
 * 
 */                 
public class Max_Path_Sum_not_from_Root {
	
	//Driver method
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		postOrder(root);
		return max;
	}
	
	public  int postOrder(TreeNode root) {
		if(root == null)
			return 0;
		
		int leftSum = Math.max(0, postOrder(root.left)); //left subtree sum
		int rightSum = Math.max(0, postOrder(root.right)); //right subtree sum
		
		max = Math.max(max, (leftSum + rightSum + root.val)); //max till current node
		
		return root.val + Math.max(leftSum, rightSum); //moving forward with greater sum tree which is either left or right
	}

	
	class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(){}
		TreeNode(int val, TreeNode left, TreeNode right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
