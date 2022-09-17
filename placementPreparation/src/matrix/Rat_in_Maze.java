package matrix;
/**
 * @Rate_In_a_Maze
 * @Source_toDestination_allPath[U(up), D(down), L(left), R(right)]
 */
import java.util.*;
public class Rat_in_Maze {

	static int row= 0 ;
	static int col = 0;
	//Approach
	public static ArrayList<String> allPathsforRats(int[][] mat){
		row = mat.length;
		col = mat[0].length;
		
		ArrayList<String> result = new ArrayList<>();
		String str = "";
		boolean[][] visited = new boolean[row][col];
		
		dfs(mat, 0, 0, str, result, visited);
		
		return result;
	}
	
	public static void dfs(int[][] mat, int i, int j, String currPath, ArrayList<String> result, boolean[][] visited) {
		if(i == row-1 && j == col-1) {
			result.add(currPath);
			return;
		}
		//Down
		if(i+1 < row && visited[i+1][j] == false && mat[i+1][j] == 1) {
			visited[i][j] = true; //marking current position as Visited
			dfs(mat, i+1, j, currPath+"D", result, visited);
			visited[i][j] = false;
			
		}
		//Up
		if(i-1 > 0 && visited[i-1][j] == false && mat[i-1][j] == 1) {
			visited[i][j] = true;
			dfs(mat, i-1, j, currPath+"U", result, visited);
			visited[i][j] = false;
		}
		//left
		if(j-1 > 0 && visited[i][j-1] == false && mat[i][j-1] == 1) {
			visited[i][j] = true;
			dfs(mat, i, j-1, currPath + "L", result, visited);
			visited[i][j] = false;
		}
		//right
		if(j+1 < col && visited[i][j+1] == false && mat[i][j+1] == 1) {
			visited[i][j] = true;
			dfs(mat, i, j+1, currPath+"R", result, visited);
			visited[i][j] = false;
		}
			
	}
	
	//Driver Method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] mat = new int[][] {{1, 0, 0, 0},
	         						{1, 1, 0, 1}, 
	         						{1, 1, 0, 0},
	         						{0, 1, 1, 1}};
		
		//all possible paths from (0,0) to (n-1, m-1)
		System.out.println(allPathsforRats(mat));
	}

}
