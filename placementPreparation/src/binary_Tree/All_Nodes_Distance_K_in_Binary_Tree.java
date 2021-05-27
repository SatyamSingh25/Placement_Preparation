package binary_Tree;
import java.util.*;
/* Problem link : https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * 
 *                                  LEETCODE 863
 * 
 * description : We are given a binary tree (with root node root), a target node, and an integer value k.
 *               Return a list of the values of all nodes that have a distance k from the target node.
 *               The answer can be returned in any order.
 *               
 * Difficulty : Medium
 */
public class All_Nodes_Distance_K_in_Binary_Tree {
	
	//approach using BFS
    public List<Integer> distanceK(Node root, Node target, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(root == null){
            return result;
        }
        HashMap<Node, Node> parentList = new HashMap<>();
        findingParents(parentList, root);
        
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        
        queue.add(target);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node temp = queue.poll();
                visited.add(temp);
            
                if(k==0){
                    result.add(temp.data);
                }
            
                if(parentList.containsKey(temp) && !visited.contains(parentList.get(temp))){
                    queue.add(parentList.get(temp));
                }
            
                if(temp.left != null && !visited.contains(temp.left)){
                    queue.add(temp.left);
                }
            
                if(temp.right != null && !visited.contains(temp.right)){
                    queue.add(temp.right);
                }
            }
            k--;            
            if(k<0)
                break;
        }
        return result;
    }
    public static void findingParents(HashMap<Node, Node> parentList, Node root){
        if(root == null) 
        	return;
        
        if(root.left != null)
            parentList.put(root.left, root);
        
        if(root.right != null)
            parentList.put(root.right, root);
    
        findingParents(parentList, root.left);
        findingParents(parentList, root.right);
    }
}
