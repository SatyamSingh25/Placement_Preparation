package binary_Tree;
/* Problem description : https://practice.geeksforgeeks.org/problems/full-binary-tree/1/?track=amazon-trees&batchId=192#
 * Difficulty : Medium 
 */
public class IsFullBinaryTree {
	public boolean isFullTree(Node root) {
		if(root == null)
			return true;
		
		if(root.left == null && root.right == null)
			return true;
		
		if(root.left != null && root.right != null)
			return isFullTree(root.left) && isFullTree(root.right);
		
		return false;
	}
}
