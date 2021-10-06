package graph;
import java.util.*;
public class CycleDetectionUsingDFS {
	public static boolean isCycle(int curr, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
		visited[curr] = true;
		for(int i: graph.get(curr)) {
			if(visited[i] == false) {
				if(isCycle(i, curr, visited, graph) == true) {
					return true;
				}
			}
			else if(visited[i] == true) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean DetectCycleUsingDFS(int vertices, ArrayList<ArrayList<Integer>> graph) {
		boolean[] visited = new boolean[vertices];
		for(int i=0; i<vertices; i++) {
			if(visited[i] == false) {
				if(isCycle(i, -1, visited, graph) == true) {
					return true;
				}
			}
		}
		return false;
	}
	//main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices: ");
		int vertices = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertices);
		for(int i=0; i<vertices; i++) {
			graph.add(new ArrayList<Integer>());
		}
		System.out.println("Enter the number of edges: ");
		int edges = sc.nextInt();
		for(int i=0; i<edges; i++) {
			addEdge(graph, sc.nextInt(), sc.nextInt());
		}
		System.out.println("Is there cycle present: " + DetectCycleUsingDFS(vertices, graph));	
	}
	//add edge
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int s, int d) {
		graph.get(s).add(d);
		graph.get(d).add(s);
	}

}
