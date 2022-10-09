package dynamic_Programming;
/**
 * 1547. Minimum Cost to Cut a Stick
 * @Sort_The_cuts
 * @add_0_and_rodSize_in_cutArray
 * @TryWith_all_cut_initially -> that means all possible way with all the CUTS
 */
/* //Link: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 * -------------------------------------- 1547. Minimum Cost to Cut a Stick (HARD)-------------------
 * Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, 
 * a stick of length 6 is labelled as follows:
 * 
 * Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
 * You should perform the cuts in order, you can change the order of the cuts as you wish.
 * The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. 
 * When you cut a stick, it will be split into two smaller sticks 
 * (i.e. the sum of their lengths is the length of the stick before the cut). 
 * Please refer to the first example for a better explanation.
 * 
 * Return the minimum total cost of the cuts.
 * 
 * 	Input: n = 7, cuts = [1,3,4,5]
	Output: 16
	Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:

	The first cut is done to a rod of length 7 so the cost is 7. 
	The second cut is done to a rod of length 6 (i.e. the second part of the first cut), 
	the third is done to a rod of length 4 and the last cut is to a rod of length 3. 
	The total cost is 7 + 6 + 4 + 3 = 20.
	Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with total cost = 16 
	(as shown in the example photo 7 + 4 + 3 + 2 = 16).
 */
import java.util.Arrays;
public class MinCost_to_Cut {
	
	//time: O(n^3)
	//spcae: auxilary space
	//better Approach
	public static int minCostToCutRod_Memoization(int rod, int[] possibleCuts) {
		Arrays.sort(possibleCuts); //cuts has to sorted due to overlap after rod are divide

        int cutSize = possibleCuts.length;
        int[] cuts = new int[cutSize+2];

        for(int i=1; i<cuts.length-1; i++){
            cuts[i] = possibleCuts[i-1];
        }
        cuts[cuts.length-1] = rod;
        
        //trying to cut the rod initially with all cut
        int[][] dp = new int[possibleCuts.length+1][possibleCuts.length+1];
        for(int i=0; i<dp.length; i++)
            Arrays.fill(dp[i], -1);
        
        return solve_memo(1, cutSize, cuts, dp);
        
    }

    public static int solve_memo(int start, int end, int[] cuts, int[][] dp){
        //base case
    	if(start > end)
            return 0;
    	
        if(dp[start][end] != -1) //if this case already executed
        	return dp[start][end];
        
        int minCost = Integer.MAX_VALUE;
        
        //trying all cuts
        for(int i=start; i<=end; i++){
        	int currRodSize = cuts[end+1] - cuts[start-1];
            int cost = currRodSize + 
                            solve_memo(start, i-1, cuts, dp) + //first half after cut
                                solve_memo(i+1, end, cuts, dp); //end half afte cut
            minCost = Math.min(minCost, cost);
        }
        return dp[start][end] = minCost; //storing and returning cost
    }
	
	//Time: Exponential
	//Approach (Recursion)
	public static int minCostToCutRod(int rod, int[] possibleCuts) {
		Arrays.sort(possibleCuts);
		int[] cuts = new int[possibleCuts.length+2];
		
		for(int i=1; i<cuts.length-1; i++) {
			cuts[i] = possibleCuts[i-1];
		}
		cuts[cuts.length-1] = rod;                 // [0, [PossCuts], 7]
		System.out.println(Arrays.toString(cuts)); // [0, 1, 3, 4, 5, 7]
		
		return solve(1, possibleCuts.length, cuts); //trying to cut the rod initially with all cuts
	}
	//Solve recursion function
	public static int solve(int start, int end, int[] cuts) {
		//base case
		if(start > end) 
			return 0;
		
		int minCost = Integer.MAX_VALUE;
		
		//trying all cuts
		for(int i=start; i<=end; i++) {
			int currRodLength = cuts[end+1] - cuts[start-1]; //current rod length which is currentCost
			int cost = currRodLength + 
							solve(start, i-1, cuts) + //first half after cutting the current rod
							solve(i+1, end, cuts); //second half after cutting the current rod
			minCost = Math.min(minCost, cost);
		}
		return minCost;
	}

	//Driver Method
	public static void main(String[] args) {
		int[] possibleCuts = new int[] {3,1,5,4};
		int rodLength = 7;
		
		System.out.println(minCostToCutRod(rodLength, possibleCuts));
		System.out.println(minCostToCutRod_Memoization(rodLength, possibleCuts));
	}

}
