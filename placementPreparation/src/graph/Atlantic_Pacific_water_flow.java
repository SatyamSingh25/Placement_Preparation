package graph;
import java.util.*;
public class Atlantic_Pacific_water_flow {
	
    public static void main(String[] args){
        int[][] heights = new int[][]{{1,2,2,3,5},
                                        {3,2,3,4,4},
                                        {2,4,5,3,1},
                                        {6,7,1,4,5},
                                        {5,1,1,2,4}};
        //result -> [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
        System.out.print(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
    	
        int row = heights.length;
        int col = heights[0].length;
        List<List<Integer>> arr = new ArrayList<>();

        //where Atlantic and Pecific water can flow
        boolean[][] atlantic = new boolean[row][col];
        boolean[][] pecific = new boolean[row][col];

        //dfs
        for(int i=0; i<col; i++){
            dfs(0, i, heights, Integer.MIN_VALUE, pecific);
            dfs(row-1, i, heights, Integer.MIN_VALUE, atlantic);
        }
        for(int i=0; i<row; i++){
            dfs(i, 0, heights, Integer.MIN_VALUE, pecific);
            dfs(i, col-1, heights, Integer.MIN_VALUE, atlantic);
        }

        //preparing the result
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(atlantic[i][j] && pecific[i][j]){
                    arr.add(Arrays.asList(i, j));
                }
            }
        }
        return arr;
    }
    
    //Directions 4 ways
    static int[] drow = new int[]{1, 0, -1, 0};
    static int[] dcol = new int[]{0, 1, 0, -1};

    public static void dfs(int i, int j, int[][] mat, int prev, boolean[][] ocean){
        if(i<0 || i>=ocean.length || j<0 || j>=ocean[0].length)
            return;

        //already water flowed or
        //Current wall is bigger then previous then water can not flow
        //so simply return from this side.
        if(mat[i][j] < prev || ocean[i][j])
            return;

        ocean[i][j] = true;
        for(int x=0; x<4; x++){
            int adj_i = i + drow[x];
            int adj_j = j + dcol[x];

            dfs(adj_i, adj_j, mat, mat[i][j], ocean);
        }
    }
}
