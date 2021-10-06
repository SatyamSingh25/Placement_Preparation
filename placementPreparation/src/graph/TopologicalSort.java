package graph;
//Topological Sort using DFS
/**
 * @author SatyamSingh
 * Topological sort:Topological sort  of directed graph is a linear ordering of its vertices such that, 
 * for every directed edge U -> V from vertex U to vertex V, U comes before V in the ordering.
 * 
 */
import java.util.*;
public class TopologicalSort {
	public static void findTopologicalSort(int curr, boolean[] visited, StringBuffer topoSort, ArrayList<ArrayList<Integer>> graph) {
		visited[curr] = true;
		for(int i: graph.get(curr)) {
			if(visited[i] == false) {
				findTopologicalSort(i, visited, topoSort, graph);
			}
		}
		topoSort.append(curr +" ");
	}
	public static void topologicalSort(int vertices, ArrayList<ArrayList<Integer>> graph) {
		StringBuffer topoSort = new StringBuffer();
		boolean[] visited = new boolean[vertices];
		
		for(int i=0; i<vertices; i++) {
			if(visited[i] == false) {
				findTopologicalSort(i, visited, topoSort, graph);
			}
		}
		//this is Topological sort
		System.out.println(topoSort.reverse().toString().trim());
		
	}

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
		topologicalSort(vertices, graph);
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> graph, int s, int d) {
		graph.get(s).add(d);		
	}

}
