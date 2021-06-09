package array;
import java.util.*;
/**
 * @Contributed_by Satyam Singh
 * ----------------------------------LEETCODE 56-------------------------------------
 * Problem link : https://leetcode.com/problems/merge-intervals/
 * Discription : Given an array of intervals where intervals[i] = [starti, endi],
 *               merge all overlapping intervals, and return an array of the non-overlapping
 *               intervals that cover all the intervals in the input.
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
   Output: [[1,6],[8,10],[15,18]]
   Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
   
   Difficulty : Medium
 */

public class MergeIntervals {
	
	public int[][] merge(int[][] intervals) {
        //sorting the interval according to first element in the array
        Arrays.sort(intervals, (l1, l2)-> l1[0] - l2[0]);
        
        ArrayList<int[]> arr = new ArrayList<int[]>();
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        //merging
        for(int i=1; i<intervals.length; i++){
            int currStart  = intervals[i][0];
            int currEnd = intervals[i][1];
            
            if(currStart <= end){
                end = Math.max(currEnd, end);
            }
            else{
                arr.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            }
        }
        arr.add(new int[]{start, end});
                
        // int[][] res = new int[arr.size()][2];
        // for(int i=0; i<arr.size(); i++){
        //     res[i][0] = arr.get(i)[0];
        //     res[i][1] = arr.get(i)[1];
        // }
        
        //converting arrayList into 2D array in fast way
        return arr.toArray(new int[arr.size()][2]);
        
    }
}
