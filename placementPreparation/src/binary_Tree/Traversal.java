package binary_Tree;

import java.util.Scanner;


public class Traversal {
	
	public static class Node{
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
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Node root = createTree();
		
		inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
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
	
	public static void inOrder(Node root) {
		if(root == null) {
			return ;
		}
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static void preOrder(Node root) {
		if(root == null) {
			return ;
		}
		
		System.out.print(root.data+ " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(Node root) {
		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data+ " ");
	}
}
