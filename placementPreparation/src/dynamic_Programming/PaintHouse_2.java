package dynamic_Programming;
/**
 * @Paint_House_2
 * @Paint_houses_With_Many_Colors
 * @Fist_min_Second_Min_of_Previous_row
 */
/**
 * --------------------------------Paint Houses with Many Colors in Minimum Cost--------------------------------
 * 
 */
import java.util.*;
public class PaintHouse_2 {
	
	//time: O(n^2)
	public static int PaintHouse_with_ManyColors_with_Min_cost(int[][] colorsCost, int rooms) {
		int row = rooms; //colorsCost
		int colors = colorsCost[0].length; //total number of colors
		
		int[][] dp = new int[rooms][colors];
		
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		
		for(int i=0; i<colors; i++) {
			if(firstMin < colorsCost[0][i]) {
				secondMin = firstMin;
				firstMin = colorsCost[0][i];
			}
			else if(secondMin < colorsCost[0][i]) {
				secondMin = colorsCost[0][i];
			}
			dp[0][i] = colorsCost[0][i];
		}
		
		for(int i=1; i<rooms; i++) {
			int innerFirstMin = Integer.MAX_VALUE;
			int innerSecondMin = Integer.MAX_VALUE;
			
			for(int j=0; j<colors; j++) {
				if(colorsCost[i-1][j] == firstMin) {
					dp[i][j] = secondMin + colorsCost[i][j];
				}
				else {
					dp[i][j] = firstMin + colorsCost[i][j];					
				}
				
				if(innerFirstMin < dp[i][j]) {
					innerSecondMin = innerFirstMin;
					innerFirstMin = dp[i][j];
				}
				else if(innerSecondMin < dp[i][j]) {
					innerSecondMin = dp[i][j];
				}
			}
			firstMin = innerFirstMin;
			secondMin = innerSecondMin;
		}
		
		return firstMin;
	}

	public static void main(String[] args) {
		
	}

}
