package stack;
/**
 * @author Satyam
 * Problem statement: Reverse stack in O(1) space
 */
import java.util.*;
public class ReverseStack_using_recursion {
	
	public static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		
		int currTop = stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, currTop);
	}
	
	public static void insertAtBottom(Stack<Integer> stack, int target) {
		if(stack.isEmpty()) {
			stack.push(target);
			return;
		}
		int currTop = stack.pop();
				
		insertAtBottom(stack, target);
		
		stack.push(currTop);
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(24);
		stack.push(25);
		stack.push(26);
		stack.push(27);
		stack.push(28);
		
		System.out.println("Original Stack: "  + stack); //[24, 25, 26, 27, 28]
		reverseStack(stack);
		System.out.println("Reversed Stack:" + stack); //[28, 27, 26, 25, 24]
		

	}

}
