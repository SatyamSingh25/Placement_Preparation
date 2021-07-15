package array;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//recursive
		System.out.println(fibo(n));
		//iterrative
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2; i<=n;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println(dp[n]);
	}
	public static int fibo(int n) {
		if(n<=1) {
			return n;
		}
		return fibo(n-1)+fibo(n-2);
	}

}
