package islands;
/**
 * @BFS
 * @Matrix
 * @Shortest_Distance
 */
import java.util.*;
public class Shortest_Bridge_between_Two_Islands {
    //main method
    public static void main(String[] args){
        int[][] grid = new int[][]{{0,1,0},
                                    {0,0,0},
                                    {0,0,1}};
        //result -> 2
        System.out.println(shortestBridge(grid));
    }
    //Shortest bridge between two islands
    public static int shortestBridge(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<row; i++){
            boolean flag = false;
            for(int j=0; j<col; j++){
                if(count == 0 && grid[i][j] == 1){
                    dfs(i, j, grid, queue);
                    count++;
                }
                if(count>=1){
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        int[] drow = new int[]{0,1,0,-1};
        int[] dcol = new int[]{1,0,-1,0};

        int bridgeSize = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            bridgeSize++;
            boolean flag2 = false;

            for(int i=0; i<size; i++){
                int[] pair = queue.poll();
                boolean flag1 = false;
                for(int j=0; j<4; j++){
                    int x = pair[0] + drow[j];
                    int y = pair[1] + dcol[j];

                    if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y] == 1){
                        flag1 = true;
                        break;
                    }

                    if(isValid(x, y, grid)){
                        grid[x][y] = -1;
                        queue.add(new int[]{x, y});
                    }
                }
                if(flag1){
                    flag2 = true;
                    break;
                }
            }
            if(flag2){
                break;
            }
        }
        return bridgeSize;
    }

    public static void dfs(int i, int j, int[][] grid, Queue<int[]> queue){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == -1)
            return;

        if(grid[i][j] == 1){
            grid[i][j] = -1;
            queue.add(new int[]{i, j});
            dfs(i+1, j, grid, queue);
            dfs(i-1, j, grid, queue);
            dfs(i, j+1, grid, queue);
            dfs(i, j-1, grid, queue);
        }
    }

    public static boolean isValid(int i, int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == -1)
            return false;

        return grid[i][j] == 0;
    }
}
