package sorting;

import java.util.Scanner;
/**
 * @author Satyam Singh
 *Time complexity : Best case              Worst case
 *                    O(n)                   O(n^2)
 * Space : O(1)
 * @Stable
 * @In_place
 */
public class InsertionSort {
	public static void insertionSort(int[] arr, int n) {
		for(int i=1; i<n; i++) {
			int curr = arr[i];
			int j = i-1;
			while(j>=0 && arr[j] > curr) {
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1] = curr;
		}
	}
	public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	int n =sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        	arr[i] = sc.nextInt();
        
        insertionSort(arr, n);
        System.out.println("Sorted array");
        for(int i: arr) {
        	System.out.print(i + " ");
        }
    }

}
