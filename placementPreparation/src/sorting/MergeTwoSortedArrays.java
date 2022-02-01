package sorting;
/**
 * @author Satyam
 * Problem statement: Merge two sorted arrays
 * Difficulty: Medium
 * Tag: Array, Merge sort
 */
import java.util.*;
public class MergeTwoSortedArrays {
	
	//Method with O(n+m) Time and O(n+m) Space complexity.
	public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
		int n = arr1.length-1, m = arr2.length-1;
		//resultant array
		int[] answer = new int [(n+1)+(m+1)];
		int last = (n+1)+(m+1)-1;
		
		while(n>=0 && m>=0) {
			if(arr1[n] > arr2[m]) {
				answer[last--] = arr1[n--];
			}
			else {
				answer[last--] = arr2[m--];
			}
		}
		
		while(n >= 0) {
			answer[last--] = arr1[n--];
		}
		while(m >= 0){
			answer[last--] = arr2[m--];
		}
		
		return answer;
	}
	
	//Driver code
	public static void main(String[] args) {
		int[] arr1 = new int[] {1, 3, 5, 7};
		int[] arr2 = new int[] {2, 4,  8};
		System.out.println(Arrays.toString(mergeTwoSortedArray(arr1, arr2)));
	}
}
