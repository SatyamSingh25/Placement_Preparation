package dynamic_Programming;
/**
 * @contributed Satyam Singh
 * Problem Link : https://leetcode.com/problems/climbing-stairs/
 * Difficulty : Easy
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
		if(n==0 || n==1){
			return 1;
		}
		int[] arr = new int[n+1]; // using extra space
		arr[0] = 0;
       	arr[1] = 1;
       	arr[2] = 2;
       	for(int i=3 ;i<=n; i++){
           	arr[i] = arr[i-1] + arr[i-2];
       	}
       	return arr[n];
	}
}
