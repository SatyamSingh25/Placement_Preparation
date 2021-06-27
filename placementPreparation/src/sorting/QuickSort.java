package sorting;
import java.util.*;
/**
 * @author Satyam Singh
 * Time Complexcity :   Best Case           Worst Case
 *                      O(nlongn)             O(n^2)
 * @Not_Stable
 * @In_Place
 */
public class QuickSort {
	public static void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low-1;
		for(int j=low; j<high; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, high);
		return i+1;
	}
	public static void quickSort(int[] arr, int low, int high) {
		if(low <  high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(arr, 0, n-1);
		for(int i: arr) {
			System.out.print(i+ " ");
		}
		
	}

}
