package graph;
//Detecting Cycle in directed graph

import java.util.*;
public class CycleDetectionInDirectedGraphUsinghDFS {
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
	
	//main method
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter number of vertices: ");
		int vertices = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertices);
		for(int i=0; i<vertices; i++) {
			graph.add(new ArrayList<Integer>());
		}
		System.out.println("Enter number of Edges: ");
		int edges =  sc.nextInt();
		for(int i=0; i<edges; i++) {
			addEdge(graph, sc.nextInt(), sc.nextInt());
		}
		System.out.println("Cycle found in directed graph: "+ CycleDetectInDirectedGraph(vertices, graph));
	}
	
	//directed graph
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int s, int d) {
		graph.get(s).add(d);
	}

}
