package islands;

import java.util.*;
public class Farthest_zero {
    public static void main(String[] args){
        int[][] grid = new int[][]{{1,0,1},
                                    {0,0,0},
                                    {1,0,1}};
        //reuslt -> 2
        System.out.println(maxDistance(grid));

    }
    public static int maxDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    visited.add(i + "|" +j);
                }
            }
        }

        int[] drow = new int[]{-1, 0, 1, 0};
        int[] dcol = new int[]{0, 1, 0, -1};

        int maxSteps = -1;
        while(!queue.isEmpty()){
            maxSteps++;
            int currQueueSize = queue.size();

            for(int j=0; j<currQueueSize; j++){
                int[] pair = queue.poll();
                int x = pair[0];
                int y = pair[1];
                for(int i=0; i<4; i++){
                    int adj_x = x + drow[i];
                    int adj_y = y + dcol[i];

                    if(isValid(adj_x, adj_y, grid) == false
                            || visited.contains(adj_x+"|"+adj_y)){
                        continue;
                    }

                    queue.offer(new int[]{adj_x, adj_y});
                    visited.add(adj_x + "|" + adj_y);
                }
            }
        }
        return maxSteps==0? -1 : maxSteps;
    }
    private static boolean isValid(int i, int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return false;
        }
        return grid[i][j] == 0;
    }
}
