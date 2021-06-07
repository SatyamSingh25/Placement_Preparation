package binary_Tree;
/**
 * @contributed_by Satyam Singh
 * Problem link : https://leetcode.com/problems/diameter-of-binary-tree/
 * Description : Given the root of a binary tree, return the length of the diameter of the tree.
                 The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
                 This path may or may not pass through the root.

                 The length of a path between two nodes is represented by the number of edges between them.
                 
   figure :        (1)
                  /   \
                 (2)   (3)
                /  \   
              (4)  (5)
              
  Input: root = [1,2,3,4,5]
  Output: 3
  Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
  
  Difficulty : Easy
 */
public class Diameter_of_BinaryTree {
	public int diameter = 0;

    public int diameterOfBinaryTree(Node root) {
        binaryTreeDiameterHelper(root);
		return diameter;
    }
    //post order approach
    public int binaryTreeDiameterHelper(Node node) {
		if(node == null)
			return 0;

		int leftDepth = binaryTreeDiameterHelper(node.left);
		int rightDepth = binaryTreeDiameterHelper(node.right);

		if((leftDepth + rightDepth) > diameter)
				diameter = leftDepth + rightDepth;

		return Math.max(leftDepth+1, rightDepth+1);
		
	 }
}
