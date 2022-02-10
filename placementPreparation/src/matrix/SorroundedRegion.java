package matrix;

/**
 * @DFS_in_4_directions
 * @Matrix_Traversal
 * @Matrix
 * @Satyam_Singh
 */
import java.util.Arrays;
public class SorroundedRegion {
	//Method
	public static void sorroundedRegion(char[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		//0th row traversal
		for(int i=0; i<col; i++) {
			if(mat[0][i] == 'O') {
				dfs(mat, 0, i);
			}
		}
		//Nth column traversal
		for(int i=0; i<row; i++) {
			if(mat[i][col-1] == 'O') {
				dfs(mat, i, col-1);
			}
		}
		//1st column traversal
		for(int i=0; i<row; i++) {
			if(mat[i][0] == 'O') {
				dfs(mat, i, 0);
			}
		}
		//Nth row traversal
		for(int i=0; i<col; i++) {
			if(mat[row-1][i] == 'O') {
				dfs(mat, row-1, i);
			}
		}
		//converting all 'O' -> 'X'
		//               '#' -> 'O'
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(mat[i][j] == '#') {
					mat[i][j] = 'O';
				}
				else if(mat[i][j] == 'O') {
					mat[i][j] = 'X';
				}
			}
		}
	}

	//DFS traversal (recursive) in Four directions
	public static void dfs(char[][] mat, int i, int j) {
		if(i<0 || i>=mat.length || j<0 || j>=mat[0].length || mat[i][j] != 'O') {
			return;
		}
		mat[i][j] = '#';
		dfs(mat, i+1, j);
		dfs(mat, i-1, j);
		dfs(mat, i, j+1);
		dfs(mat, i, j-1);
	}

	//Driver code
	public static void main(String[] args) {
		char[][] mat = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		//method calling
		sorroundedRegion(mat);
		for(int i=0; i<mat.length; i++)
			System.out.println(Arrays.toString(mat[i]));
	}
	/* Output:-
	 *  [X, X, X, X]
		[X, X, X, X]
		[X, X, X, X]
		[X, O, X, X]
	 */

}
