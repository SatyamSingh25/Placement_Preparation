package array;
import java.util.*;
public class ShrutiAndSets {
	public static int shrutiAndSet(int[] arr, int n, int k) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i: arr) {
			set.add(i);
		}
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				set.add(Math.abs(arr[i] - arr[j]));
			}
		}
		ArrayList<Integer> list = new ArrayList<>(set);
		System.out.println(list);
		return list.get(list.size()-k);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.print(shrutiAndSet(arr, n, k));
	}
}
