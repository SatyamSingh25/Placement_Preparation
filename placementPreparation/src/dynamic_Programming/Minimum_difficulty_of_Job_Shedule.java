package dynamic_Programming;
/**
 * @author Satyam
 * @DFS
 * @hard
 * @DP
 * @Important
 */
/*
 * --------------------------------1335. Minimum Difficulty of a Job Schedule-----------------------------------------
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, 
 * you have to finish all the jobs j where 0 <= j < i).
 * 
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days.
 * The difficulty of a day is the maximum difficulty of a job done on that day.
 * 
 * You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
 * 
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 */
import java.util.*;
public class Minimum_difficulty_of_Job_Shedule {
	
	public static int minDifficultyjobShedule(int[] jobDifficulty, int days) {
		int size = jobDifficulty.length;
		
		if(size < days) //jobDifficulty=[3,4,5],  days=4
			return -1;
		
		int[][] dp = new int[size][days+1];
		for(int[] arr: dp)
			Arrays.fill(arr, -1);
		
		return dfs(0, days, jobDifficulty, size, dp);
	}
	
	public static int dfs(int start, int leftDays, int[] jobDifficulty, int size, int[][] dp) {
		//base case
		if(leftDays == 1) { //only 1 day is left so max from start to end would be the answer
			int max = Integer.MIN_VALUE;
			for(int i=start; i<size; i++) {
				max = Math.max(max, jobDifficulty[i]);
			}
			return max;
		}
		
		if(dp[start][leftDays] != -1)
			return dp[start][leftDays];
		
		int currDaysMaxDiff = Integer.MIN_VALUE;
		int result = Integer.MAX_VALUE;
		
		//size - leftDays + 1 -> left some end leftdays jobs because in next leftDays atleat 1 job has to done
		for(int i=start; i<size-leftDays+1; i++) { 
			currDaysMaxDiff = Math.max(currDaysMaxDiff, jobDifficulty[i]);
			result = Math.min(result, currDaysMaxDiff  + dfs(i+1, leftDays-1, jobDifficulty, size, dp));
		}
		return dp[start][leftDays] = result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {6,5,4,3,2,1};
		System.out.println(minDifficultyjobShedule(arr, 2));//result 7
		
		arr = new int[] {1,1,1};
		System.out.println(minDifficultyjobShedule(arr, 3)); //result 3
		
		arr = new int[] {1,1,1};
		System.out.println(minDifficultyjobShedule(arr, 4)); //result -1
	}

}
