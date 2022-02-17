package array;
/**
 * @author Satyam
 * Problem statement: Given a boolean 2D array of n x m dimensions where "each row is sorted".
 *                    Find the 0-based index of the first row that has the maximum number of 1's.
 *                    
 * Input: 0, 1, 1, 1
          0, 0, 1, 1
          1, 1, 1, 1
          0, 0, 0, 0
   
   Output: 2nd row have max 1s 
 */
public class Max_1s_row_in_matrix {
	
	//Method O(n+m) time O(1) time
	public static int findMax_1s_row_matrix(int[][] arr) {
		int row = 0;
		
		int j=arr[0].length-1; //'j' at the last column
		while(j>=0 && arr[0][j] ==1) {
			j--;
		}
		
		for(int i=1; i<arr.length && j>=0; i++) {
			while(j>=0 && arr[i][j]==1) {
				j--;
				row = i;
			}
		}
		
		return row;
		
	}
	//method O(n^2)
	/* -->Iterate all rows anf find each row 1 count and return row which has max 1 in it
	 */
	
	public static void main(String[] args) {
		int[][] arr = new int[][] {{0, 1, 1, 1},
	           						{0, 0, 1, 1},
	           						{1, 1, 1, 1},
	           						{0, 0, 0, 0}};
		System.out.println(findMax_1s_row_matrix(arr)); //2nd row has max 1s
	}

}
