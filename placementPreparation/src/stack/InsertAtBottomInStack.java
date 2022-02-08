package stack;
import java.util.*;
public class InsertAtBottomInStack {
	
	public static void pushAtBottom(Stack<Integer> stack, int target){
		
		//base case
		if(stack.isEmpty()) {
			stack.push(target);
			return;
		}
		
		
		int	currTop = stack.pop();
		
		pushAtBottom(stack, target);
		
		stack.push(currTop);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		int target = 35;

		stack.push(24);
		stack.push(25);
		stack.push(26);
		stack.push(27);
		stack.push(28);
		System.out.println(stack);
		pushAtBottom(stack, target);
		
		System.out.println(stack);
		
	}

}
