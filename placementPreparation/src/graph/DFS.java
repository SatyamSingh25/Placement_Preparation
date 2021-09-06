package graph;
import java.util.*;
public class DFS {
	public static void addEdge(ArrayList<ArrayList<Integer>> arr, int source, int destination) {
		arr.get(source).add(destination);
		arr.get(destination).add(source);
	}
	public static void  DFSUtil(ArrayList<ArrayList<Integer>> arr, boolean[] visited, int source) {
		visited[source] = true;
		System.out.print(source + " ");
		
		Iterator<Integer> itr = arr.get(source).listIterator();
		while(itr.hasNext()){
			int curr = itr.next();
			if(!visited[curr]) {
				DFSUtil(arr, visited, curr);
			}
		}
	}
	public static void DFS(ArrayList<ArrayList<Integer>> arr, int source) {
		boolean[] visited = new boolean[arr.size()];
		
		DFSUtil(arr, visited, source);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of edges: ");
		int vertices = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>(vertices);
		for(int i=0; i<vertices; i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		System.out.println("enter the number of edges: ");
		int edges = sc.nextInt();
		for(int i=0; i<edges; i++) {
			addEdge(arr, sc.nextInt(), sc.nextInt());
		}
		
		System.out.println("Enter the start point where to start traversing: ");
		DFS(arr, sc.nextInt());
		sc.close();
	}

}
