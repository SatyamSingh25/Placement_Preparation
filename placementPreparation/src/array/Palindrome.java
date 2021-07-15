package array;
import java.util.*;
public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int i = 0;
		int j = str.length()-1;
		boolean bool = false ;
		while(i<=j) {
			if(str.charAt(i) != str.charAt(j)) {
				bool = false;
				break;
			}
			else {
				bool = true;
				i++;
				j--;
			}
		}
		System.out.println(bool);
	}

}
