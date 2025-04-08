package graph;
import java.util.*;
/**
 * ============================
 * GRAPH 1 (CYCLIC)     |   GRAPH 2 (ACYCLIC)
 * -------------------- |   ---------------------
 * Vertices: 0 to 4     |   Vertices: 0 to 4
 *                      |
 * Edges:               |   Edges:
 * 0 - 1                |   0 - 1
 * 1 - 2                |   1 - 2
 * 2 - 3                |   2 - 3
 * 3 - 4                |   3 - 4
 * 4 - 1   <- cycle     |   (no cycle)
 *                      |
 * Visual:              |   Visual:
 *     0                |       0
 *     |                |       |
 *     1 —— 4           |       1
 *     |    |           |       |
 *     2 -- 3           |       2
 *                      |       |
 *                      |       3
 *                      |       |
 *                      |       4
 *
 * Expected:            |   Expected:
 * Cycle Detected      |   No Cycle 
 * ============================
 */
public class CycleDetectionUsingDFS {
	//Approach
	public static boolean DetectCycleUsingDFS(int vertices, ArrayList<ArrayList<Integer>> graph) {
		boolean[] visited = new boolean[vertices];
		for(int i=0; i<vertices; i++) {
			if(visited[i] == false) {
				if(isCycleUtil(i, -1, visited, graph) == true) {
					return true;
				}
			}
		}
		return false;
	}
	//helper
	public static boolean isCycleUtil(int curr, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
		visited[curr] = true;
		for(int i: graph.get(curr)) {
			if(visited[i] == false) {
				if(isCycleUtil(i, curr, visited, graph) == true) {
					return true;
				}
			}
			else if(i == parent) {
				return true;
			}
		}
		return false;
	}
	
	//Driver Code
	public static void main(String[] args) {
        // ---------- GRAPH 1: Cyclic ----------
        System.out.println("Graph 1 (Cyclic):");

        int vertices1 = 5;
        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
        for (int i = 0; i < vertices1; i++) {
            graph1.add(new ArrayList<>());
        }

        addEdge(graph1, 0, 1);
        addEdge(graph1, 1, 2);
        addEdge(graph1, 2, 3);
        addEdge(graph1, 3, 4);
        addEdge(graph1, 4, 1);  // This edge creates a cycle

        boolean hasCycle1 = DetectCycleUsingDFS(vertices1, graph1);
        System.out.println("Is there a cycle? " + hasCycle1);  // Expected: true

        System.out.println();


        // ---------- GRAPH 2: Acyclic ----------
        System.out.println("Graph 2 (Acyclic):");

        int vertices2 = 5;
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i < vertices2; i++) {
            graph2.add(new ArrayList<>());
        }

        addEdge(graph2, 0, 1);
        addEdge(graph2, 1, 2);
        addEdge(graph2, 2, 3);
        addEdge(graph2, 3, 4);  // No cycle here

        boolean hasCycle2 = DetectCycleUsingDFS(vertices2, graph2);
        System.out.println("Is there a cycle? " + hasCycle2);  // Expected: false;	
	}
	//add edge
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int s, int d) {
		graph.get(s).add(d);
		graph.get(d).add(s);
	}

}
