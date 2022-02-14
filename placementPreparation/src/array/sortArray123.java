package array;
/**
 * @author Satyam
 * Problem statement: Sort the array containing only 1,2,3
 * 
 * input: [3,1,3,2,1,1,3,2,1,3,2,2,1,1,2,3,1]
 * output: [1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3]
 * 
 * tag: Three pointers (low, mid, high)
 *                      low  -> 1
 *                      mid  -> 2
 *                      high -> 3
 */
import java.util.Arrays;
public class sortArray123 {
	//sort the array containg only 1,2,3
	public static int[] sort123(int[] arr) {
		int i=0, m=0, j=arr.length-1;
		while(m<j) {
			if(arr[m] == 1) {
				swap(arr, m, i);
				m++;
				i++;
			}
			if(arr[m] == 2) {
				m++;
			}
			if(arr[m] == 3) {
				swap(arr, j, m);
				j--;
			}
		}
		return arr;
	}
	//swapping elements
	public static void swap(int[] arr,int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	//driver code
	public static void main(String[] args) {
		int[] arr = new int[] {3,1,3,2,1,1,3,2,1,3,2,2,1,1,2,3,1};
		System.out.println(Arrays.toString(sort123(arr)));
		
	}

}
