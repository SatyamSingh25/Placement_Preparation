package array;
import java.util.*;
public class SpiralTraversal {
	
	public static void printSpiral(int row, int col, int[][] arr) {
		int i;
		int k = 0; //current row
		int l = 0; // current column
		
		while(k < row && l < col) {
			for(i=l; i<col; i++) {
				System.out.print(arr[k][i] + " ");
			}
			k++; //move to the next row
			
			for(i=k; i<row; i++) {
				System.out.print(arr[i][col-1] + " "); 
			}
			col--; //move to prev column
			
			if(k < row) {
				for(i = col-1; i>=l; i--) {
					System.out.print(arr[row-1][i] + " ");
				}
				row--;
			}
			if(l < col) {
				for(i = row-1; i>=k; i--) {
					System.out.print(arr[i][l] + " ");
				}
				l++;
			}			
		}
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = 5;
		int c = 4;
		int[][] arr = new int[][] {{1, 2, 3, 4},
			                       {14, 15, 16, 5},
			                       {13, 20, 17, 6},
			                       {12, 19, 18, 7},
			                       {11, 10, 9, 8}};
		
		spiralPrint(5,4,arr);
		System.out.println();
		printSpiral(5, 4, arr);
				
	}
	
	static void spiralPrint(int m, int n, int a[][])
    {
        int i, k = 0, l = 0;
        while (k < m && l < n) {
            for (i = l; i < n; i++) {
                System.out.print(a[k][i] + " ");
            }
            k++;
            for (i = k; i < m; i++) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;
            if (k < m) {
                for (i = n - 1; i >= l; i--) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }
            if (l < n) {
                for (i = m - 1; i >= k; i--) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }
}
