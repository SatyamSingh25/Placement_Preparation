package binary_Tree;

public class SortedArrayToBST {
	
	public Node sortedArrayToBST(int[] arr) {
		return helper(arr, 0, arr.length-1);
	}
	
	public Node helper(int[] arr, int start, int end) {
		if(end < start) return null;
		
		int mid = start + (end - start)/2;
		
		Node root = new Node(arr[mid]);
		root.left = helper(arr, start, mid - 1);
		root.right = helper(arr, mid + 1, end);
		
		return root;
	}

	class Node{
		int val;
		Node left;
		Node right;
		Node(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}		
	}
}
