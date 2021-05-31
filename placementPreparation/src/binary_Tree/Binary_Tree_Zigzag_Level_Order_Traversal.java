package binary_Tree;
import java.util.*;
/**
 * @author Satyam Singh
 * ------------------------------LEETCODE 103------------------------------------
 * problem link : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * description : Given the root of a binary tree, return the zigzag level order traversal
 *               of its nodes' values. (i.e., from left to right, then right to left for 
 *               the next level and alternate between).
 * 
 * Difficulty : Medium
 */

/**
 * Definition for a binary tree node.
 * public class Node {
 *     int data;
 *     Node left;
 *     ode right;
 *     Node() {}
 *     Node(int data) { this.data = data; }
 *     Node(int data, Node left, Node right) {
 *         this.data = data;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal {
	
	//uses level order traversal to solve this problem
	//uses BFS approach
	public List<List<Integer>> zigzagLevelOrder(Node root) {
		//resulting ArrayList.
        List<List<Integer>> arr = new LinkedList<List<Integer>>();
        
        //base condition
        if(root == null){
            return arr;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> innerList = new ArrayList<Integer>(size);
            
            for(int i=0; i<size; i++){
                Node newNode = queue.poll();
                innerList.add(newNode.data);
                
                if(newNode.left != null){
                    queue.add(newNode.left);
                }
                
                if(newNode.right != null){
                    queue.add(newNode.right);
                }
            }
            //next "if" is very important condition for this problem.
            if(arr.size()%2 != 0){
                Collections.reverse(innerList);
            }
            arr.add(innerList);
        }
        return arr;
    }
}
