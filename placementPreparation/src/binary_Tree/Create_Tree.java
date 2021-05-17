package binary_Tree;

import java.util.*;

class Node{
	int data;
	Node left, right;
	
	Node(){}
	
	Node(int d){
		this.data = d;
		this.left = null;
		this.right = null;
	}
	Node(int d, Node left, Node right){
		this.data = d;
		this.left = left;
		this.right = left;
	}
}
public class Create_Tree {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Node root = createTree();
	}
	
	public static Node createTree() {
		Node root = null;
		System.out.println("Enter root data : ");
		int data = sc.nextInt();
		
		if(data == -1) {
			return null;
		}
		
		root = new Node(data);
		System.out.println("enter left for " + data);
		root.left = createTree();
		
		System.out.println("Enter right for " + data);
		root.right = createTree();
		
		return root;
	}

}
