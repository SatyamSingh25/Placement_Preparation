package binary_Tree;

import java.util.*;
public class MaximumSumOf_Non_Adjacent_Nodes_in_BinaryTree {

	public static int getMaxSum_of_non_adjacent_nodes_in_BinaryTree(Node root) {
		
		if(root == null) return 0;
		
		HashMap<Node, Integer> dp = new HashMap<>();
		return solve(root, dp);
	}
	
	public static int solve(Node node, HashMap<Node, Integer> dp) {
		if(node == null) return 0;
		
		if(dp.containsKey(node)) return dp.get(node);
		
		int include = node.val;
		if(node.left != null) {
			include += solve(node.left.left, dp);
			include += solve(node.left.right, dp);
		}
		
		if(node.right != null) {
			include += solve(node.right.left, dp);
			include += solve(node.right.right, dp);
		}
		
		int exclude = solve(node.left, dp) + solve(node.right, dp);
		
		dp.put(node, Math.max(include, exclude));
		
		return dp.get(node);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left = new Node(1);
        System.out.print(getMaxSum_of_non_adjacent_nodes_in_BinaryTree(root)); //output 11 expected
	}
	
	static class Node { 
		int val;
		Node left;
		Node right;
		
		public Node(){ //public constructor
			this.val = 0;
			this.left = null;
			this.right = null;
		}
		public Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
		
		public Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
