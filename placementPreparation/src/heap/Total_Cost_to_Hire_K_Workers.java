package heap;
import java.util.*;
/**
 * @Min HEAP WITH CONDITION
 * @TOTAL_COST_TO_HIRE
 */
/*-----------------------------------2462. Total Cost to Hire K Workers---------------------------
 * You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.

   You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:

	*You will run k sessions and hire exactly one worker in each session.
    *In each hiring session, choose the worker with the lowest cost 
     from either the first candidates workers or the last candidates workers. 
     Break the tie by the smallest index.
     
    *For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, 
     we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
     In the second hiring session, we will choose 1st worker 
     because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. 
     Please note that the indexing may be changed in the process.
     If there are fewer than candidates workers remaining, 
     choose the worker with the lowest cost among them. Break the tie by the smallest index.
    
    *A worker can only be chosen once.
 * 
 *  Return the total cost to hire exactly k workers.
 */
public class Total_Cost_to_Hire_K_Workers {

	//time: O(n) + O(nlog(n)) -> mlogn is for entering into Priority queue
	//Spcae : O(n) (PQ space)
	public static long totalCost(int[] cost, int k, int candidates) {	
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
			if(a.cost != b.cost)           //MIN-HEAP according to cost
				return a.cost - b.cost;
			return a.index - b.index; //if cost is same then according to its index
		});
		
		int i = 0, j = cost.length-1;
		if(i == j) //if only 1 candidate is selected
			return cost[0];
		
		//adding from Start and from the End first required Candidates
		while(i<j && candidates-- > 0) {
			pq.offer(new Pair(cost[i], i++));
			pq.offer(new Pair(cost[j], j--));
		}
		
		long totalCost = 0l;
		while(i<=j && k-- > 0) {
			Pair curr = pq.poll();
			totalCost += curr.cost; //current min cost guy to hire so add it to the cost
			if(curr.index < i) {
				pq.offer(new Pair(cost[i], i)); //if selected guy is from for first k candidates remaining one
				i++;
			}
			else {
				pq.offer(new Pair(cost[j], j)); //if selected guy is from the last candidates remaining one
				j--;
			}
		}
		
		//if I and J are cross that means all candidates are in added in the PriorityQueue
		while(k-- > 0 && pq.isEmpty() == false) {
			totalCost += pq.poll().cost;
		}
		
		return totalCost;
	}
	
	static class Pair{
		int cost, index;
		Pair(){};
		Pair(int cost, int index){
			this.cost = cost;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] {17,12,10,2,7,2,11,20,8};
		System.out.println(totalCost(arr, 3, 4)); //result = 11
		
		arr = new int[] {1,2,4,1};
		System.out.println(totalCost(arr, 3, 3)); //RESULT = 4

	}

}
