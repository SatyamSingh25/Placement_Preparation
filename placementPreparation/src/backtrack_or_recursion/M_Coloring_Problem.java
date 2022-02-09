package backtrack_or_recursion;
import java.util.*;
public class M_Coloring_Problem {
	//checking a node that 'it is possible to color the current node with Target color or not'
	public static boolean isSafe(int currNode, List<Integer>[] G, int[] color, int targetColor) {
		for(int itr: G[currNode]) {
			if(color[itr] == targetColor) {
				return false;
			}
		}
		return true;
	}
	
	//can we color the current Node with possible color
	public static boolean canBeColor(int currNode, List<Integer>[] G, int[] color, int nodeCount, int numberOfColors) {
		//base condition
		if(currNode == nodeCount)
			return true;

		//iterate over all possible color to color the current node.
		for(int i=1; i<=numberOfColors; i++) {
			
			if(isSafe(currNode, G, color, i)) {
				//colored the current node with color 'i'
				color[currNode] = i;
				
				if(canBeColor(currNode+1, G, color, nodeCount, numberOfColors)) {
					return true;
				}
				//Backtacking 
				color[currNode] = 0;
			}
		}
		
		return false;
	}
	
	//coloring method
	//Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
	public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) {
		int nodeCount = G.length;
		
		if(canBeColor(0, G, color, nodeCount, m)) {
			return true;
		}
		return false;
	}
	
	//main method
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int V = scan.nextInt();
            int C = scan.nextInt();
            int E = scan.nextInt();

            List<Integer>[] G = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                G[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                G[u].add(v);
                G[v].add(u);
            }
            int[] color = new int[V];

            System.out.println(graphColoring(G, color, 0, C) ? "Possible to color with M color" : "Not possible to color with M colors");
        }
    }

}
