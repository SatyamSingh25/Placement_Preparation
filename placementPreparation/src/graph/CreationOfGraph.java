package graph;
import java.util.*;
public class CreationOfGraph {
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) {
		graph.get(source).add(destination);
		graph.get(destination).add(source);
	}
	public static void printGraph(ArrayList<ArrayList<Integer>> graph) {
		for(int i=0; i<graph.size(); i++) {
			System.out.print(i + ":");
			for(int j=0; j<graph.get(i).size(); j++) {
				System.out.print("->" + graph.get(i).get(j));
			}
			System.out.println();
		}
	}
	public static void bfs(ArrayList<ArrayList<Integer>> arr, int source) {
		boolean[] visited = new boolean[arr.size()];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[source] = true;
		queue.add(source);
		
		while(queue.isEmpty()==false){
			source = queue.poll();
			System.out.print(source+ " ");
			Iterator<Integer> itr = arr.get(source).listIterator();
			while(itr.hasNext()) {
				int curr = itr.next();
				if(!visited[curr]) {
					visited[curr] = true;
					queue.add(curr);
				}
			}					
		}		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertices);
		for(int i=0; i<vertices; i++){
				graph.add(new ArrayList<Integer>());
		}
		
		int edges = sc.nextInt();
		for(int i=0; i<edges; i++) {
			addEdge(graph, sc.nextInt(), sc.nextInt());
		}
		printGraph(graph);
		bfs(graph, 0);
		sc.close();
		/*
		 5
		 6
		 0 1
		 0 4
		 1 2
		 1 3
		 1 4
		 2 3
		 3 4
		 BFS = 
		 */
	}
}
