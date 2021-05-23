package binary_Tree;
import java.util.*;
/*Problem link : https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * 
 *                              LEETCODE 1305
 * 
 * Description : Given two binary search trees root1 and root2.
 *               Return a list containing all the integers from both trees sorted in ascending order.
 * 
 * Difficulty : Medium
 */
public class AllElementsInTwoBinarySearchTrees {
	
	ArrayList<Integer> arr = new ArrayList<Integer>();
    public void traversal(Node root){
        if(root == null)
            return;
        
        traversal(root.left);
        arr.add(root.data);
        traversal(root.right);
        
    }
    public List<Integer> getAllElements(Node root1, Node root2) {
        traversal(root1);
        traversal(root2);
        Collections.sort(arr);
        return arr;
    }

}
