package islands;

import java.util.Scanner;

public class NumberOfIslands {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] mat = new int[][] {
                                    {1,1,1,1,0},
                                    {1,1,0,1,0},
                                    {1,1,0,0,0},
                                    {0,0,0,0,0}
                                   };
        //result -> 1
        System.out.println(numberOfIslands(mat));

        int[][] mat2 = new int[][] {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };
        //result -> 3
        System.out.println(numberOfIslands(mat2));
    }

    private static int numberOfIslands(int[][] mat) {
        int count = 0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1){
                    dfs(i, j, mat, mat.length, mat[0].length);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, int[][] mat, int row, int col) {
        if(i<0 || i>=row || j<0 || j>=col || mat[i][j] == 0){
            return;
        }

        if(mat[i][j] == 1){
            mat[i][j] = 0;
            dfs(i+1, j, mat, row, col);
            dfs(i-1, j, mat, row, col);
            dfs(i, j+1, mat, row, col);
            dfs(i, j-1, mat, row, col);
        }
    }

}
