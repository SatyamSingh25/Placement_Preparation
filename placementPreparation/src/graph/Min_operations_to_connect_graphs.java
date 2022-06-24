package graph;
/**
 * @Min_operations_to_Connect_graph_component
 * @Union_find_in_graph
 * @Graph
 * @Parent_find
 * @Leetcode_1319
 */
import java.util.*;
public class Min_operations_to_connect_graphs {

	public static void main(String[] args) {
		int[][] connections = new int[][] {{0,1},{0,2},{0,3},{1,2},{1,3}};
		//result -> 2
		System.out.println(makeConnected(6, connections));
	}
	
	//Number of Operations to Make Network Connected
	static int[] par;
    public static int findParent(int u){
        if(par[u] == u) return u;
        
        return par[u] = findParent(par[u]);
    }
    
    public static int makeConnected(int n, int[][] connections) {
        if(n-1 > connections.length)
            return -1;
        
        par = new int[n];
        for(int i=0; i<n; i++){
            par[i] = i;
        }
        
        for(int[] connection: connections){
            int source = connection[0];
            int destination = connection[1];
            
            int sourceParent = findParent(source);
            int desParent = findParent(destination);
            
            if(sourceParent != desParent){
                par[desParent] = sourceParent;
            }
        }
        
        int component = 0;
        for(int i=0; i<n; i++){
            int currParent = findParent(i);
            if(currParent == i){
                component++;
            }
        }
        return component-1;
    }
}
