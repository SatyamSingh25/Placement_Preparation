package binary_Tree;
import java.util.*;
public class Binary_Tree_Bottom_view {
	
	class Pair{
	    Node node;
	    int line;
	    Pair(){}
	    Pair(Node n, int line){
	        this.node = n;
	        this.line = line;
	    }
	}
	
	 public ArrayList <Integer> bottomView(Node root){
	        //      line    ,node
	        TreeMap<Integer, Node> sortedMap = new TreeMap<>();
	        Queue<Pair> queue = new LinkedList<>();
	        
	        queue.offer(new Pair(root, 0));
	        
	        while(queue.isEmpty() == false){
	            Pair temp = queue.poll();
	            Node currNode = temp.node;
	            int line = temp.line;
	            
	            sortedMap.put(line, currNode);
	            
	            if(currNode.left != null){
	                queue.offer(new Pair(currNode.left, line-1));
	            }
	            if(currNode.right != null){
	                queue.offer(new Pair(currNode.right, line+1));
	            }
	        }
	        
	        Collection<Node> result = sortedMap.values();
	        ArrayList<Integer> arr = new ArrayList<>();
	        
	        for(Node i: result){
	            arr.add(i.data);
	        }
	        return arr;
	    }

	 public static void main(String[] args) {}
}
