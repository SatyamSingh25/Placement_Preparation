package islands;

public class At_possible_to_reach_end {
    public static int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        //traversing row
        for(int i=0; i<col; i++){
            if(grid[0][i] == 1) dfs(0, i, grid);
            if(grid[row-1][i] == 1) dfs(row-1, i, grid);
        }

        //traversing column
        for(int i=0; i<row; i++){
            if(grid[i][0] == 1) dfs(i, 0, grid);
            if(grid[i][col-1] == 1) dfs(i, col-1, grid);
        }

        int count = 0;
        for(int i=1; i<row-1; i++){
            for(int j=1; j<col-1; j++){
                if(grid[i][j] == 1)
                    count++;
            }
        }
        return count;
    }
    public static void dfs(int i, int j, int[][] grid){
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0)
            return;

        grid[i][j] = 0;
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }
    public static void main(String[] args){
        int[][] image = {{0,0,0,0},
                        {1,0,1,0},
                        {0,1,1,0},
                        {0,0,0,0}};

        int num = numEnclaves(image);
        System.out.println(num);
    }
}
