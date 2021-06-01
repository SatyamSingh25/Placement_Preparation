package binary_Tree;
import java.util.*;
/**
 * @author Satyam Singh
 * ---------------------------------LEETCODE 98------------------------------
 * Problem link : https://leetcode.com/problems/validate-binary-search-tree/
 * Difficulty : Medium
 */
public class IsValidBST {
	
	//using stack to solve this problem
	public boolean isValidBST(Node root) {
        Stack<Node> st = new Stack<Node>();
        double leftData = - Double.MAX_VALUE;
        
        if(root.left == null && root.right == null)
            return true;
        
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            if(root.data <= leftData){
                return false;
            }
            
            leftData = root.data;
            root = root.right;	//going to right tree
        }
        return true;
    }
}
