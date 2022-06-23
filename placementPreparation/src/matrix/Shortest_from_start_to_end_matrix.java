package matrix;
/**
 * @8_Directions
 * @BFS
 * @Shortest_Distance
 * @Matrix
 */
import java.util.*;
public class Shortest_from_start_to_end_matrix {
	//main method
    public static void main(String[] args){
        int[][] grid = new int[][]{{0,0,0},
                                    {1,1,0},
                                    {1,1,0}};
        //result -> 4
        System.out.println(shortestPathBinaryMatrix(grid));
    }
    
    //shortest path from [0,0] to [n,m] 8 Directions
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if(row == 1 && col == 1 && grid[0][0] == 0) return 1;

        Queue<int[]> queue = new LinkedList<>();

        if(grid[0][0] == 1) return -1;

        //8 Direction
        int[] drow = new int[]{1, 0, -1, 0, -1, -1, 1, 1};
        int[] dcol = new int[]{0, 1, 0, -1, -1, 1, -1, 1};

        int maxDistance = -1;
        queue.offer(new int[]{0, 0});

        boolean isLastBlock = false;

        while(!queue.isEmpty()){
            maxDistance++;
            int size = queue.size();

            for(int p=0; p<size; p++){
                int[] pair = queue.poll();
                int i = pair[0];
                int j = pair[1];

                for(int ind=0; ind<8; ind++){
                    int adj_x = i + drow[ind];
                    int adj_y = j + dcol[ind];

                    if(isValid(adj_x, adj_y, grid) && grid[adj_x][adj_y] !=1){

                        grid[adj_x][adj_y] = 1;
                        queue.offer(new int[]{adj_x, adj_y});

                        if(adj_x == row-1 && adj_y == col-1)
                            isLastBlock = true;
                    }
                    if(isLastBlock)
                        return maxDistance+2;
                }
            }
        }
        return -1;
    }
    
    public static boolean isValid(int i, int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 1)
            return false;

        return grid[i][j] == 0;
    }
}
