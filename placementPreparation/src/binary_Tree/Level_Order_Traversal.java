package binary_Tree;
import java.util.*;
/*
 * Level order traversal
 */
public class Level_Order_Traversal {
	
	//simple BFS approach
	ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public void levelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			arr.add(temp.data);
			
			if(temp.left != null) {
				queue.add(temp.left);
			}
			
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
		
		arr.add(null);
		
	}
}
