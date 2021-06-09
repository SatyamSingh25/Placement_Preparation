package array;
import java.util.*;
/**
 * @contributed_by Satyam Singh
 * -----------------------------LEETCODE 57---------------------------------------------
 * Problem link : https://leetcode.com/problems/insert-interval/
 * Diccription : Given a set of non-overlapping intervals, insert a new interval into the intervals
 *               (merge if necessary).
                 You may assume that the intervals were initially sorted according to their start times. 
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
   Output: [[1,5],[6,9]]
   
   Difficulty : Medium
 */
public class Insert_intervals {
	public int[][] insert(int[][] intervals, int[] newInterval) {
        //base case
        if(intervals.length ==0){
            return new int[][]{newInterval};
        }
        
        ArrayList<int[]> arr = new ArrayList<int[]>();
        
        int size = intervals.length; //intervals length
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        
        //inserting
        int i=0 ;
        while(i<size && intervals[i][1]<newStart){
            arr.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        } 
        
        //merging
        while(i<size && intervals[i][0] <= newEnd){
            newStart = Math.min(intervals[i][0], newStart);
            newEnd = Math.max(intervals[i][1], newEnd);
            i++;
        }
        arr.add(new int[]{newStart, newEnd});
        
        //inserting remaning 
        while(i<size){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            arr.add(new int[]{currStart, currEnd});
            i++;
        }
        
        //converting into 2D array        
        return arr.toArray(new int[arr.size()][2]);
    }
}
