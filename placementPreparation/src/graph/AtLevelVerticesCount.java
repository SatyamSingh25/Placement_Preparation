package graph;

import java.util.*;

public class AtLevelVerticesCount {
	public static void addEdge(ArrayList<ArrayList<Integer>> arr, int i, int j) {
		arr.get(i).add(j);
		arr.get(j).add(i);
	}
	public static int atLevelVerticesCount(ArrayList<ArrayList<Integer>> arr, int level, int source) {
		//using BFS
		boolean[] visited = new boolean[arr.size()];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] levelCount = new int[arr.size()];
		
		queue.offer(0);
		
		visited[0] = true;
		
		while(queue.isEmpty() != true) {
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
Output----
3
*/
