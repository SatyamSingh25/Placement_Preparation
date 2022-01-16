package sorting;
//Cyclic sort is used when there is all element is are in range 1 to N
//index of current element =  current element-1

import java.util.Arrays;

public class CyclicSort {
	public static void cyclicSort(int[] arr) {
		int i=0;
		while(i<arr.length) {
			int index = arr[i]-1;
			if(arr[i] != arr[index]) {
				swap(arr,i, index);
			}
			else {
				i++;
			}
		}
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		//input1
		int[] arr = new int[] {4,3,2,7,8,2,3,1};
		cyclicSort(arr);
		System.out.println(Arrays.toString(arr));
		//input2
		int[] arr2 = new int[] {5,4,3,2,1};
		cyclicSort(arr2);
		System.out.println(Arrays.toString(arr2));
	}

}
