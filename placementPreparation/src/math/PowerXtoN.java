package math;
/**
 * @Implement Pow(x,n) | X raised to the power N
 * @StriverDSASheet
 * 
 * Problem : Given a double x and integer n, calculate x raised to power n. Basically Implement pow(x, n).
 * 
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 */
public class PowerXtoN {
	
	// Time : O(log(N))
	//Space : O(1)
	public static double powerXtoN(double number, int power) {
		int copyOfPower = power;
		double ans = 1.0;
		
		while(power > 0) {
			if(power % 2 == 0) {
				number = number * number;
				power = power / 2;
			}
			else {
				ans = ans * number;
				power--;
			}
		}
		
		if(copyOfPower < 0) ans = (double)1.0/ans;
		
		return ans;
	}

	//Driver Code
	public static void main(String[] args) {
		double number = 2.0000;
		int power = 10;
		
		System.out.println(powerXtoN(number, power));
	}

}
