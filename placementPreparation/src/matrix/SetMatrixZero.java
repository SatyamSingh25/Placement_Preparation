package matrix;
/**
 * @Set_matrix_row_and_column_zero_if_element_is_ZERO
 */
import java.util.*;
public class SetMatrixZero {
	static class Pair{
        int i, j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void setZeroes(int[][] matrix) {
    	
        Set<Pair> set = new HashSet<Pair>();
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
            	
                if(matrix[i][j] == 0){
                    set.add(new Pair(i, j));
                }                
            }
        }

        //Iterating over Set
        Iterator<Pair> pairs = set.iterator();
        while(pairs.hasNext()){
            Pair curr = (Pair) pairs.next();
            //row zero
            for(int i=0; i<matrix[0].length; i++){
                matrix[curr.i][i] = 0;
            }
            //column zero
            for(int i=0; i<matrix.length; i++){
                matrix[i][curr.j] = 0;
            }
        }
    }

	public static void main(String[] args) {
		int[][] arr = new int[][]  {{1,1,1,0,1,0},
									{1,1,1,1,1,1},
									{0,1,1,1,1,1}};
		setZeroes(arr);
		for(int i=0; i<3; i++) {
			for(int j=0; j<6; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
