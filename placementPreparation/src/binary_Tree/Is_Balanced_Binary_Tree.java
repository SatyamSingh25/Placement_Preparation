package binary_Tree;
/*Description : https://leetcode.com/problems/balanced-binary-tree/
 * Difficulty : Easy
 * 
 * Main Point : A binary tree is called balanced binary tree if left and right subtree hieght differnce is <=1. 
 */
public class Is_Balanced_Binary_Tree {
	
	public int height(Node root){
        if(root == null){
            return 0;
        }
        
        int left = height(root.left);
        int right = height(root.right);
        
        return Math.max(left, right)+1;
    }
	
    public boolean isBalanced(Node root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        
        //conditions for skewed trees
        if(isBalanced(root.left) == false){
            return false;
        }
        if(isBalanced(root.right) == false){
            return false;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        if(Math.abs(leftHeight - rightHeight) <= 1){
            return true;
        }
        return false;
    }
}
