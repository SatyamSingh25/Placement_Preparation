package graph;
//cycle detection in graph using BFS
import java.util.*;
public class CycleDetectionUsingBFS {
	//pair for queue
	public static class Pair{
		int child, parent;
		Pair(){};
		Pair(int c, int p){
			this.child = c;
			this.parent = p;
		}
	}
	//cycle detection method helper or we can say that main BFS traversal for Cycle detection
	public static boolean cycleDetectAt(int source, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(source, -1));
		while(queue.isEmpty() == false) {
			Pair temp = queue.poll();
			int curr = temp.child;
			int parent = temp.parent;
			
			for(int i: graph.get(curr)) {
				if(visited[i] == false) {
					visited[i] = true;
					queue.add(new Pair(i, curr));
				}
				else {
					if(parent != i) {
						return true;
					}
				}
			}
		}
		return false; 
	}
	//cycle detection using BFS in Bidirectional graph
	public static boolean cycleDetectionUsingBFS(ArrayList<ArrayList<Integer>> graph) {
		boolean visited[] = new boolean[graph.size()];
		for(int i=0; i<graph.size(); i++) {
			if(visited[i] == false) {
				if(cycleDetectAt(i, graph, visited) == true) {
					return true;
				}
			}
		}
		return false;
	}
	//adding bidirectional graph 
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int s, int d) {
		graph.get(s).add(d);
		graph.get(d).add(s);
	}
	//main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of vertices: ");
		int vertices = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(vertices);
		for(int i=0; i<vertices ; i++) {
			graph.add(new ArrayList<Integer>());
		}
		System.out.println("Enter number of edges: ");
		int edges = sc.nextInt();
		for(int i = 0; i<edges; i++) {
			addEdge(graph, sc.nextInt(), sc.nextInt());
		}
		System.out.println("cycle detected: " + cycleDetectionUsingBFS(graph));
		
	}

}