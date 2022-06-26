package graph;
/**
 * @Shortest_Path_to_All_Node
 * @Can_Revisit_any_Node_anytime
 * @BFS_On_Every_Node
 * @Bit_masking_to_Check_all_node_is_visited_Or_Not
 */
/*----------------------------------------847. Shortest Path Visiting All Nodes---------------------------------------------------------------
 * You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i]
 * is a list of all the nodes connected with node i by an edge.

   Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes 
   multiple times, and you may reuse edges.
	
 * Input: graph = [[1,2,3],[0],[0],[0]]
	Output: 4
	Explanation: One possible path is [1,0,2,0,3]
 */

import java.util.*;
public class ShortestPath_to_All_Nodes {

	static class Pair{
        int node; //node which it is.
        int distance; //store till now distance
        int mask; // store how many node covered till now
        Pair(){}
        Pair(int node, int distance, int mask){
            this.node = node;
            this.distance = distance;
            this.mask = mask;
        }
    }
	
	//method
	public static int shortestPathLength(int[][] graph) {
        int size = graph.length;
        Queue<Pair> queue = new LinkedList<>();
        HashSet<Integer>[] masks = new HashSet[size]; //mask array
        
        for(int i=0; i<size; i++){
            masks[i] = new HashSet<>();
            queue.add(new Pair(i, 0, 1<<i));
            masks[i].add(1<<i); //add current mask 1 -> 00001 or 2 -> 00010....etc
        }
        
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            
            if(curr.mask == ((1 << size)-1)){ // all nodes are covered (bit masking)
                return curr.distance;
            }
            
            for(int ele: graph[curr.node]){
                int newMask = curr.mask | (1 << ele); //bit masking
                
                if(masks[ele].contains(newMask) == false){
                    masks[ele].add(newMask);
                    queue.add(new Pair(ele, curr.distance+1, newMask));
                }
            }
        }
        return -1;
    }
	
	//main method
	public static void main(String[] args) {
		int[][] graph = new int[][] {{1,2,3},{0},{0},{0}};
		//result -> 4
		System.out.println(shortestPathLength(graph));
	}

}
