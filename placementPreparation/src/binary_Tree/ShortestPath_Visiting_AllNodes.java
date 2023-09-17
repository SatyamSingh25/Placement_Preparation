package binary_Tree;

import java.util.*;
/**
 * @ShortestPath_Visiting_AllNodes
 * @Leetcode_847
 * @BFS_maskCreation
 * @Queue_For_BFS
 * @Set_for_mask_for_each_node
 * @Hard
 */
/* ---------------------------847. Shortest Path Visiting All Nodes-----------------------------------------------
 * You have an undirected, connected graph of n nodes labeled from 0 to n - 1.
 * You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.
 * 
 * Return the length of the shortest path that visits every node. 
 * You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 * 
 * Input: graph = [[1,2,3],[0],[0],[0]]
 * Output: 4
 * Explanation: One possible path is [1,0,2,0,3]
 */
public class ShortestPath_Visiting_AllNodes {
	
	public int shortestPathLengthQueue(int[][] graph) {
		int nodes = graph.length;
		
		Queue<Pair> queue = new LinkedList<>();
		HashSet<Integer>[] masks = new HashSet[nodes];
		
		for(int i=0; i<nodes; i++) {
			masks[i] = new HashSet<>();
			
			//creating mask to get we have covered that node or not
            //means 001 mean 0th node is coverd same as 011 0th and 1st node are covered
			queue.offer(new Pair(0, 0, 1<<i));//adding all node to start its path
			masks[i].add(i<<i);  //adding visited node means current node
		}
		
		while(!queue.isEmpty()) {
			Pair curr = queue.poll();
			
			//all nodes are visited
			if(curr.mask == ((1<<nodes)-1)) { //(1<<size)-1 = all mast  which is 1111
				return curr.distance;
			}
			
			for(int node: graph[curr.node]) {
				//0001 || [(1<<ele) let ele is 1: which is 0010] so newMask is 0011
				int newMask = curr.mask | (1 << node);
				
				if(!masks[node].contains(newMask)) {
					masks[node].add(newMask);
					queue.offer(new Pair(node, curr.distance+1, newMask));
				}
			}
		}
		
		return -1;
	}
	
	class Pair{
		int node, distance, mask;
		Pair(int node, int distance, int mask){
			this.node = node;
			this.distance = distance;
			this.mask = mask;
		}
	}

	public static void main(String[] args) {
		int[][] graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};
		ShortestPath_Visiting_AllNodes obj = new ShortestPath_Visiting_AllNodes();
		System.out.println(obj.shortestPathLengthQueue(graph)); // 4
		
	}

}
