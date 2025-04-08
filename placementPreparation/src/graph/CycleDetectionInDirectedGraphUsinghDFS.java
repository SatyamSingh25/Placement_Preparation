package graph;
/**
 * ================================
 * DIRECTED GRAPH 1 (CYCLIC)     |   DIRECTED GRAPH 2 (ACYCLIC)
 * ----------------------------- |   -----------------------------
 * Vertices: 0 to 4              |   Vertices: 0 to 4
 *                               |
 * Edges:                        |   Edges:
 * 0 -> 1                        |   0 -> 1
 * 1 -> 2                        |   1 -> 2
 * 2 -> 3                        |   2 -> 3
 * 3 -> 4                        |   3 -> 4
 * 4 -> 1   <- back edge (cycle) |   (no cycle)
 *                               |
 * Visual:                       |   Visual:
 * 0 -> 1                        |   0 -> 1
 *      |                        |        |
 *      v                        |        v
 *      2 -> 3 -> 4              |        2 -> 3 -> 4
 *      ^i        |              |
 *      -----------              |
 *                               |
 * Expected:                     |   Expected:
 * Cycle Detected                |   No Cycle
 * ================================
 */

//Detecting Cycle in directed graph
import java.util.*;
public class CycleDetectionInDirectedGraphUsinghDFS {
	
	//cycle detection in directed graph using DFS
	private static boolean CycleDetectInDirectedGraph(int vertices, ArrayList<ArrayList<Integer>> graph) {
		boolean[] visited = new boolean[vertices];
		boolean[] recVisited = new boolean[vertices];
		
		for(int i=0; i<vertices; i++) {
			if(visited[i] == false) {
				if(isCycle(i, visited, recVisited, graph) == true) {
					return true;
				}
			}
		}
		return false;
	}
	
	//using DFS approach
	public static boolean isCycle(int curr, boolean[] visited, boolean[] recVisited, ArrayList<ArrayList<Integer>> graph) {
		visited[curr] = true;
		recVisited[curr]  = true;
		
		for(int i: graph.get(curr)) {
			if(visited[i] == false) {
				if(isCycle(i, visited, recVisited, graph) == true) {
					return true;
				}
			}
			else if(visited[i] == true && recVisited[i] == true) {
				return true;
			}
		}
		recVisited[curr] = false;
		
		return false;
	}
	
	//main method
	public static void main(String[] args) {
		// ======= Directed Graph 1 (Cyclic) =======
        int vertices1 = 5;
        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
        for (int i = 0; i < vertices1; i++) graph1.add(new ArrayList<>());

        // Adding edges
        graph1.get(0).add(1);
        graph1.get(1).add(2);
        graph1.get(2).add(3);
        graph1.get(3).add(4);
        graph1.get(4).add(1); // back edge creates cycle

        System.out.println("Graph 1 has cycle: " + CycleDetectInDirectedGraph(vertices1, graph1));

        // ======= Directed Graph 2 (Acyclic) =======
        int vertices2 = 5;
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i < vertices2; i++) graph2.add(new ArrayList<>());

        // Adding edges
        graph2.get(0).add(1);
        graph2.get(1).add(2);
        graph2.get(2).add(3);
        graph2.get(3).add(4);
        // No back edge, so no cycle

        System.out.println("Graph 2 has cycle: " + CycleDetectInDirectedGraph(vertices2, graph2));
	}
	
	//directed graph
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int s, int d) {
		graph.get(s).add(d);
	}

}
