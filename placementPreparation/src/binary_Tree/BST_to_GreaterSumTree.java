package binary_Tree;
/**
 * @author Satyam Singh
 * -----------------------------------LEETCODE 1038/538--------------------------------
 * Problem link : https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 
 * Difficulty: Medium
 */

/**
 * Definition for a binary tree node.
 * public class Node {
 *     int data;
 *     Node left;
 *     Node right;
 *     Node() {}
 *     Node(int data) { 
 *     	this.data = data;
 *     }
 *     Node(int data, Node left, Node right) {
 *         this.data = data;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BST_to_GreaterSumTree {
	
	//reverse InOrder traversal approach is used
	public int sum = 0;
    public Node bstToGst(Node root) {
        if(root == null){
            return null;
        }
        
        bstToGst(root.right);
        root.data = root.data + sum;
        sum = root.data;
        bstToGst(root.left);
        
        return root;
    }
}
