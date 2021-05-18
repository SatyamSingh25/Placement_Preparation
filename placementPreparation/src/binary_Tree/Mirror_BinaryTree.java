package binary_Tree;
/*Description : 
 *  		1							1
 *		  /   \                       /   \
 *  	2		3        ======>     3     2
 *    /   \   /   \                 / \   / \
 *   4	   5 6	   7               7   6 5   4
 *  
 * Approach : traverse the tree in a postorder fashion, and for every node,
 * swap its left and right child pointer after recursively converting its
 * left and right subtree to mirror first.  
 * 
 * Difficulty : Easy
 */
public class Mirror_BinaryTree {
	
	public static void swap(Node root) {
		if(root ==  null) {
			return ;
		}
		
		Node temp = root.left;
		root.left = root.right;
		root.left = temp;
	}
	
	public static void mirrorTree(Node root) {
		if(root == null) {
			return ;
		}
		
		mirrorTree(root.left);
		mirrorTree(root.right);
		swap(root);
		
	}
}
