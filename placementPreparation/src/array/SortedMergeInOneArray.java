package array;
/**
 * @author Satyam
 * Problem Statement: Given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. 
 *                    Merge B into A in sorted order.
 * Difficulty: Medium
 * tag: Marge array
 */
import java.util.Arrays;
public class SortedMergeInOneArray {
	//Method
	public static int[] mergeSortInOneArray(int[] arr1, int[] arr2, int n,int m) {
		int i = n-1;
		int j = m-1;
		int lastIndex = n+m - 1;
		while(j>=0) {
			if(arr1[i] >  arr2[j]) {
				arr1[lastIndex--] = arr1[i];
				i--;
			}
			else {
				arr1[lastIndex--] = arr2[j];
				j--;
			}
		}
		return arr1;
	}
	//Driver Code
	public static void main(String[] args) {
		int[] arr1 = new int[] {10, 12, 13, 14, 18, 0, 0, 0, 0, 0};
		int[] arr2 = new int[] {16, 17, 19, 20, 22};
		System.out.println(Arrays.toString(mergeSortInOneArray(arr1, arr2, 5, 5)));
	}

}
