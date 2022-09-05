package islands;
/**
 * @Count_Perimeter_of_island
 * @BoundryWalls_of_isLands
 */
import java.util.*;
public class PerimeterOfIsland {
	
	public static int countPerimeter(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		int perimeter = 0;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(arr[i][j] == 1) {
					perimeter += 4;
					if(i>0 && arr[i-1][j] == 1) {
						perimeter -= 2;
					}
					if(j>0 && arr[i][j-1] == 1) {
						perimeter -= 2;
					}
				}
			}
		}
		return perimeter;
	}

	public static void main(String[] args) {
		int[][] mat = new int[][] {{0,1,0,0},
			                       {1,1,1,0},
			                       {0,1,0,0},
			                       {1,1,0,0}};
			                       
		System.out.println(countPerimeter(mat));
	}

}
