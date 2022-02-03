package math;
import java.util.*;
/**
 * @author Satyam
 * Problem Statement: Find all Primes till n in time O(n*log(log(n)))
 */
public class SeiveOfEratosthenes {
	//find all primes till n
	private static void findPrimeTillN(int n) {
		
		boolean[] primes = new boolean[n+1];
		Arrays.fill(primes, true);
		//important 'for' condition line
		for(int i=2; i*i <=n ;i++) {
			
			if(primes[i] == true) {
				//important 'for' condition line
				for(int j=i*i; j<=n; j+=i) {
					primes[j] = false;
				}
			}
		}
		//Printing
		for(int i=0; i<=n; i++)
			if(primes[i] == true)
				System.out.print(i+" ");
	}
	//Driver method
	public static void main(String[] args) {
		findPrimeTillN(100);
	}

}
