package graph;
/**
 * @graph
 * @Krushkal_algorithm
 * @MST_minimum_spannig_tree
 * @Leetcode_1489._Find_Critical_and_Pseudo_Critical_Edges_in_Minimum_Spanning_Tree(MST)
 * @HARD
 */
/*
 * 1489. Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree(MST)
 * 
 * -->find the critical and pseudo critical edges in MST of graph
 * 
 * critial edges = those edges in MST, when we not that edge while creating MST
 * 					it will increase the cost of MST[minimum spannng tree]
 * 
 * Pseudo Edges = Those edges in MST, if we not consider them while creating the MST
 * 					it will NOT affect the original min cost MST -cost. it will stay same.
 * 
 * Input: n = 5, 
 * 		edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
 * 
 * Output: [[0,1],[2,3,4,5]] 
 */
import java.util.*;
public class Find_Critical_N_Pseudo_Critical_edges_in_MST {
	
	public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int vertices, int[][] edges) {
		
		ArrayList<Integer> critical = new ArrayList<>();
		ArrayList<Integer> pseudo = new ArrayList<>();
		
		Map<int[], Integer> edgesIndexMap = new HashMap<>();
		for(int i=0; i<edges.length; i++) 
			edgesIndexMap.put(edges[i], i);
	
		//sorting edges accoring to edge weight
		Arrays.sort(edges, (a,b) -> a[2] - b[2]);
		
		//MST cost of initial graph which is with min cost.
		int MSTcost = MST(vertices, edges, null, null);
		
		for(int[] edge: edges) {
			int excludeEdgeMSTcost = MST(vertices, edges, null, edge);
			if(excludeEdgeMSTcost > MSTcost) {
				critical.add(edgesIndexMap.get(edge)); //caught critical edge adding it respective index 
			}
			else {
				int includeEdgeMSTcost = MST(vertices, edges, edge, null);
				if(includeEdgeMSTcost == MSTcost) {
					pseudo.add(edgesIndexMap.get(edge)); //caught pseudo-critical edge adding it respective index
				}
			}
		}
		
		return Arrays.asList(critical, pseudo);
	}
	
	public static int MST(int vertices, int[][] edges, int[] include, int[] exclude) {
		UnionFind uf = new UnionFind(vertices);
		int cost = 0;
		
		if(include != null) {
			uf.union(include[0], include[1]);
			cost += include[2];
		}
		
		for(int[] edge: edges) {
			if(exclude != edge && uf.union(edge[0], edge[1])) {
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
		
		int findParent(int vertices) {
			if(parent[vertices] == vertices)
				return vertices;
			
			return parent[vertices] = findParent(parent[vertices]);
		}
		boolean union(int x, int y) {
			int rootX = findParent(x);
			int rootY = findParent(y);
			
			if(rootX != rootY) {
				parent[rootX] = rootY;
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
									
		//result: [[0, 1], [2, 3, 4, 5]]
		//critical edges : [0, 1]
		//pseudo edges: [2, 3, 4, 5]
		System.out.println(findCriticalAndPseudoCriticalEdges(5, graph));
	}
}
