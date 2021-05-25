package binary_Tree;
import java.util.*;
/**
 * code @author Satyam
 *                              LEETCODE 102
 * Problem link : https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Difficulty : Medium
 */
public class Level_Order_Traversal {
	
	//simple BFS approach
	public List<List<Integer>> levelOrder(Node root) {
        
        if(root == null){
            return new LinkedList<List<Integer>>();
        }
        List<List<Integer>> arr = new LinkedList<List<Integer>>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> innerList = new ArrayList<Integer>();
            
            for(int i=0; i<size; i++){
            	Node temp = queue.poll();
                innerList.add(temp.data);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            arr.add(innerList);
        }
        return arr;
    }
	
	/**
	 * Definition for a binary tree node.
	 * public class Node {
	 *     int data;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int data) { this.data = data; }
	 *     TreeNode(int data, Node left, Node right) {
	 *         this.data = data;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
}
