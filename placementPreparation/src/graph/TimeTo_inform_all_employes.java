package graph;
/**
 * @Leetcode_1376_Time_Needed_to_Inform_All_Employees
 * @BFS
 * @Medium
 * -----------------------------1376. Time Needed to Inform All Employees---------------------------------
 * A company has n employees with a unique ID for each employee from 0 to n - 1. 
   The head of the company is the one with headID.

   Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, 
   manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

   The head of the company wants to inform all the company employees of an urgent piece of news. 
   He will inform his direct subordinates, and they will inform their subordinates, 
   and so on until all employees know about the urgent news.

   The i-th employee needs informTime[i] minutes to inform all of his direct subordinates
   (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

   Return the number of minutes needed to inform all the employees about the urgent news.
   
                 (2)
                / /| \
               / / |  \               
              / /  |   \             
             1 3   4    5
             
  Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
  Result: 1
                                  
 * 
 */
import java.util.*;
public class TimeTo_inform_all_employes {
	
	//main method
	public static void main(String[] args) {
		int[] manager = new int[] {2,2,-1,2,2,2};
		int[] informTime = new int[] {0,0,1,0,0,0};
		
		//result 1
		System.out.println(numOfMinutes(6, 2, manager, informTime));
	}
	
	//BFS
    public static int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<>());
        
        for(int i=0; i<n; i++){
            if(manager[i]!=-1)
                graph.get(manager[i]).add(i);
        }
        
        Queue<int[]> queue = new LinkedList<>();       
        int totalMaxTimeTaken = 0;
        
        queue.offer(new int[]{headId, 0});
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            totalMaxTimeTaken = Math.max(totalMaxTimeTaken, curr[1]);
            
            for(int i: graph.get(curr[0])){
                queue.offer(new int[]{i, curr[1]+informTime[curr[0]]});
            }
            
        }
        //result
        return totalMaxTimeTaken;        
    }

}
