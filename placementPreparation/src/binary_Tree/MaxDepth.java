package binary_Tree;
/* Problem link : https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
 * Desription : Given the root of a binary tree, return its maximum depth. 
 *              A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * Difficulty : Easy
 */
public class MaxDepth {
	
	//find maximum heigth in binary tree
	public int maxDepth(Node root) {
		if(root == null)
			return 0;
		
		//calculating left tree height
		int left = maxDepth(root.left);
		
		//calculating right subtree height
		int right = maxDepth(root.right);
		
		return Math.max(left, right)+1;
	}

}
