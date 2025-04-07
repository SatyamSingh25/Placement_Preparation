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
	        //      line    ,Value
	        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
	        Queue<Pair> queue = new LinkedList<>();
	        
	        queue.offer(new Pair(root, 0));
	        
	        while(queue.isEmpty() == false){
	            Pair temp = queue.poll();
	            Node currNode = temp.node;
	            int line = temp.line;
	            
	            sortedMap.put(line, currNode.data);
	            
	            if(currNode.left != null){
	                queue.offer(new Pair(currNode.left, line-1));
	            }
	            if(currNode.right != null){
	                queue.offer(new Pair(currNode.right, line+1));
	            }
	        }
	        
	        ArrayList<Integer> arr = new ArrayList<>(sortedMap.values());
	        
	        return arr;
	    }

	 public static void main(String[] args) {}
}
