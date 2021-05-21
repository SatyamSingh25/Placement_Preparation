package binary_Tree;
/*problem link : https://leetcode.com/problems/binary-tree-tilt/
 *
 * Description : Given the root of a binary tree, return the sum of every tree node's tilt.
                 The tilt of a tree node is the absolute difference between the sum of all
                 left subtree node values and all right subtree node values. If a node does
                 not have a left child, then the sum of the left subtree node values is treated as 0.
                 The rule is similar if there the node does not have a right child.
    
    Difficulty : Easy
 */
public class BinaryTreeTilt {
	
	int res = 0;
	//parent method
    public int findTilt(Node root) {
        tilt(root); //helper function
        return res;
    }
    //postorder appraoch
    private int tilt(Node root) {
        if (root == null) return 0;
        
        int leftSum = tilt(root.left);
        int rightSum = tilt(root.right);
        
        res += Math.abs(leftSum - rightSum);
        
        return leftSum + rightSum + root.data;
    }
}
