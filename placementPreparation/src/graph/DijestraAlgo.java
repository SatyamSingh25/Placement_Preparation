package graph;
/**
 * @Dijkstra_Algorithm_Shortest_Path
 */
//Dijkstra shortest path using BFS 
import java.util.*;
public class DijestraAlgo {
	//BFS using in Dijkstra's algorithm
	public static void DijkstraAlgo(int source,int vertices, ArrayList<ArrayList<Pair>> graph) {
		int dist[] = new int[vertices];
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(vertices, new Pair());
		
		Arrays.fill(dist, Integer.MAX_VALUE); //setting all dist as Infinite because we haven't get anyone them till now
		
		dist[source] = 0;
		queue.add(new Pair(source, 0));
		
		while(queue.size() > 0) {
			
			Pair curr = queue.poll();
			
			for(Pair i: graph.get(curr.node)) {
				
				if(dist[curr.node]+i.weight < dist[i.node]) {
					dist[i.node] = dist[curr.node]+i.weight;
					queue.add(new Pair(i.node, dist[i.node]));
				}
			}
		}
		
		for(int i=0; i<vertices; i++)
			System.out.println(source + " to " + i + " : " + dist[i]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices: ");
		int vertices = sc.nextInt();
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		for(int i=0; i<vertices; i++) {
			graph.add(new ArrayList<Pair>());
		}
		
		System.out.println("Enter number of edges: ");
		int edges = sc.nextInt();
		
		System.out.println("Enter edges: ");
		for(int i=0; i<edges; i++) {
			int ss = sc.nextInt();
			int node = sc.nextInt();
			int we = sc.nextInt();
			graph.get(ss).add(new Pair(node, we));
		}
		//calling Dijkstra 
		System.out.println("Enter the Source: ");
		DijkstraAlgo(sc.nextInt(), vertices, graph);
		sc.close();
	}
	
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Pair2>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            ArrayList<Integer> innerList = new ArrayList<>();
            innerList.add(null);
            graph.get(edges[i][0]).add(new Pair2(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Pair2(edges[i][0], succProb[i]));
        }

        //min according to weight
        PriorityQueue<Pair2> pq = new PriorityQueue<>((a,b)->Double.compare(a.weight, b.weight)); 
        pq.add(new Pair2(start,1.0)); //1.0 is because we multiplying not adding prev value

        double[] maxProb = new double[n];
        Arrays.fill(maxProb, Integer.MAX_VALUE);
        maxProb[start] = 0;

        while(pq.isEmpty()==false){
            Pair2 currNode = pq.poll();
            if(currNode.node == end)
                return currNode.weight;
            
            for(Pair2 itr: graph.get(currNode.node)){
                if((itr.weight *currNode.weight) < maxProb[itr.node]){
                    maxProb[itr.node] = (itr.node * currNode.weight);
                    pq.add(new Pair2(itr.node, maxProb[itr.node]));
                }
            }
        }
        return maxProb[end];
    }
	class Pair2 {
        double weight;
        int node;
        Pair2(){
            this.weight = 0.0;
            this.node = 0;
        }
        Pair2(int node, double weight){
            this.node = node;
            this.weight = weight;
        }
    }
	static class Pair implements Comparator<Pair>
	{
	    int node;
	    int weight;
	    
	    Pair(int v, int succProb) { 
	    	node = v; 
	    	weight = succProb;
	    }	    
	    Pair(){}	    
	    @Override
	    public int compare(Pair node1, Pair node2) 
	    { 
	        if (node1.weight < node2.weight) 
	            return -1; 
	        if (node1.weight > node2.weight) 
	            return 1; 
	        return 0; 
	    } 
	}
}
