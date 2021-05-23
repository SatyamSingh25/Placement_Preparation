package binary_Tree;
import java.util.*;

/* Problem link : https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * 
 *                    LEETCODE 230
 *                    
 * Description : Given the root of a binary search tree, and an integer k, return the kth (1-indexed)
 *               smallest element in the tree.
 * 
 * Difficulty : Medium
 */
public class KthSmallestElementIn_Binarytree {
	//slow computation
	ArrayList<Integer> arr = new ArrayList<Integer>();
    void traversal(Node root){
        if(root == null)
            return;
        
        traversal(root.left);
        arr.add(root.data);
        traversal(root.right);
    }
    public int kthSmallest(Node root, int k) {
        traversal(root);
        //Collections.sort(arr);
        return arr.get(k-1);
    }

    //optimized above code is given below 
	//fast computation same with above approach
	public ArrayList<Integer> traversal(Node root, ArrayList<Integer> arr){
        if(root == null)
            return arr;
        
        traversal(root.left, arr);
        arr.add(root.data);
        traversal(root.right, arr);
        
        return arr;
    }
    public int kth_Smallest(Node root, int k) {
        ArrayList<Integer> arr = traversal(root, new ArrayList<Integer>());
        return arr.get(k-1);
    }
}
