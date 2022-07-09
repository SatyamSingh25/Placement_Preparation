package dynamic_Programming;
/**
 * @Paint_House_1
 * @Paint_the_houses_but_Adjacent_house_Do_Not_Have_Same_Color
 * @DP
 * @N_Rooms_3_Colors
 */
import java.util.Arrays;
public class Paint_House_1 {
	//time: O(n)  Space: O(3n)
	public static int minCost_To_Paint_N_Rooms_with_3_Colors(int[][] colorsCost) {
		int rooms = colorsCost.length;
		
		int[] red = new int[rooms];
		int[] blue = new int[rooms];
		int[] green = new int[rooms];
		
		//paint 1st room with Red OR Blue OR GREEN
		red[0] = colorsCost[0][0]; 
		blue[0] = colorsCost[0][1];
		green[0] = colorsCost[0][2];
		
		for(int i=1; i<rooms; i++) {
			red[i] = Math.min(blue[i-1], green[i-1]) + colorsCost[i][0];
			blue[i] = Math.min(red[i-1], green[i-1]) + colorsCost[i][1];
			green[i] = Math.min(red[i-1], blue[i-1]) + colorsCost[i][2];
		}
		
		System.out.println("red[]: " + Arrays.toString(red)); //red[]: [1, 10, 8, 8]		
		System.out.println("blue[]: " + Arrays.toString(blue)); //blue[]: [5, 9, 7, 10]		
		System.out.println("green[]: " + Arrays.toString(green)); //green[]: [7, 5, 18, 11]
		
		//min(8, 10, 11)
		return Math.min(red[rooms-1], Math.min(blue[rooms-1], green[rooms-1]));
		
	}

	public static void main(String[] args) {
		int rooms = 4;
		//row = rooms
		//col = 3 three colors [Red, blue, green]
		int[][] colorsCost = new int[][] {{1, 5, 7},
			                              {5, 8, 4},
			                              {3, 2, 9},
			                              {1, 2, 4}};
		
	   System.out.println(minCost_To_Paint_N_Rooms_with_3_Colors(colorsCost));
			         
	}

}
