package standard_Quetions;
import java.util.*;
public class FibonacciSereis_all_approach {
	//recursive method
	public static int findFibo_recursive(int n) {
		if(n==0 || n==1) {
			return n;
		}
		return findFibo_recursive(n-1)+findFibo_recursive(n-2);
	}
	//DP method O(n) space & time
	public static int DPFibonacciNumber(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	//optimised Method O(n) time O(1) space
	public static int optimisedFibonacci(int n) {
		if(n<=1) {
			return n;
		}
		int a = 0, b= 1, c;
		for(int i=2; i<=n; i++) {
			c = a+b;
			a = b;
			b = c;
		}
		return b;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(findFibo_recursive(num));
		System.out.println(DPFibonacciNumber(num));
		System.out.println(optimisedFibonacci(num));
	}

}
