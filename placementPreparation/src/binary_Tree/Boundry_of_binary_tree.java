package binary_Tree;

public class Boundry_of_binary_tree {

	public static void printBoundry(Node root) {
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		
		printBoundryLeft(root.left);
		
		printLeaf(root.left);
		printLeaf(root.right);
		
		printBoundryRight(root.right);
	}
	
	public static void printBoundryLeft(Node root) {
		if(root == null)
			return;
		
		if(root.left != null) {
			System.out.print(root.data + " ");
			printBoundryLeft(root.left);
		}
		else if(root.right != null) {
			System.out.print(root.data + " ");
			printBoundryLeft(root.right);
		}
	}
	
	public static void printLeaf(Node root) {
		if(root == null) 
			return;
		
		printLeaf(root.left);
		
		if(root.left == null && root.right == null) 
			System.out.print(root.data + " ");
		
		printLeaf(root.right);
	}
	
	public static void printBoundryRight(Node root) {
		if(root == null)
			return;
		
		if(root.right != null) {
			printBoundryRight(root.right);
			System.out.print(root.data + " ");
		}
		else if(root.left != null) {
			printBoundryRight(root.left);
			System.out.print(root.data + " ");
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        
        printBoundry(root);
	}
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int val){
			this.data = val;
			this.left = null;
			this.right= null;
		}
	}

}
