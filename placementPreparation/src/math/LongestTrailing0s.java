package math;

public class LongestTrailing0s {
	public static int maxZeros(int n) {
		int count =0 ;
		int max = Integer.MIN_VALUE;
		while(n!=0) {
			if((n&1) == 0) {
				count++;
				n >>= 1;
				max = Integer.max(max, count);
			}
			else {
				max = Integer.max(max, count); 
				count = 0;
				n >>= 1;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		System.out.println(maxZeros(9));//1001
	}

}
