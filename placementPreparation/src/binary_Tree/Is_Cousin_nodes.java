package binary_Tree;

//we have to find that X and Y are Cousin or not
//cousin nodes -> not from same parent with same depth
//same depth means -> level-wise -> BFS
import java.util.*;
public class Is_Cousin_nodes {
	
	public static boolean isCousin(TreeNode root, int x, int y) {
		if(root == null)
			return false;
		
		if(root.left == null && root.right == null)
			return false;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		
		while(queue.isEmpty() == false) {
			int size = queue.size();
			boolean XFound = false, YFound = false;
			while(size-- != 0) {
				TreeNode currNode = queue.poll();
				
				if(currNode.val == x) //X found
					XFound = true;
				if(currNode.val == y) // Y found
					YFound = true;
				
				//if X and Y both are from same parent then return FALSE
				if(currNode.left != null && currNode.right != null) {
					if((currNode.left.val == x && currNode.right.val == y) ||
							(currNode.left.val == y && currNode.right.val == x)) {
						return false;
					}
				}
				
				if(currNode.left != null)
					queue.offer(currNode.left);
				if(currNode.right != null)
					queue.offer(currNode.right);
			}
			//X and Y are found and they are not from same Parent node then return TRUE
			if(XFound && YFound)
				return true;
		}		
		
		return false;
	}

	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(){}
		TreeNode(int n, TreeNode left, TreeNode right){
			this.val = n;
			this.left = left;
			this.right = right;
		}
	}
}
