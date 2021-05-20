package binary_Tree;
import java.util.*;
public class PathSum_with_TargetValue {
	
	
	//recursive approach
	public boolean hasPathSum(Node root, int targetSum) {
        if(root == null){
            return false;
        }
        else if(root.left == null && root.right == null && targetSum - root.data == 0){
            return true;
        }
        
        return hasPathSum(root.left, targetSum-root.data) || hasPathSum(root.right, targetSum-root.data);
    }
	
	//printing path sum is equal to target sum or not
	public int x = 0;
	public Stack<Integer> st = new Stack<Integer>();
	public void pathSum(Node root, int sum) {
		if(root == null)
			return ;
		
		x = x + root.data;
		st.push(root.data);
		if(x == sum) {
			printStack(st);
			return; // if we do not right return then it print all posible paths
		}
		
		pathSum(root.left, sum);
		pathSum(root.right, sum);
		
		if(root.left == null && root.right == null) {
			x = x-root.data;
			st.pop();
		}
	}
	
	public void printStack(Stack<Integer> st) {
		String s = "";
		while(!st.isEmpty()) {
			s = "->" + st.pop();
		}
		
		System.out.println(s.substring(1));
	}
}
