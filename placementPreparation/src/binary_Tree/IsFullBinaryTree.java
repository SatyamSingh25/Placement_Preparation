package binary_Tree;

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
