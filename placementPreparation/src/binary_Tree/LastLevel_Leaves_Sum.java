package binary_Tree;
import java.util.*;
public class LastLevel_Leaves_Sum {	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
	}
	
	public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        if(root.left == null && root.right == null) return root.val;
        int sum = 0, prevSum = 0;
        while(queue.isEmpty() == false){
            int size = queue.size();
            while(size-- != 0){
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    queue.offer(temp.left);
                    sum += temp.left.val;
                }
                if(temp.right != null) {
                    queue.offer(temp.right);
                    sum += temp.right.val;
                }             
            }
            
            if(queue.isEmpty())
                return prevSum;
            else{
                prevSum = sum;
                sum =0;
            }
        }
        return prevSum;
    }

}
