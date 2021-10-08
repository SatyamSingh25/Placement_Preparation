package graph;
import java.util.*;
public class ShortestPathIn_DAG {
	public static void findTopologicalSort(int curr, Stack<Integer> stack, boolean[] visited, ArrayList<ArrayList<WeightedEdge>> graph) {
		visited[curr] = true;
		for(WeightedEdge i: graph.get(curr)) {
			if(visited[i.destination] == false) {
				findTopologicalSort(i.destination, stack, visited, graph);
			}
		}
		stack.push(curr);
	}
	
	public static void topologicalSort(ArrayList<ArrayList<WeightedEdge>> graph, int vertices, int source) {
		boolean[] visited = new boolean[vertices];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<vertices; i++) {
			if(visited[i] == false) {
				findTopologicalSort(i, stack, visited, graph);
			}
		}
		
		//shortest path using BFS with WEIGHT graph
		int[] dist = new int[vertices];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;
		
		while(stack.isEmpty() == false) {
			int node = stack.pop();
			if(node != Integer.MAX_VALUE) {
				for(WeightedEdge adj: graph.get(node)) {
					if(dist[node]+adj.weight < dist[adj.destination]) {
						dist[adj.destination] = dist[node]+adj.weight;
					}
				}
			}			
		}
		
		for(int i=0; i<vertices; i++) {
			System.out.println(source + " to " + i + ": " + dist[i]);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices: ");
		int vertices = sc.nextInt();
		ArrayList<ArrayList<WeightedEdge>> graph = new ArrayList<>(vertices);
		for(int i=0; i<vertices; i++) {
			graph.add(new ArrayList<WeightedEdge>());
		}
		System.out.println("Enter the number of edges: ");
		int edges = sc.nextInt();
		System.out.println("Enter edges: ");
		for(int i=0; i<edges; i++) {
			int source = sc.nextInt();
			int node = sc.nextInt();
			int w = sc.nextInt();
			graph.get(source).add(new WeightedEdge(node, w));
		}	
		System.out.println("Enter the source: ");
		topologicalSort(graph, vertices, sc.nextInt());
		
		sc.close();
	}
	static class WeightedEdge{
		int destination, weight;
		WeightedEdge(int d, int w){
			this.destination = d;
			this.weight = w;
		}
	}

}
