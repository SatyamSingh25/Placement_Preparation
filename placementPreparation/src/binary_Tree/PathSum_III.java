package binary_Tree;
/*
 * Path Sum 3 leetcode
 * Count all paths which has sum equal to target value in binary tree
 * starting node can be OR cannot be a root node
 * 
 */
import java.util.*;
public class PathSum_III {
	
	private static int countPaths = 0;
	public static int pathSum(TreeNode root, int target) {
		if(root == null)
			return 0;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(queue.isEmpty() == false) {
			TreeNode currNode = queue.poll();
			
			getSumUpcomingPath(currNode, target);
			if(currNode.left != null)
				queue.offer(currNode.left);
			if(currNode.right != null)
				queue.offer(currNode.right);
		}
		return countPaths;
	}
	
	public static void getSumUpcomingPath(TreeNode root, int target) {
		int sum = target - root.val;
		if(sum == 0)
			countPaths++;
		
		if(root.left != null)
			getSumUpcomingPath(root.left, target - root.val);
		if(root.right != null)
			getSumUpcomingPath(root.right, target - root.val);
			
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	}
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
