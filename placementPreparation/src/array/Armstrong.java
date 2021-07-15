package array;
import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int size=0;
		int temp = num;
		while(temp!=0) {
			size++;
			temp = temp/10;
		}
		temp = num;
		int sum = 0;
		while( temp!=0 ) {
			sum = (int) (sum + Math.pow(temp%10, size));
			temp = temp/10;
		}
		if(sum == num) {
			System.out.println("true");
		}
		else {
			System.out.println("False");
		}
		sc.close();
	}

}
