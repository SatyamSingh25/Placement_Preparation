package binary_Tree;

public class Symmetric_BinaryTree {
	
	//approach is similar as two binary tree is identical or not
	public static boolean isSymmetric(Node rightTree, Node leftTree) {
		if(rightTree == null && leftTree == null) {
			return true;
		}
		
		return (rightTree != null && leftTree != null)&&
				(isSymmetric(rightTree.left, leftTree.right))&&
				(isSymmetric(rightTree.right, leftTree.left));
				
	}
}
