package matrix;
/**
 * @DFS_in_Matrix
 * @Count_zeros
 * @Total_valid_Paths_using_DFS
 * @Start_and_End_coordinates_given
 * @Obstacle_While_traversing
 * 
 * @author Satyam Singh
 */
public class UniquePaths_3 {
	//Method
	public static int uniquePath_3(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		
		int zero = 0, sx = 0, sy = 0;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(grid[i][j] == 0) {
					zero++;
				}
				if(grid[i][j] == 1) {
					sx = i;
					sy = j;
				}
			}
		}
		
		return dfs(grid, sx, sy, zero);
	}

	//DFS traversal in matrix
	public static int dfs(int[][] grid, int i, int j, int zero) {
		if(i<0 || i>=grid.length ||  j<0 || j>=grid[0].length || grid[i][j] == -1) {
			return 0;
		}
		
		if(grid[i][j] == 2) {
			if(zero == -1) {
				return 1;
			}
			return 0;
		}
		
		grid[i][j] = -1;
		zero--;;
		
		int totalPaths = dfs(grid, i+1, j, zero) +
							dfs(grid, i-1, j, zero) +
							dfs(grid, i, j+1, zero) +
							dfs(grid, i, j-1, zero) ;
		grid[i][j] = 0;
		zero++;
		
		return totalPaths;
	}
	
	//Driver Code
	public static void main(String[] args) {
		int[][] grid = new int [][] {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
		System.out.println(uniquePath_3(grid));
	}

}
