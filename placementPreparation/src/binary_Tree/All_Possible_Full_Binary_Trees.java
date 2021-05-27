package binary_Tree;
import java.util.*;
/**
 * @author Satyam Singh
 *                               LEETCODE 894
 * Problem link : https://leetcode.com/problems/all-possible-full-binary-trees/
 * 
 * Description : Given an integer n, return a list of all possible full binary trees with n nodes.
 *               Each node of each tree in the answer must have Node.val == 0.

                 Each element of the answer is the root node of one possible tree.
                 You may return the final list of trees in any order.

                 A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 *
 * Difficulty : Medium
 */

/**
 * Definition for a binary tree node.
 * public class Node {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int data) { this.data = data; }
 *     TreeNode(int data, TreeNode left, TreeNode right) {
 *         this.data = data;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class All_Possible_Full_Binary_Trees {
		
	//approach
	public List<Node> allPossibleFBT(int n) {
        ArrayList<Node> ans = new ArrayList<>();
        if(n%2 == 0)
            return ans;
        
        if(n==1){
            ans.add(new Node(0));
            return ans;
        }        
        
        for(int i=1; i<n; i++){
            for(Node left: allPossibleFBT(i)){
                for(Node right: allPossibleFBT(n-i-1)){
                    Node node = new Node(0);
                    node.left = left;
                    node.right = right;
                    ans.add(node);
                }
            }
        }
        
        return ans;
    }
}
