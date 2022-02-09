package backtrack_or_recursion;
import java.util.*;
public class rat_in_a_maze {
	
	public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] vis = new boolean[n][n];
        ArrayList<String> arr = new ArrayList<>();
        String str = "";
        dfs(m, 0,0, n, vis, arr, str);
        return arr;
    }
    
    public static void dfs(int[][] mat, int i, int j, int n, boolean[][] vis, ArrayList<String> arr, String str){
        if(i==n-1 && j==n-1){
            arr.add(str);
            return;
        }
        //down
        if(i+1 < n && vis[i+1][j] == false && mat[i+1][j] == 1 ){
            vis[i+1][j] = true;
            dfs(mat, i+1, j,n, vis, arr, str+"D");
            vis[i+1][j] = false;
        }
        //up
        if(i-1 >=0 && vis[i-1][j] ==  false && mat[i-1][j] == 1){
            vis[i-1][j] = true;
            dfs(mat, i-1, j,n, vis, arr, str+'U');
            vis[i-1][j] = false;
        }
        //left
        if(j-1 >= 0 && vis[i][j-1] == false && mat[i][j-1] == 1){
            vis[i][j-1] = true;
            dfs(mat, i, j-1,n, vis, arr, str+'L');
            vis[i][j-1] = false;
        }
        //right
        if(j+1 < n && vis[i][j+1] == false && mat[i][j+1] == 1){
            vis[i][j+1] = true;
            dfs(mat, i, j+1,n, vis, arr, str+'R');
            vis[i][j+1] = false;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
