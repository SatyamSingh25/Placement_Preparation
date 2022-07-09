package array;

import java.util.Arrays;

public class SortArrayWithoutSorting {

	public static void main(String[] args) {
		int[] arr = new int[] {4,2,5,1,7,4};
		int n = arr.length;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}

}
