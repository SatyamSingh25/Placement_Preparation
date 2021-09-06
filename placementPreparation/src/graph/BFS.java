package graph;
import java.util.*;
public class BFS {
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) {
		//Bi-Directional graph
		graph.get(source).add(destination);
		graph.get(destination).add(source);
	}
	public static void printGraph(ArrayList<ArrayList<Integer>> arr) {
		for(int i=0; i<arr.size(); i++) {
			System.out.print(i+" node:");
			for(int j=0; j<arr.get(i).size(); j++){
				System.out.print("->" + arr.get(i).get(j));
			}
			System.out.println();
		}
	}
	public static void bfs(ArrayList<ArrayList<Integer>> arr, int source) {
		//creating visited array to get to memorising that we visited this node or node
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
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int vertices = sc.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>(vertices);
		for(int i=0; i<vertices; i++) {
			arr.add(new ArrayList<Integer>());
		}
		//adding edges
		int edges = sc.nextInt();
		for(int i=0; i<edges; i++) {
			addEdge(arr, sc.nextInt(), sc.nextInt());
		}
		//breath first Search
		bfs(arr, 0);
		sc.close();
	}

}
