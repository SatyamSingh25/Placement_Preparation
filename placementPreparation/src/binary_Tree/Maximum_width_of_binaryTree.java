package binary_Tree;

/**
 * ------------------------------------Leetcode 662: Maximum Width of Binary Tree-------------------------------
 */
import java.util.*;
public class Maximum_width_of_binaryTree {
	
    public class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        int max = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            int size = queue.size();
            int startIndexOfCurrentLevel = queue.peek().index;

            int first = 0, last = 0;
            for(int i=0; i<size; i++){
                Pair currPair = queue.poll();
                TreeNode currNode = currPair.node;
                int index = currPair.index - startIndexOfCurrentLevel;
                
                if(i == 0)
                    first = index;
                
                if(i == size-1)
                    last = index;
                
                if(currNode.left != null)
                    queue.offer(new Pair(currNode.left, index * 2 + 1));

                if(currNode.right != null)
                    queue.offer(new Pair(currNode.right, index * 2 + 2));
            }
            max = Math.max(max, last - first + 1);
        }

        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
