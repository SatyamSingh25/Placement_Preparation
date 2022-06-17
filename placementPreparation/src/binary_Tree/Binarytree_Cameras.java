package binary_Tree;

import java.util.HashSet;
import java.util.Set;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Binarytree_Cameras {
	public static void main(String[] args) {
		System.out.println("hello");
	}
	/**
     * Approach 1 -> Time: O(N) Space -> O(N)
     * BOTTOM - UP approach
     */

    int cam;
    Set<TreeNode> monitored;
    // Method 1 
    public int minCamNeeds(TreeNode root){
        if(root == null) return 0;

        cam=0;
        monitored = new HashSet<>();

        monitored.add(null); //one level ahead

        dfs(root, null);

        return cam;
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if(node == null) return;

        dfs(node.left, node);
        dfs(node.right, node); //now ab the BOTTOM on the tree

        if(parent == null && !monitored.contains(node) //this checking for root node
                || !monitored.contains(node.left) || !monitored.contains(node.right)){ // this checking for children

            cam++;
            monitored.add(node);
            monitored.add(parent);
            monitored.add(node.left);
            monitored.add(node.right);
        }
    }

    /**
     * Approach 2 -> Time: O(N) Space:O(H)
     * FAST
     */

    /** Method 2 */
    int cam2 = 0;
    public int minCamNeed2(TreeNode root){
        //0 -> root doesn't have camera so we have to add into that
        return dfs2(root) == 0 ? cam2+1 : cam2;
    }

    // 0 -> Not covered by Cameras
    // 1 -> covered by cameras
    // 2 -> Has a Camera
    public int dfs2(TreeNode root){
        if(root == null) return 1;

        int left = dfs2(root.left);
        int right = dfs2(root.right);

        if(left == 0 || right == 0){ //if left OR right child doesn't have camera -> camera has to be installed
            cam++;
            return 2;
        }
        else if(left == 2 || right == 2){ // if left OR right anyone has a Camera -> then cavered by cameras
            return 1;
        }
        else{
            return 0;
        }
    }
}
