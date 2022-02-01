package math;

public class LongestTrailing1s {
	public static int maxOnes(int n) {
		int count = 0;
		while(n!=0) {
			n = (n&(n<<1));
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(maxOnes(6)); //110
	}

}
