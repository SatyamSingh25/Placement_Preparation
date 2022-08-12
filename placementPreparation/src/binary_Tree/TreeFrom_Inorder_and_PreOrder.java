package binary_Tree;
import java.util.*;
public class TreeFrom_Inorder_and_PreOrder {
	static HashMap<Integer, Integer> indexes;
	public static Node BuildTree_From_Inorder_and_Preorder(int[] preorder, int[] inorder) {
		indexes = new HashMap<>();
		for(int i=0; i<preorder.length; i++)
			indexes.put(preorder[i], i);
		
		return convertFrom_Pre_In_Order_Array(0, preorder.length-1, preorder, inorder);
	}
	
	public static Node convertFrom_Pre_In_Order_Array(int left, int right, int[] preorder, int[] inorder) {
		if(left > right)
			return null;
		
		int headVal = preorder[left++];
		Node head = new Node(headVal);
		
		head.left = convertFrom_Pre_In_Order_Array(left, indexes.get(headVal)-1, preorder, inorder);
		head.right = convertFrom_Pre_In_Order_Array(indexes.get(headVal)+1, right, preorder, inorder);
		
		return head;
				
	}
	
	static class Node{
		int val;
		Node left;
		Node right;
		
		Node(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}
		
		Node(int val, Node left, Node right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) {
	}

}
