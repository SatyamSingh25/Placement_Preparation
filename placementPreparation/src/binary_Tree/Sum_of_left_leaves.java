package binary_Tree;
/**
 * @BinaryTree
 * @BFS
 * @Sum_Of_Left_Leaves
 * @author Satyam
 */
import java.util.*;
public class Sum_of_left_leaves {
	//Method
	public int sumOfLeftLeaves(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		
		int sum = 0;
		
		while(queue.isEmpty()==false) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				Node temp = queue.poll();
				
				if(temp.left != null) {
					if(temp.left.left == null && temp.left.right == null) {
						sum += temp.left.val;
					}
					else {
						queue.offer(temp.left);
					}
				}
				if(temp.right != null) {
					queue.offer(temp.right);
				}
			}
		}
		return sum;
	}
	//Node class
	class Node{
		int val;
		Node left;
		Node right;
		Node() {}
		Node(int val) { 
			this.val = val; 
		}
		Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
		    this.right = right;
		 }
	}
}
