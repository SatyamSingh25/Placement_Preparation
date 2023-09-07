package graph;
/**
 * @UnionFind
 * @Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable
 * @Leetcode_1579_Hard
 */
/* ---------------------1579 Remove Max Number of Edges to Keep Graph Fully Traversable--------------------------------
 * YT link: https://www.youtube.com/watch?v=Aosw8SRp7z4&ab_channel=AryanMittal
 * 
 * Description:
 * 
 * Alice and Bob have an undirected graph of n nodes and three types of edges:
 * 
 * Type 1: Can be traversed by Alice only.
 * Type 2: Can be traversed by Bob only.
 * Type 3: Can be traversed by both Alice and Bob.
 * 
 * Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi,
 * find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.
 * 
 * Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph
 *
 */
public class RemoveMaxEdges_graph_to_Graph_fullTraversable {
	
	public int maxNumEdgesToRemove(int n, int[][] edges) {
		UnionFind aliceGraph = new UnionFind(n);
		UnionFind bobGraph = new UnionFind(n);
		
		int removedEdges = 0;
		int aliceEdges = 0;
		int bobEdges = 0;
		
		//covering all the 3 type edge first because they have max priority
		for(int[] edge: edges) {
			if(edge[0] == 3) {
				if(aliceGraph.union(edge[1], edge[2])) {
					bobGraph.union(edge[1], edge[2]);
					aliceEdges++;
					bobEdges++;
				}
				else {
					removedEdges++;
				}
			}
		}
		
		//now covering the 2 and 1 type of edges
		for(int[] edge: edges) {
			if(edge[0] == 1) { //alice edge
				if(aliceGraph.union(edge[1], edge[2])) {
					aliceEdges++;
				}
				else {
					removedEdges++;
				}
			}
			else if(edge[0] == 2) { // Bob edge
				if(bobGraph.union(edge[1], edge[2])) {
					bobEdges++;
				}
				else {
					removedEdges++;
				}
			}
		}
		
		return aliceEdges == n-1 && bobEdges == n-1 ? removedEdges : -1;
	}

	
	class UnionFind{
		int size;
		int[] parent;
		
		UnionFind(int vertices){
			this.size = vertices;
			this.parent = new int[vertices+1]; //vertices + 1 because que has 1 based nodes
			
			for(int i=1; i<=vertices; i++)
				this.parent[i] = i;
		}
		
		//getting root parent of vertices 
		public int findParent(int vertices) {
			if(parent[vertices] != vertices)
				parent[vertices] = findParent(parent[vertices]);
			
			return parent[vertices];
		}
		
		//finding union can be possible or not
		public boolean union(int a, int b) {
			int rootA = findParent(a);
			int rootB = findParent(b);
			
			if(rootA != rootB) {
				parent[rootA] = rootB;
				size--;
				return true;
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		RemoveMaxEdges_graph_to_Graph_fullTraversable obj = new RemoveMaxEdges_graph_to_Graph_fullTraversable();
		
		int ans = obj.maxNumEdgesToRemove(4,new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}});
		System.out.println(ans); //2
		
		ans = obj.maxNumEdgesToRemove(4,new int[][]{{3,1,2},{3,2,3},{1,1,4},{2,1,4}});
		System.out.println(ans); // 0
		
		ans = obj.maxNumEdgesToRemove(4,new int[][]{{3,2,3},{1,1,2},{2,3,4}});
		System.out.println(ans); //-1
	}

}
