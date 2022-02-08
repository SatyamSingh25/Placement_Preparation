package stack;
/**
 * @author Satyam
 *	Problem statement: Sort the Stack
 */
import java.util.*;
public class Sort_The_Stack {
	
	//sorting method for stack
	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {	//base case
			return;
		}
		
		int currTop = stack.pop();
		
		sortStack(stack);
		//inserting the current top element at correct position in stack
		insertAtCorrectPosition(stack, currTop);
	}
	//inserting a target at correct location
	public static void insertAtCorrectPosition(Stack<Integer> stack, int target) {
		//base case
		if(stack.isEmpty() || stack.peek() <= target ) {
			stack.push(target);
			return;
		}
		
		int currTop = stack.pop();
		
		insertAtCorrectPosition(stack, target);
		
		stack.push(currTop);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(-1);
		stack.push(3);
		stack.push(2);
		stack.push(-7);
		
		System.out.println("original stack: " + stack); //[5, -1, 3, 2, -7]
		
		sortStack(stack);
		
		System.out.println("sorted stack: " + stack); //[-7, -1, 2, 3, 5]

	}

}
