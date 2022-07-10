package binary_Tree;
/* Problem link : https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Description : Given a binary tree, find its minimum depth.
 *               The minimum depth is the number of nodes along the shortest path 
 *               from the root node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Difficulty : Easy
 */
public class MinDepth {
	
	//recursive approach
	public int minDepth(Node root) {
        if(root == null)
            return 0;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(left == 0 || right == 0){
            return left + right + 1;
        }
        
        return Math.min(left, right)+1;
    }

}
