package binary_Tree;

import java.util.*;
public class Min_time_to_burn_tree {
	
	static class Node {
        int data;
        Node left;
        Node right; 
        Node(){
            left = null;
            right = null;
        }
        Node(int val){
        	this.data = val;
        	this.left = null;
        	this.right = null;
        }
    }
	
    private static Node targetNode = null;
    public static int minTime(Node root, int target) {
    	HashMap<Node, Node> parentMap = new HashMap<>();
    	findParent(root, null, parentMap);
    	
    	getNode(root, target);
    	HashSet<Node> visited = new HashSet<>();
    	
    	return maxDistance(targetNode, 0, visited, parentMap);
    }
    
    public static int maxDistance(Node currNode, int distance, HashSet<Node> visited, HashMap<Node, Node> parentMap) {
    	if(currNode == null)
    		return distance - 1;
    	
    	if(visited.contains(currNode))
    		return Integer.MIN_VALUE;
    	
    	//mark visited
    	visited.add(currNode);
    	
    	int left = maxDistance(currNode.left, distance+1, visited, parentMap);
    	int right = maxDistance(currNode.right, distance+1, visited, parentMap);
    	int parent = maxDistance(parentMap.get(currNode), distance+1, visited, parentMap);
    	
    	return Math.max(Math.max(left, right), parent);    	
    }
    
    public static void findParent(Node root, Node parent, HashMap<Node, Node> parentMap) {
    	if(root == null)
    		return;
    	
    	parentMap.put(root, parent);
    	findParent(root.left, root, parentMap);
    	findParent(root.right, root, parentMap);
    }
    
    public static void getNode(Node root, int target) {
    	if(root == null) return;
    	
    	if(root.data == target) {
    		targetNode = root;
    		return;
    	}
    	
    	getNode(root.left, target);
    	getNode(root.right, target);
    }
    
    // Driver code
    public static 
    void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.left = new Node(8);
 
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(10);
        root.left.right.left.left = new Node(11);
 
        // target node is 11
        int target = 11;
 
        System.out.println(minTime(root, target));
    }

}
