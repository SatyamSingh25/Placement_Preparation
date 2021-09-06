package graph;
import java.util.*;
public class MotherVertex {
	public static void addEdge(ArrayList<ArrayList<Integer>> arr, int i, int j) {
		arr.get(i).add(j);
	}
	public static boolean findMotherVertex(ArrayList<ArrayList<Integer>> arr, int source, boolean[] visited ) {
		//applying applying BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[source] = true;
		queue.add(source);
		while(queue.isEmpty() != true) {
			int curr = queue.poll();
			Iterator<Integer> itr = arr.get(curr).iterator();
			while(itr.hasNext()) {
				int now = itr.next();
				if(!visited[now]) {
					visited[now] = true;
					queue.add(now);
				}
			}
		}
		int x = 0;
		while(x<visited.length) {
			if(visited[x++] == false) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>(vertices);
		for(int i=0; i<vertices; i++) {
			arr.add(new ArrayList<Integer>());
		}
		int edges = sc.nextInt();
		for(int i=0; i<edges; i++) {
			addEdge(arr, sc.nextInt(), sc.nextInt());
		}
		for(int i=0; i<vertices; i++) {
			boolean[] visited = new boolean[vertices];
			if(findMotherVertex(arr, i, visited)==true) {
				System.out.println(i);
				break;
			}
		}
	}

}
