package binary_Tree;

public class Symmetric_BinaryTree {
	
	//approach is similar as two binary tree is identical or not
	public static boolean isSymmetricHelper(Node rightTree, Node leftTree) {
		if(rightTree == null && leftTree == null) {
			return true;
		}
		
		return (rightTree != null && leftTree != null)&&
				(isSymmetricHelper(rightTree.left, leftTree.right))&&
				(isSymmetricHelper(rightTree.right, leftTree.left));
				
	}
	
	public static boolean isSymmetric(Node root) {
		return isSymmetricHelper(root.left, root.right);
	}
}
