package greedy;
/**
 * @StriverSheet
 * @MinimumPlatform 
 * @Greedy
 * @Sorting_arrival_and_end_time
 * Problem : You are given the arrival times arr[] and departure times dep[] of all trains 
 *           that arrive at a railway station on the same day. 
 *           Your task is to determine the minimum number of platforms required at the station to ensure that no train is kept waiting.
 *           
 *           At any given time, the same platform cannot be used for both the arrival of one train and the departure of another
 *           Therefore, when two trains arrive at the same time, 
 *           or when one arrives before another departs, 
 *           additional platforms are required to accommodate both trains.
 *           
 *Input: arr[] = [900, 940, 950, 1100, 1500, 1800], 
 *       dep[] = [910, 1200, 1120, 1130, 1900, 2000]
 *Output: 3
 */
import java.util.*;
public class _2_MinimumPlatform {

	//Approach
	//TC : O(nlog(n)) + O(nlog(n)) + O(n) = O(nlog(n))
	//SC : O(n) + O(n) = O(2n)
	public static int minimumPlatform(int[] arrival, int[] departure) {
		//Why both sort : we only need arrival time and departure time as per the condition
		Arrays.sort(arrival);
		Arrays.sort(departure);
		
		int start = 1, end = 0;
		int maxPlatform = 1; //first train will occupy 1 platform
		int currInUsePlatform = 1;
		
		while(start < arrival.length && end < departure.length) {

			//currArrival time smaller the last train departure time for platform increase
			if(arrival[start] <=  departure[end]) { 
				currInUsePlatform++;
				maxPlatform = Math.max(maxPlatform, currInUsePlatform);
				start++;
			}
			else { // currArrival time grater then prev train departure time so we can use existing platform
				currInUsePlatform--;
				end++;
			}
		}
		
		return maxPlatform;
	}

	//Driver Code
	public static void main(String[] args) {
		System.out.println(
				minimumPlatform(new int[] {900, 940, 950, 1100, 1500, 1800},  //3 platform 
								new int[] {910, 1200, 1120, 1130, 1900, 2000}));
	}

}
