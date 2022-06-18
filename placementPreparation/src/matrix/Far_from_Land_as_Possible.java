package matrix;

import java.util.*;
public class Far_from_Land_as_Possible {
	
	public static void main(String[] args){
		
        int[][] grid = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        int[][] grid2 = new int[][]{{1,0,0},{0,0,0},{0,0,0}};
        
        //result -> 2
        System.out.println(maxDistance(grid));
        
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

        
        
        //Direction
        int[] drow = new int[]{1, 0, -1, 0};
        int[] dcol = new int[]{0, 1, 0, -1};
        
        int maxDistance = -1;
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
