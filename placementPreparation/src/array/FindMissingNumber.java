package array;
import java.util.*;
public class FindMissingNumber {
	//Approach 1 
	public static int findMissing1(int[] arr) {
		int n  = arr.length;
		int res = (n*(n+1))/2;
		for(int i: arr) {
			res-=i;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {0 ,1, 2, 4, 5, 6};
		System.out.println(findMissing1(arr));
	}
}
