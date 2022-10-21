package backtrack_or_recursion;

import java.util.Arrays;

public class Matchstics_Square {
	
	public static boolean makeSquare(int[] matchsticks) {
		int size = matchsticks.length;
		
		int totalSum = 0;
		for(int i: matchsticks)
			totalSum += i;
		
		if(totalSum % 4 != 0) return false;
		boolean[] visited = new boolean[size];
		Arrays.sort(matchsticks);
		
		int target = totalSum / 4;
		
		return subsetSum(0, 0, 4, target, visited, matchsticks, size);
	}
	
	public static boolean subsetSum(int start, int currSum, int k, int target, boolean[] visited, int[] matchsticks, int size) {
		if(k == 0) return true;
		
		if(currSum == target)
			return subsetSum(0, 0, k-1, target, visited, matchsticks, size);
		
		for(int i=start; i<size; i++) {
			if(visited[i] == false && currSum + matchsticks[i] <= target) {
				visited[i] = true;
				if(subsetSum(i, currSum + matchsticks[i], k, target, visited, matchsticks, size))
					return true;
				visited[i] = false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] matchsticks = new int[] {1,1,2,2,2};
		System.out.println(makeSquare(matchsticks)); // true
		
		matchsticks = new int[] {3,3,3,3,4};
		System.out.println(makeSquare(matchsticks)); //false
	}

}
