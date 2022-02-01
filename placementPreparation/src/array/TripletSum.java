package array;
/**
 * @author Satyam
 * Problem statement: Find the triplets in array whose sum is Zero [3 Sum (Leetcode)]
 * Difficulty: Medium
 * Tag: Two pointer, Array
 */
import java.util.*;
public class TripletSum {
	//Triplet Sum
	public static List<List<Integer>> tripletSum(int[] arr){
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(arr);
		for(int i=0; i<arr.length-2; i++) {
			int j = i+1;
			int k = arr.length-1;
			while(j < k) {
				if(arr[j] + arr[k] == -arr[i]) {
					set.add(Arrays.asList(arr[i], arr[j], arr[k]));
					k--;
					j++;
				}
				else if(arr[j] + arr[k] > -arr[i]) {
					k--;
				}
				else if(arr[j]+arr[k] < -arr[i]) {
					j++;
				}
			}
		}
		return new ArrayList<>(set); 
	}
	
	//Driver code
	public static void main(String[] args) {
		int[] arr = new int[] {-1,0,1,2,-1,-4};
		System.out.println(tripletSum(arr));
	}

}
