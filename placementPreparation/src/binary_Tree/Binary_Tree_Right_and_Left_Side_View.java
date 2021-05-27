package binary_Tree;
import java.util.*;
/**
 * @author Satyam Singh
 *                             LEETCODE 199
 * Problem Link : https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 * Description : Given the root of a binary tree, imagine yourself standing on
 *               the right side of it, return the values of the nodes you can
 *               see ordered from top to bottom.
 *               
 * Tree is like :          (1)
 *                        /   \
 *                     (2)     (3)
 *                       \        \
 *                       (5)      (4)
 *  Right View = [1,3,4]
 *  Left View = [1,2,5]
 * 
 * Difficulty : Medium
 */
public class Binary_Tree_Right_and_Left_Side_View {
	
	/*-------------------------------------------------------------
	*-------------------------Right Side View----------------------
	*--------------------------------------------------------------*/
	//using level order traversal to solve this problem 
    //uses BFS approach
    public List<Integer> rightSideView(Node root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(root ==  null)
            return arr;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                
                if(i==size-1)
                    arr.add(node.data);
                
                if(node.left != null)
                    queue.offer(node.left); 
                
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        return arr;
    }
    
    /*-------------------------------------------------------------
	*-------------------------left Side View----------------------
	*--------------------------------------------------------------*/
    
	//using level order traversal to solve this problem 
    //uses BFS approach
    public List<Integer> leftSideView(Node root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(root ==  null)
            return arr;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                
                if(i==0)
                    arr.add(node.data);
                
                if(node.left != null)
                    queue.offer(node.left); 
                
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        return arr;
    }

}
