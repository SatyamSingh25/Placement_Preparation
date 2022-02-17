package array;

import java.util.Scanner;

public class Fibonacci {

	//O(1) space
	public static int fibonacci(int n) {
		int first = 0, second = 1, nth=0;
		
		if(n==0 || n==1) {
			return n;
		}
		
		for(int i=2; i<=n; i++) {
			nth = first + second;
			first = second;
			second = nth;
		}
		return nth;
	}
	
	//DP O(n) time and space
	public static int fibo_dp(int n) {
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2; i<=n;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}

	//recursive
	public static int fibo(int n) {
		if(n<=1) {
			return n;
		}
		return fibo(n-1)+fibo(n-2);
	}

	//Driver code
	public static void main(String[] args) {
		int n = 8;
		//recursive
		System.out.println(fibo(n));
		//iterrative
		System.out.println(fibo_dp(n));
		//Optimised O(1) space
		System.out.println(fibonacci(n));
	}
	

	

}
