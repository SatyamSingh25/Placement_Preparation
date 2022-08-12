package binary_Tree;
import java.util.*;

public class Time_Needed_To_Inform_All_Employee {

	public static int MiniumTimeTo_Inform_to_All_employee(int n, int headId, int[] managers, int[] informTime) {
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<n; i++)
			graph.add(new ArrayList<>());
		
		for(int i=0; i<managers.length; i++) {
			if(managers[i] != -1) //not add
				graph.get(managers[i]).add(i); //employees of a particular manager
		}
		//int[] {index, time taken};
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {headId, 0}); //inserted main head of the company who has a information or Announcmant
		int totalTimeTaken = 0;
		
		while(queue.isEmpty()==false) {
			int[] curr = queue.poll();
			
			totalTimeTaken = Math.max(totalTimeTaken, curr[1]);
			
			//iterating over those empoyees whose comes under the current employee
			for(int i: graph.get(curr[0])) { 
				queue.offer(new int[] {i, curr[1] + informTime[curr[0]]});
			}
		}
		
		return totalTimeTaken; //result
		
	}
	
	public static void main(String[] args) {
		int[] managers = new int[] {1,2,3,4,5,6,-1};
		int[] informTime = new int[] {0,6,5,4,3,2,1};
		
		System.out.println(MiniumTimeTo_Inform_to_All_employee(7,6,managers, informTime));
	}

}
