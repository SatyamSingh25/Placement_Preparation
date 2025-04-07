package binary_Tree;
/**
Tree Structure:

    1
   / \
  2   3
 / \   \
4   5   6

PreOrder : [1, 2, 4, 5, 3, 6]
InOrder : [4, 2, 5, 1, 3, 6]
*/
import java.util.*;
public class Traversal_Morris {
	
	//Morris Inorder traversal
	public static List<Integer> morrisInOrderTraversal(Node root){
        List<Integer> arr = new ArrayList<>(); //result array

        Node curr = root;
        while(curr != null){
            if(curr.left == null){ //left node doesn't exist mean, collect current number and move towards right substree
                arr.add(curr.data);
                curr = curr.right;
            }
            else{
            	//find inorder Predesessor -> right most node of left substree
                Node pred = curr.left;
                while(pred.right != null && pred.right != curr) //why pred.right != curr = already thread is created
                    pred = pred.right;

                //creating thread, means connected pred.right to currrent subtree parent which is "curr" node
                if(pred.right == null){//means thread not created yet
                    pred.right = curr; //thread created
                    
                    curr = curr.left; //as thread created right now, need to go left
                }
                else{ //thread already created so, need to remove that
                    pred.right = null; //removed the thread
                    
                    arr.add(curr.data); //accessing root
                    
                    curr = curr.right; //moving right, as left tree computation was
                }
            }
        }

        return arr;
	}
	
	//Morris PreOrder traversal
	public static List<Integer> morrisPreOrderTraversal(Node root){
		List<Integer> arr = new ArrayList<>();
		
		Node curr = root;
		
		while(curr != null) {
			if(curr.left == null) {
				arr.add(curr.data);
				curr = curr.right;
			}
			else {
				Node pred = curr.left;
				while(pred.right != null && pred.right != curr) 
					pred = pred.right;
				
				if(pred.right == null) {
					pred.right = curr;
					arr.add(curr.data);
					curr = curr.left;
				}
				else {
					pred.right = null;
					curr = curr.right;
				}
			}
		}
		
		return arr;
	}
	

	public static void main(String[] args) {
		Node root = buildSampleTree();
	    
	    List<Integer> inOrder = morrisInOrderTraversal(root);     // Assuming method is defined
	    List<Integer> preOrder = morrisPreOrderTraversal(root);   // Assuming method is defined
	    
	    System.out.println("InOrder: " + inOrder);
	    System.out.println("PreOrder: " + preOrder);

	}
	
	public static Node buildSampleTree() {
	    Node node4 = new Node(4);
	    Node node5 = new Node(5);
	    Node node6 = new Node(6);
	    Node node2 = new Node(2, node4, node5);
	    Node node3 = new Node(3, null, node6);
	    Node root  = new Node(1, node2, node3);
	    return root;
	}

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
			this.right = right;
		}
	}
}
