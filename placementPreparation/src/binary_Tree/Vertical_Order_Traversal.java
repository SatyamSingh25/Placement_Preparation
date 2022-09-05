package binary_Tree;
import java.util.*;
/**
 * @Vertical_Order_Traversal
 * @TreeMap
 * @Used_in_bottom_view
 * TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
 * Vertical Level -> horizontal level -> at horizontal Level Nodes
 */
/*---------------------------------------------987. Vertical Order Traversal of a Binary Tree-----------------------------------
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 */
public class Vertical_Order_Traversal {
	
	class Tuple{
        TreeNode node;
        int level;
        int vertical;
        Tuple(){}
        Tuple(TreeNode node, int level, int vertical){
            this.node = node;
            this.level = level;
            this.vertical = vertical;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        //      vertical         level         at level nodes
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));
        
        while(queue.isEmpty() == false){
            int size = queue.size();
            while(size-- != 0){
                Tuple curr = queue.poll();
                TreeNode node = curr.node;
                int level = curr.level;
                int vertical = curr.vertical;
                
                if(map.containsKey(vertical) == false){
                    map.put(vertical, new TreeMap<>());
                }
                
                if(map.get(vertical).containsKey(level) == false){
                    map.get(vertical).put(level, new PriorityQueue<>());
                }
                
                map.get(vertical).get(level).offer(node.val);
                
                if(node.left != null)
                    queue.offer(new Tuple(node.left, level+1, vertical-1));
                
                if(node.right != null)
                    queue.offer(new Tuple(node.right, level+1, vertical+1));
            }
        }
        
        ArrayList<Integer> innerList = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> levels: map.values()){
            innerList = new ArrayList<>();
            for(PriorityQueue<Integer> nodes: levels.values()){
                while(nodes.isEmpty() == false){
                    innerList.add(nodes.poll());
                }
            }
            result.add(innerList);
        }
        return result;
    }

	public static void main(String[] args) {
	}

}
