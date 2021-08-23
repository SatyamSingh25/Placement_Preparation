package graph;
import java.util.*;
public class CreateGraphAndPrintIt {

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int destination) {
		adj.get(source).add(destination);
		adj.get(destination).add(source);
	}
	public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for(int i=0; i<adj.size(); i++) {
			System.out.print(i);
			for(int j=0; j<adj.get(i).size(); j++) {
				System.out.print("->" + adj.get(i).get(j));
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertex: ");
		int v = sc.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
		
		//adding 'v' vertex as list...
		for(int i=0; i<v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		//adding an edges
		addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        
        printGraph(adj);
        sc.close();
		
	}

}
