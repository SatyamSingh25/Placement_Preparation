package array;
/**
 * @author Satyam
 * Problem Statement: find the minimum number of platforms are needed form trains for which
 *                    we have arrivals and departure time.
 * Difficulty: Medium
 * TAG: Arrays || Greedy || interview oriented 
 */

import java.util.Arrays;
public class Minimum_Platform {
	
	public static int minPlatform(int[] arrivals, int[] departure, int n) {
		//sort arrivals and departure times of trains
		Arrays.sort(arrivals);
		Arrays.sort(departure);
		//Initially 1 platform is needed
		int platformsNeeded = 1, maxPlatformsUsed = 1;
		int i=1, j=0;
		//main logic
		while(i<n) {
			if(arrivals[i] > departure[j]) {
				platformsNeeded--;
				j++;
			}
			if(arrivals[i] <= departure[j]) {
				platformsNeeded++;
				i++;
			}
			//getting max
			maxPlatformsUsed = Math.max(maxPlatformsUsed, platformsNeeded); 
		}
		//answer
		return maxPlatformsUsed;
	}
	//Driver method
	public static void main(String[] args) {
		int[] arrivals = new int[] {900, 940, 950, 1100, 1500, 1800};
		int[] departure = new int[] {910, 1200, 1120, 1130, 1900, 2000};
		
		int minPlatformRequired  = minPlatform(arrivals, departure, arrivals.length);
		System.out.println(minPlatformRequired);
	}

}
