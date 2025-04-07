package binary_Tree;
import java.util.*;
/**
 * @author Satyam
 *                               LEETCODE 107
 * Problem link : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * Description  : Given the root of a binary tree, return the bottom-up level order
 *                traversal of its nodes' values. (i.e., from left to right, level by
 *                level from leaf to root).
 *                
 *               
 * Tree is like : (3)
 *               /   \
 *              (9)  (20)
 *                   /  \
 *                 (15)  (7)
 *                 
 * input : root = [3,9,20,null,null,15,7]
 * Output :  [[15,7],[9,20],[3]]
 * 
 * Difficulty : Medium
 */
public class BinaryTree_Level_Order_Traversal_II {
	/**
	 * Definition for a binary tree node.
	 * public class Node {
	 *     int data;
	 *     Node left;
	 *     Node right;
	 *     Node() {}
	 *     Node(int data) { this.data = data; }
	 *     Node(int data, Node left, Node right) {
	 *         this.data = data;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	
	//approach is similar as Level order traversal
	public List<List<Integer>> levelOrderBottom(Node root) {
        if(root == null)
            return new LinkedList<List<Integer>>();
        
        List<List<Integer>> arr = new LinkedList<List<Integer>>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> innerList = new ArrayList<Integer>();
            
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                innerList.add(node.data);
                
                if(node.left != null)
                    queue.add(node.left);
                
                if(node.right != null)
                    queue.add(node.right);
            }
            arr.add(0, innerList); // adding in front avoiding reverse as using LL data structur to store data, this isO(1) opr
        }
        return arr;
    }
}
