package binary_Tree;
import java.util.*;
/* Problem link : https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * 
 *                    LEETCODE 671
 *                    
 * Description : Given a non-empty special binary tree consisting of nodes with
 *               the non-negative value, where each node in this tree has exactly
 *               two or zero sub-node. If the node has two sub-nodes, then this node's
 *               value is the smaller value among its two sub-nodes. More formally,
 *               the property root.val = min(root.left.val, root.right.val) always holds.
 *               Given such a binary tree, you need to output the second minimum value
 *               in the set made of all the nodes' value in the whole tree.
 *               
 *               If no such second minimum value exists, output -1 instead.
 * 
 * Difficulty : Easy
 */
public class SecondMinimumNodeInBinaryTree {
	//Naive Method------------------------------------------------------------
	//Time Complexity : O(n)               [n = Number of Node]
    //Space Complexity : O(n)               [n = Number of node]
	ArrayList<Integer> arr = new ArrayList<>();
    void traversal(Node root){
        if (root == null)
            return;
        
        traversal(root.left);
        traversal(root.right);
        arr.add(root.data);
    }
    public int find_SecondMinimumValue(Node root) {
        //traverasal
        traversal(root);
        Collections.sort(arr);
        if(arr.size() == 2 && arr.get(0)==arr.get(1)){
            return -1;
        }
        int first = arr.get(0);
        int i;
        for(i=1; i<arr.size(); i++){
            if(first != arr.get(i)){
                break;
            }
        }
        if(i == arr.size()){
            return -1;
        }
        
        return arr.get(i);
    }
	
	//Efficient Method -------------------------------------------------------
    //Time Complexity : O(n)               [n = Number of Node]
    //Space Complexity : O(1)               [Constant time ;)  ]
	public int findSecondMinimumValue(Node root) {
        helper(root);
        return min2 == null ? -1 : min2;
    }
    
    private Integer min1 = null, min2 = min1;
    
    private void helper(Node node) {
        if (node == null) return;
        helper(node.left);
        helper(node.right);
        if (min1 == null || node.data < min1) {
            min2 = min1;
            min1 = node.data;
        } else if (node.data > min1 && (min2 == null || node.data < min2))
            min2 = node.data;
    }
}
