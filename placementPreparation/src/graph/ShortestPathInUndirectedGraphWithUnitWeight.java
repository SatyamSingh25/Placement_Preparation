package graph;
//shortest path using BFS with UNIT WEIGHT graph
//unidirected graph
import java.util.*;
public class ShortestPathInUndirectedGraphWithUnitWeight {
	//shortest path using BFS with UNIT WEIGHT graph
	public static void shortestPathBFS(int source, ArrayList<ArrayList<Integer>> graph) {
		int[] weight = new int[graph.size()];
		Arrays.fill(weight, Integer.MAX_VALUE);
		Queue<Integer> queue = new LinkedList<Integer>();
		
		weight[source] = 0;
		queue.add(source);
		while(queue.isEmpty() == false) {
			int node = queue.poll();
			for(int adj: graph.get(node)) {
				if(weight[node]+1 < weight[adj]) {
					weight[adj] = weight[node]+1;
					queue.add(adj);
				}
			}
		}
		for(int i=0; i<graph.size(); i++) {
			System.out.println("from "+ source + " to "+ i + " Shotest path is: "+ weight[i]);
		}
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
		System.out.println("Enter number of edges: ");
		int edges = sc.nextInt();
		System.out.println("Enter edges: ");
		for(int i=0; i<edges; i++) {
			addEdge(graph, sc.nextInt(), sc.nextInt());
		}
		System.out.println("Enter the source from you want find all node shortest path: ");
		shortestPathBFS(sc.nextInt(), graph);
		sc.close();
	}
	//unidirected graph
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int s, int d) {
		graph.get(s).add(d);
		graph.get(d).add(s);
	}

}
