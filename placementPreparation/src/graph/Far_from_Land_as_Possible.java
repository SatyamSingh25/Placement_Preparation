package graph;
/**
 * @Leetcode_1162
 * @Fathest_0_from_1
 * @BFS
 * Problem: Given an n x n grid containing only values 0 and 1, 
 *          where 0 represents water and 1 represents land,
 *          find a water cell such that its distance to the nearest land cell is maximized, and return the distance. 
 *          If no land or water exists in the grid, return -1.
 *          
 * The distance used in this problem is the Manhattan distance: 
 *    the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 *  
 * input:-
 * {1,0,1}            {1,0,0}                 
 * {0,0,0}            {0,0,0}
 * {1,0,1}            {0,0,0}
 * 
 * Output : 2      O/P: 4  The cell (2, 2) is as far as possible from all the land with distance 4.
 * The cell (1, 1) is as far as possible from all the land with distance 2. * 
 */
import java.util.*;
public class Far_from_Land_as_Possible {

	//Main method
    public static void main(String[] args){
        int[][] grid = new int[][]{{1,0,1},
        							{0,0,0},
        							{1,0,1}};
        //result -> 2
        System.out.println(maxDistance(grid));
        

        int[][] grid2 = new int[][]{{1,0,0},
									{0,0,0},
									{0,0,0}};
        //reuslt -> 4
        System.out.println(maxDistance(grid2));
    }
    
    	
    public static int maxDistance(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    queue.add(new int[]{i,j});
                    visited.add(i + "|" + j);
                }
            }
        }

        int maxDistance = -1;

        int[] drow = new int[]{1, 0, -1, 0};
        int[] dcol = new int[]{0, 1, 0, -1};
        
        while(!queue.isEmpty()){
            maxDistance++;
            int size =queue.size() ;

            for(int i=0; i<size; i++){
                int[] pair = queue.poll();
                int x = pair[0];
                int y = pair[1];

                for(int p=0; p<4; p++){
                    int adj_x = x + drow[p];
                    int adj_y = y + dcol[p];

                    if(isValid(adj_x, adj_y, grid) && !visited.contains(adj_x + "|" + adj_y)){
                        queue.add(new int[]{adj_x, adj_y});
                        visited.add(adj_x + "|" + adj_y);
                    }
                }
            }
        }

        return maxDistance==0? -1 : maxDistance;
    }

    private static boolean isValid(int i, int j, int[][] grid) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
            return false;

        return grid[i][j] == 0;
    }

}
