package array;
import java.util.*;
public class SecondLargest {
	public static int[] secondLargest(int[] arr) {
		int largest = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			largest = Math.max(largest, arr[i]);
		}
		int secLargest = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < largest) {
				secLargest = Math.max(secLargest, arr[i]);
			}
		}
		return new int[] {largest, secLargest};
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		int[] secLarge = secondLargest(arr);
		System.out.println("largest: " + secLarge[0]);
		System.out.println("Second Largest: " + secLarge[1]);
	}

}
