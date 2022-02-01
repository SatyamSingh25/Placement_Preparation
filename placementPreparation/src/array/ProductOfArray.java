package array;
/**
 * @author Satyam
 * Problem Statment: Given an array arr[] of n integers, construct a Product Array prod[] (of same size) 
 *                   such that prod[i] is equal to the product of all the elements of arr[] except arr[i]. 
 *                   Solve it without division operator in O(n) time
 * Difficulty: Easy but tricky
 * Tag: Math
 */
import java.util.Arrays;
public class ProductOfArray {
	//Method
	public static int[] findProductExecptItself(int[] arr) {
		int n = arr.length;
		int[] prod = new int[n];
		Arrays.fill(prod, 1);
		int temp = 1;
		for(int i=0; i<n; i++) {
			prod[i] *= temp;
			temp *= arr[i];
		}
		temp = 1;
		for(int i=n-1; i>=0; i--) {
			prod[i] *= temp;
			temp *= arr[i];
		}
		return prod;
	}
	
	//Driver Code
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 3, 5, 6, 2 };
		System.out.println(Arrays.toString(findProductExecptItself(arr)));
	}

}
