package graph;
/**
 * Problem : Given an undirected/unweighted graph, a source node, and a level L, 
 *           find the number of nodes that are exactly at level L from the source node
 *           
 *      0   Source : 0
       / \
      1   2
     /   / \
    3   4   5
 */
import java.util.*;
public class AtLevelVerticesCount {
	public static void addEdge(ArrayList<ArrayList<Integer>> arr, int i, int j) {
		arr.get(i).add(j);
		arr.get(j).add(i);
	}
	public static int atLevelVerticesCount(ArrayList<ArrayList<Integer>> arr, int level, int source) {
		//using BFS
		boolean[] visited = new boolean[arr.size()];
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] levelCount = new int[arr.size()];
		
		queue.offer(source);
		
		visited[source] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			Iterator<Integer> itr = arr.get(curr).listIterator();
			
			while(itr.hasNext()) {
				int now = itr.next();
				
				if(visited[now] == false) {
					visited[now] = true;
					queue.add(now);
					levelCount[now] = levelCount[curr]+1; //important line
				}
			}
		}
		int count = 0;
		for(int i=0; i<arr.size(); i++) {
			if(levelCount[i] == level) {
				count++;
			}
		}
		return count;
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
		int level = sc.nextInt();
		System.out.println(atLevelVerticesCount(arr, level, sc.nextInt()));
		sc.close();
	}
}
/*
Input----
6
5
0 1
0 2
1 3
2 4
2 5
2
0
Output----
3
*/
