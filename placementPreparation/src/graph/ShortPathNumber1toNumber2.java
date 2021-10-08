package graph;
import java.util.*;
public class ShortPathNumber1toNumber2 {
	/* Shortest path to reach one prime to other by changing single digit at a time
	 * gfg : https://www.geeksforgeeks.org/shortest-path-reach-one-prime-changing-single-digit-time/
	 * Difficulty : Hard
	 */
	public static ArrayList<Integer> SeiveOfEratosthenes(){
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		boolean[] prime = new boolean[10000];
		Arrays.fill(prime, true);
		for(int i=2; i*i<10000; i++) {
			if(prime[i]) {
				for(int j=i*i; j<10000; j+=i)
					prime[i] = false;
			}
		}
		for(int i=2; i<10000; i++){
			if(prime[i])
				primeNumbers.add(i);
		}
		return primeNumbers;
	}
	public static boolean compare(int num1, int num2) {
		String str1 = num1+"";
		String str2 = num2+"";
		int count = 0;
		if(str1.charAt(0) != str2.charAt(0))
			count++;
		if(str1.charAt(1) != str2.charAt(1))
			count++;
		if(str1.charAt(2) != str2.charAt(2))
			count++;
		if(str1.charAt(2) != str2.charAt(3))
			count++;
		
		return count==1;
	}
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) {
		graph.get(source).add(destination);
		graph.get(destination).add(source);
	}
	public static int bfs(ArrayList<ArrayList<Integer>> graph, int start, int end) {
		Integer[] visited = new Integer[graph.size()];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = 1;
		queue.add(start);
		boolean flag = true;
		int res =0;
		while(!queue.isEmpty()) {
			int temp = 	queue.poll();
			Iterator<Integer>  itr = graph.get(temp).listIterator();
			while(itr.hasNext()) {
				int curr = itr.next();
				if(visited[curr] != null) {
					visited[curr] = visited[temp] + 1;
					queue.add(curr);
				}
				if(curr == end) {
					res =  visited[curr]-1;
					flag = false;
					break;
				}
			}
			if(flag == false)
				break;
		}
		return res;
	}
	public static int shortestPath(int num1, int num2) {
		ArrayList<Integer> primes = SeiveOfEratosthenes();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<primes.size(); i++)
			graph.add(new ArrayList<Integer>());
		for(int i=0; i<primes.size(); i++) {
			for(int j=i+1; j<primes.size(); j++) {
				if(compare(primes.get(i), primes.get(j))) {
					addEdge(graph, i, j);
				}
			}
		}
		int in1=0, in2=0;
		for (int j = 0; j < primes.size(); j++) 
	        if (primes.get(j) == num1)
	            in1 = j; 
	    for (int j = 0; j < primes.size(); j++) 
	        if (primes.get(j) == num2)
	            in2 = j;
	    return bfs(graph, in1, in2);
	}	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.println(shortestPath(num1, num2));
		sc.close();
	}

}
