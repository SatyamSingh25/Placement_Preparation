package sorting;
import java.util.*;
/**
 * @author Satyam
 * Time Complexity : Best Time            Avg case/Worst case
 *                     O(1)                     O(n^2)
 * Space = O(1)
 * @Stable
 * @inPlace
 */
public class BubbleSort {
	public static void bubbleSort(int[] arr, int n) {
		boolean swap = false;
		for(int i=0; i<n-1; i++) {
			swap = false;
			for(int j=0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					//swap
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap = true;
				}
			}
			if(swap == false) {
				break;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		bubbleSort(arr, n);
		for(int i:arr) {
			System.out.print(i + " ");
		}
	}

}
