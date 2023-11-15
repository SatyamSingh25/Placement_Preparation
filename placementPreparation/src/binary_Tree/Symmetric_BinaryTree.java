package binary_Tree;

public class Symmetric_BinaryTree {
	
	//approach is similar as two binary tree is identical or not
	public boolean isSymmetric(TreeNode root) {
		if(root == null || (root.left == null && root.right == null))
			return true;
			
		return check(root.left, root.right);
	}
	
	public boolean check(TreeNode left, TreeNode right) {
		if(left == null && right == null)
			return true;
		
		if((left != null && right != null)&&(left.val == right.val)) 
			return check(left.left, right.right) && check(left.right, right.left);
		
		return false;
	}
}
