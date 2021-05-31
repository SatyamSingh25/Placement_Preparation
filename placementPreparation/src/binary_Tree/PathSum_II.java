package binary_Tree;
import java.util.*;
/**
 * @author Satyam Singh
 * -----------------------------LEETCODE 113------------------------------------------
 * Problem link : https://leetcode.com/problems/path-sum-ii/
 * Description : Given the root of a binary tree and an integer targetSum,
 *               return all root-to-leaf paths where each path's sum equals targetSum.

                 A leaf is a node with no children.
      
   Difficulty : Medium
 */
public class PathSum_II {
	//similar approach with Path Sum with targetValue 
	List<List<Integer>> arr = new LinkedList<List<Integer>>();
    ArrayList<Integer> innerList = new ArrayList<Integer>();
    
    public List<List<Integer>> pathSum(Node root, int targetSum) {
        if(root == null)
            return arr;
        
        innerList.add(root.data);
        
        //at this point got a nodes which path sum is same as targetSum 
        if((root.left == null) && (root.right == null) && (targetSum == root.data)){
            arr.add(new ArrayList(innerList)); //inserting current list
        }
        //going left by node
        if(root.left != null){
            pathSum(root.left , targetSum - root.data);
        }
        //going right by node
        if(root.right != null){
            pathSum(root.right, targetSum - root.data);
        }
        innerList.remove(innerList.size()-1);
        return arr;
    }
}