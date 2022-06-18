package matrix;
/**
 * @Shortest_path_from_first_block_to_end_block
 * @BFS
 * @Binary_Matrix
 * @1_based_distance
 * @Leetcode_1091
 */
import java.util.*;
public class ShortestPath_Binary_mat_BFS {
	//main method
	public static void main(String[] args) {
		int[][] grid = new int[][] {{0,0,0},
			{1,1,0},
			{1,1,0}};
		//result -> 4
		System.out.println(shortestPathBinaryMatrix(grid));
		
	}

	//Approach method
	public static int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        if(row == 1 && col == 1 && grid[0][0] == 0) return 1; //Base
        
        if(grid[0][0] == 1) return -1; //Base
        
        //For BFS
        Queue<int[]> queue = new LinkedList<>();
        
        //8 Direction
        int[] drow = new int[]{1, 0, -1, 0, -1, -1, 1, 1};
        int[] dcol = new int[]{0, 1, 0, -1, -1, 1, -1, 1};
        
        int maxDistance = -1; //initially distance
        queue.offer(new int[]{0, 0}); //added first 0 Block
        
        boolean isLastBlock = false; //flag for checking the at last block or not
        
        while(!queue.isEmpty()){
            maxDistance++;
            int size = queue.size();
            
            //iterating over current level
            for(int p=0; p<size; p++){
                int[] pair = queue.poll();
                int i = pair[0];
                int j = pair[1];
                
                for(int ind=0; ind<8; ind++){ //visiting all 8 directions iteratively
                    int adj_x = i + drow[ind];
                    int adj_y = j + dcol[ind];
                     
                    if(isValid(adj_x, adj_y, grid) && grid[adj_x][adj_y] !=1){
                        
                        grid[adj_x][adj_y] = 1; // after visiting (i,j) make it 1 for visited consideration
                        queue.offer(new int[]{adj_x, adj_y});
                        
                        if(adj_x == row-1 && adj_y == col-1) //reached at last (row-1, col-1)
                            isLastBlock = true;
                    }
                    if(isLastBlock) return maxDistance+2;
                }
            }
        }
        return -1;
    }
	
	//Validation check for (i,j) in grid
    public static boolean isValid(int i, int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 1)
            return false;
        
        return grid[i][j] == 0;
    }

}
