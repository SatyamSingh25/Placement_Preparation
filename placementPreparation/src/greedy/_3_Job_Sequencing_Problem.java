package greedy;
/**
 * @StriverSheet
 * @Job_Sequencing_Problem
 * @Greedy
 * @Sort_accordingTo_Profit
 * 
 * Problem : You are given a set of N jobs where each job comes with a deadline and profit. 
 *           The profit can only be earned upon completing the job within its deadline.
 *           Find the number of jobs done and the maximum profit that can be obtained.
 *           Each job takes a single unit of time and only one job can be performed at a time.
 * 
 * Input: N = 4, Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
 * Output: 2 60 
 * Explaination = [3, -1, -1, 1] = [30, 0, 0, 20] = 60 Total Profit, only 2 task.
 */
import java.util.*;
public class _3_Job_Sequencing_Problem {
	static class Task{
		int id, deadline, profit;
		
		Task(int id, int deadline, int profit){
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}
	
	//Approach
	//TC : O(nlog(n)) + (n * m)
	//TC : O(n)
	public static int[] jobSequenceForMaxProfit(Task[] tasks) {
		Arrays.sort(tasks, (a, b) -> b.profit - a.profit); //greedy
		int[] jobSequence = new int[tasks.length];
		
		Arrays.fill(jobSequence, -1); //-1 means we didn't perform task at that time
		
		int maxProfit = 0;
		
		for(Task task: tasks) {
			//try to take that profit at the end possible day
			int deadline = task.deadline-1; //index
			int id = task.id;
			int profit = task.profit;
			
			while(deadline >= 0 && jobSequence[deadline] != -1) 
				deadline--;
			
			if(deadline >= 0) {
				jobSequence[deadline] = id;
				maxProfit = maxProfit + profit;
			}
		}
		return jobSequence;		
	}

	//Driver code
	public static void main(String[] args) {
		Task task1 = new Task(1,4,20);
		Task task2 = new Task(2,1,10);
		Task task3 = new Task(3,1,40);
		Task task4 = new Task(4,1,30);
		System.out.println(Arrays.toString(jobSequenceForMaxProfit(new Task[] {task1, task2, task3, task4})));
	}

}
