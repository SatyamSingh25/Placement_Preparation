package binary_Tree;

public class Palindromic_Path_in_BinaryTree_root_to_leaf {
	
	private static int count = 0;
	public static int countPalindromic_path_in_BinaryTree(Node root) {
		
		int[] arr = new int[10];
		postorder(root, arr);
		return count;		
	}
	
	public static void postorder(Node node, int[] arr) {
		
		if(node == null) return;
		
		arr[node.val]++;
		
		postorder(node.left, arr);
		postorder(node.right, arr);
		
		if(node.left == null && node.right == null) {
			int countOdd = 0;
			for(int i: arr) {
				if(i%2 != 0) {
					countOdd++;
					if(countOdd > 1)
						break;
				}
			}
			count += (countOdd > 1) ? 0 : 1;
		}
		
		arr[node.val]--;		
		
	}

	
	public static void main(String[] args) {
	}
	
	class Node { 
		int val;
		Node left, right;
		
		public Node() {
			this.val = 0;
			this.left = null;
			this.right = null;
		}
		public Node(int val) {
			this.val = val;
			this.right = null;
			this.left = null;
		}
	}

}
