package array;
import java.util.*;
public class SpiralTraversal {
	static void spiralPrint(int m, int n, int a[][])
    {
        int i, k = 0, l = 0;
        while (k < m && l < n) {
            for (i = l; i < n; ++i) {
                System.out.print(a[k][i] + " ");
            }
            k++;
            for (i = k; i < m; ++i) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] arr = new int[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		spiralPrint(r,c,arr);
				
	}

}
