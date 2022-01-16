package array;
import java.util.*;
public class FindMissingNumber {
	//Approach 1 
	public static int findMissing1(int[] arr) {
		int res = (arr.length*(arr.length+1))/2;
		for(int i: arr) {
			res-=i;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {0,1,3,4,5,8,6,7};
		System.out.println(findMissing1(arr));
	}
}
