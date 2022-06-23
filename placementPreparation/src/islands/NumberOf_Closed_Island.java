package islands;
/**
 * @Number_of_Covered_Islands_by_1s
 * @DFS
 * @Boundry_Traversal_and_DFS
 */
public class NumberOf_Closed_Island {
    public static void main(String[] args){
        int[][] mat = new int[][]{{1,1,1,1,1,1,1,0},
                                  {1,0,0,0,0,1,1,0},
                                  {1,0,1,0,1,1,1,0},
                                  {1,0,0,0,0,1,0,1},
                                  {1,1,1,1,1,1,1,0}};

        //result -> 2
        System.out.println("Number of closed Islands: " + closedIsland(mat));
    }
    public static int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int countIslands = 0;

        //traversaing row
        for(int i=0; i<col; i++){
            if(grid[0][i] == 0)
                dfs(0, i, grid);

            if(grid[row-1][i] == 0)
                dfs(row-1, i, grid);
        }

        //traversing column
        for(int i=0; i<row; i++){
            if(grid[i][0] == 0)
                dfs(i, 0, grid);

            if(grid[i][col-1] == 0)
                dfs(i, col-1, grid);
        }

        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(grid[i][j] == 0){
                    dfs(i, j, grid);
                    countIslands++;
                }
            }
        }
        return countIslands;
    }
    private static void dfs(int i, int j, int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (i<0 || i>=row || j<0 || j>=col || grid[i][j]==1) {
            return;
        }

        grid[i][j] = 1;
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }
}
