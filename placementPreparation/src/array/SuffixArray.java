package array;

import java.util.Arrays;
import java.util.Scanner;

public class SuffixArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder(sc.next());
		int n = str.length();
		String[] StringArray = new String[n-1];
		int[] arr = new int[n-1];
		int x = 0;
		for(int i=1; i<n; i++) {
			StringArray[x] = str.substring(i);
			arr[x] = i;
			x++;
		}
		System.out.println(Arrays.toString(StringArray));
		System.out.println(Arrays.toString(arr));
	}
}
