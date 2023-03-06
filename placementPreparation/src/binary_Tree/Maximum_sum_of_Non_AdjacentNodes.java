package binary_Tree;
/**
 * Maximum sum of non adjacent node
 * means do consider exact after child or parent node.val in result
 * find the maximum sum that we can get
 * 
 * [Similar as Max sum of non adjacent element in array leetcode question]
 * Approach
 * --->Include = node.data
 *     if node.left != null => include += (solve(node.left.left) + solve(node.left.right))
 *     if node.right != null =>  include += (solve(node.right.left) + solve(node.right.right))
 * 
 *     Exclude = solve(node.left) + solve(node.right);
 * 
 *     return Max(include, exclude)
 */
import java.util.*;
public class Maximum_sum_of_Non_AdjacentNodes {
	
	public int getMaxSum_NON_Adjacent_nodes(TreeNode root) {
		
		if(root == null) return 0;
		
		HashMap<TreeNode, Integer> dp = new HashMap<>();
		return solve(root, dp);
	}
	
	public int solve(TreeNode root, HashMap<TreeNode, Integer> dp) {
		
		if(root == null) return 0;
		
		if(dp.containsKey(root)) return dp.get(root);
		
		int include = root.val;
		//if left is not null then in include case LEFT of LEFT and LEFT of RIGHT and add it into Include
		if(root.left != null) {
			include += solve(root.left.left, dp);
			include += solve(root.left.right, dp);
		}
		//if right is not null then in include case RIGHT of LEFT and RIGHT of RIGHT and add it into Include  
		if(root.right != null) {
			include += solve(root.right.left, dp);
			include += solve(root.right.right, dp);
		}
		
		//for exclude case -> just moving forward and not considering the current NODE DATA 
		int exclude = solve(root.left, dp) + solve(root.right, dp);
		
		dp.put(root, Math.max(include, exclude)); //adding Max result till now
		
		return dp.get(root);
		
	}
	
	class TreeNode{
		int val;
		TreeNode left, right;
		TreeNode(){
			this.val = 0;
			this.right = null;
			this.left = null;
		}
	}
}
