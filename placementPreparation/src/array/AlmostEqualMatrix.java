package array;
import java.util.*;
public class AlmostEqualMatrix {
	public static void printMat(int[][] arr) {
		int n = arr.length;
		System.out.println("After updation of matrix : ");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) 
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		int ans = 0, temp;
		for(int i=n-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				if((i+1)<n) {
					if(arr[i][j] < arr[i+1][j]) {
						if((arr[i+1][j] - arr[i][j]) > k) {
							temp = arr[i+1][j] - arr[i][j]-k;
							ans += temp;
							arr[i][j] = arr[i][j]  + temp;
							printMat(arr);
						}
					}
					else if(arr[i+1][j] < arr[i][j]){
						if((arr[i][j] - arr[i+1][j]) > k) {
							temp = arr[i][j] - arr[i+1][j] -k;
							ans += temp;
							arr[i+1][j] = arr[i+1][j] + temp;
							printMat(arr);
						}
					}
				}
				if((j+1) < n) {
					if(arr[i][j] < arr[i][j+1]) {
						if((arr[i][j+1] - arr[i][j]) > k) {
								temp = arr[i][j+1] - arr[i][j] - k;
								ans += temp;
								arr[i][j] = arr[i][j] + temp;
								printMat(arr);
							}
						}
					else if(arr[i][j+1] < arr[i][j]) {
						if((arr[i][j] - arr[i][j+1]) > k) {
							temp = arr[i][j] - arr[i][j+1] -k;
							ans += temp;
							arr[i][j+1] = arr[i][j+1] + temp;
							printMat(arr);
						}
					}
				}
			}
		}
		System.out.println("final updation of matrix : ");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println(ans);

	}

}
