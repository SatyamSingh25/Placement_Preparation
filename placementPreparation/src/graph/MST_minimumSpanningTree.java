package graph;
/**
 * @MST
 * @Minimum_Spanning_Tree
 * @Krushkal_Algorithm
 * @Bi_Directional_Weighted_Graph
 */
import java.util.*;
public class MST_minimumSpanningTree {
	
	public static void mst(int vertices, int[][] edges) {
		//sort the edges acc/to edge weight
		Arrays.sort(edges, (a,b) -> a[2] - b[2]);
		
		int MSTcost = minimumSpanningTree(vertices, edges);
		
		System.out.println("Cost of minimum Spanning Tree is: " + MSTcost); //7
	}
	
	public static int minimumSpanningTree(int vertices, int[][] edges) {
		UnionFind uf = new UnionFind(vertices);
		int cost = 0;
		
		for(int[] edge: edges) {
			if(uf.union(edge[0], edge[1])) {
				cost += edge[2];
			}
		}
		
		return uf.size == 1 ? cost : Integer.MAX_VALUE;
	}
	
	static class UnionFind{
		int size;
		int[] parent;
		
		UnionFind(int vertices){
			this.size = vertices;
			
			this.parent = new int[vertices];
			for(int i=0; i<vertices; i++)
				this.parent[i] = i;
		}
		
		//finding parent
		public int findParent(int vertices) {
			if(parent[vertices] == vertices)
				return vertices;
			int root = findParent(parent[vertices]);
			parent[vertices] = root;
			return root;
		}
		
		//union can be possible of two disjoin set or not
		public boolean union(int vertice1, int vertice2) {
			int root_1 = findParent(vertice1);
			int root_2 = findParent(vertice2);
			
			if(root_1 != root_2) {
				parent[root_1] = root_2;
				size--;
				return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] {{0,1,1},
									{1,2,1},
									{2,3,2},
									{0,3,2},
									{0,4,3},
									{3,4,3},
									{1,4,6}};
		mst(5, graph);	//Cost of minimum Spanning Tree is: 7
	}
}

