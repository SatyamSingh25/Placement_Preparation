package graph;
/**
 * @Graph
 * @Shortest_Path_0_to_all_Nodes_in_Alternate_Color_Edges
 * @BFS
 * @2_Graph_Directed
 */
/*
 * -------------------------------------1129. Shortest Path with Alternating Colors-------------------------------------
 * You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. 
 * Each edge is red or blue in this graph, and there could be self-edges and parallel edges.

	You are given two arrays redEdges and blueEdges where:
		-> redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, 
		-> blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
		
	Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x 
	such that the edge colors alternate along the path, or -1 if such a path does not exist.
	
	Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
	Output: [0,1,-1]
 */
import java.util.*;
public class ShortestPath_Alternate_Colors {

	//Main Methof
	public static void main(String[] args) {
		int[][] redEdges = new int[][] {{0,1}};
		int[][] blueEdges = new int[][] {{2,1}};
		
		int[] result = shortestAlternatingPaths(3, redEdges, blueEdges);
		//result -> [0,1,-1]
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer, ArrayList<Integer>> redGraph = createGraph(n, redEdges);
        HashMap<Integer, ArrayList<Integer>> blueGraph = createGraph(n, blueEdges);
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][2];
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        //0 -> red
        //1 -> blue
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        visited[0][0] = true;
        visited[0][1] = true;
        
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- != 0){
                int[] curr = queue.poll();
                result[curr[0]] = result[curr[0]]==-1 ? step : Math.min(result[curr[0]], step);
                
                if(curr[1] == 1){ //at Blue so go with Red edges
                    if(redGraph.containsKey(curr[0])){
                        for(int i: redGraph.get(curr[0])){
                            if(visited[i][0])
                                continue;
                            
                            queue.offer(new int[]{i, 0});
                            visited[i][0] = true;
                        }
                    }
                }
                else{ //at RED Edge so go with Blue Edges
                    if(blueGraph.containsKey(curr[0])){
                        for(int i: blueGraph.get(curr[0])){
                            if(visited[i][1])
                                continue;
                            
                            queue.offer(new int[]{i, 1});
                            visited[i][1] = true;
                        }
                    }
                }
            }
            step++;
        }
        return result;   
    }
	
	//graph creation
    public static HashMap<Integer, ArrayList<Integer>> createGraph(int n, int[][] edges){
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        
        for(int[] currEdge: edges){
            graph.putIfAbsent(currEdge[0], new ArrayList<Integer>());
            graph.get(currEdge[0]).add(currEdge[1]);
        }
        return graph;
    }

}
