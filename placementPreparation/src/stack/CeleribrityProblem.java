package stack;
/**
 * @author Satyam
 * Problem statement:  find a celebrity in a Party where celebrity don't know anybody but 
 *                     everybody knows the celebrity.
 *                     arr[i][j] == 1 -> means 'i' knows the 'j'
 *                     [n X n] matrix]
 * Difficulty: Medium
 * Tag: Stack
 */
import java.util.*;
public class CeleribrityProblem {
	
	public static int findCelebrity(int[][] arr, int n) {
		//entering each person in the stack
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<n;i++)
			stack.push(i);
		//poping first 2 elements until size 1 and check whether if 
		//'first' knows 'second' then -> 'second' can be celebrity and push 'second' into the stack
		//else 'first' can be celebrity so push 'first' into a stack.
		while(stack.size()!=1) {
			int first = stack.pop();
			int second = stack.pop();
			if(arr[first][second] ==  1) {
				stack.push(second);
			}
			else {
				stack.push(first);
			}
		}
		
		int currAssumed = stack.pop();			
		//checking in column and  row
		for(int i=0; i<n; i++) {
			if(arr[currAssumed][i] == 1) { //not possible condition 
				return -1;
			}
			if(i!=currAssumed) {
				if(arr[i][currAssumed] == 0) { //not possible condition 
					return -1;
				}
			}
		}		
		return currAssumed; //result
	}
	//Driver code
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		//taking input
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//printing result
		System.out.println(findCelebrity(arr, n));
		sc.close();
	}
}
