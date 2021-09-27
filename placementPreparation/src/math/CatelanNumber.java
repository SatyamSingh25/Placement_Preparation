package math;
/** Generating Catelan Numbers
 *  
 *  --->Catelan numbers can tell you how many BST will generated with N nodes 
 */
import java.util.*;
public class CatelanNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] catelanNumbers =  new int[n+1];
		catelanNumbers[0] = 1;
		catelanNumbers[1] = 1;
		for(int i=2; i<=n; i++) {
			for(int j=0; j<i; j++) {
				catelanNumbers[i] = catelanNumbers[i] + catelanNumbers[j] * catelanNumbers[i-j-1];
			}
		}
		for(int i: catelanNumbers)
			System.out.print(i+" ");
	}

}
