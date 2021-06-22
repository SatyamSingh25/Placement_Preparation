package array;
import java.util.*;
public class MaxSquareOf_01_Matrix {
	public static int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[dp.length-1][dp[0].length-1] = matrix[matrix.length-1][matrix[0].length-1];
        int sum = 0;
        for(int i=dp.length-1; i>=0; i--){
            for(int j=dp[0].length-1; j>=0; j--){
                if(i==dp.length-1 || j==dp[0].length-1 || matrix[i][j]==0){
                    dp[i][j] = matrix[i][j];
                    sum+=dp[i][j];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i+1][j+1], dp[i+1][j]), dp[i][j+1])+1;
                    sum+=dp[i][j];
                }
            }
        }
        return sum;
    }

	public static void main(String[] args) {
		int[][] arr ={{1,0,1}, {1,1,0}, {1,1,0}};
		System.out.println(countSquares(arr));
	}

}
