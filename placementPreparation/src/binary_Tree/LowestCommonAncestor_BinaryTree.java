package binary_Tree;
/**
 * @LowestCommmonAncestor
 * @Tree
 * @PostOrderTragversal
 * @Approach - take left node and right node both from bottom to up then if from both left right are not null
 *             then current node is LOWEST COMMON ANCESTOR 
 */
/*
 * --------------------------------------236. Lowest Common Ancestor of a Binary Tree--------------------------------------
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */

public class LowestCommonAncestor_BinaryTree {
	
	public static Node lowestCommonAncestor(Node root, Node p, Node q) {
		
		if(root == null || root == p || root == q)
			return root;
		
		Node leftNode = lowestCommonAncestor(root.left, p, q);
		Node rightNode = lowestCommonAncestor(root.right, p, q);
		
		if(leftNode == null)
			return rightNode;
		else if(rightNode == null)
			return leftNode;
		else
			return root; //lowest common ancestor
	}
	
	static class Node{
		int val;
		Node left;
		Node right;
		
		Node(){}
		Node(int val, Node left, Node right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
	}
	

}
