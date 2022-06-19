package matrix;
/**
 * @Nearest_Distance_from_1_to_0
 * @BFS
 * @leetcode_542
 */
import java.util.*;
public class _01_Matrix {
	//main method
	public static void main(String[] args) {
		int[][] mat = new int[][] {{0,0,0},{0,1,0},{1,1,1}};
		
		mat = updateMatrix(mat);
		
		for(int i=0; i<mat.length; i++)
			System.out.println(Arrays.toString(mat[i]));
		
	}
	
	public static int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        
        int[] drow = new int[]{1, 0, -1, 0};
        int[] dcol = new int[]{0, 1, 0, -1};
        
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            
            for(int i=0; i<4; i++){
                int x = pair[0] + drow[i];
                int y = pair[1] + dcol[i];
                
                if(isValid(x, y, mat)){
                    mat[x][y] = mat[pair[0]][pair[1]] + 1;
                    queue.add(new int[]{x,y});
                }
            }
        }
        return mat;
    }   
    public static boolean isValid(int i, int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
            return false;
        
        return grid[i][j] == -1;
    }
}
