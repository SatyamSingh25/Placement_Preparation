package graph;
/**
 * @GFG
 * @BFS_in_Matrix
 * source to destination in mat with wall and black space
 */
//https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/0/?track=amazon-graphs&batchId=192#
import java.util.*;
public class SourceToDestinationWithObsticals {
	static class Pair{
        int i, j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
	
    public static boolean isFind(int i, int j, int[][] grid, int row, int col){
        int[] dRow = new int[]{-1,0,1,0};
        int[] dCol = new int[]{0,1,0,-1};
        
        boolean[][] visited = new boolean[row][col];
        Queue<Pair> queue = new LinkedList<>();
        
        visited[i][j] = true;
        queue.offer(new Pair(i, j));
        
        while(queue.isEmpty() == false){
            Pair curr = queue.poll();
            int x = curr.i;
            int y = curr.j;
            
            for(int t=0; t<4; t++){
            	
                int adjX = x + dRow[t];
                int adjY = y + dCol[t];
                
                if(adjX<0 || adjX>=row || adjY<0 || adjY>=col || grid[adjX][adjY] == 0)
                    continue;
                
                if(grid[adjX][adjY] == 2)
                    return true;
                
                if(visited[adjX][adjY] == false) {
                	queue.offer(new Pair(adjX, adjY));
                	visited[adjX][adjY] = true;
                }
            }
        }
        return false;
    }
    
    public static boolean is_Possible(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    if(isFind(i, j, grid, row, col)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(is_Possible(arr));
		sc.close();
	}

}
