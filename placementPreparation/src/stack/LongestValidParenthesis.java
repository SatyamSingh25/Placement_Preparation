package stack;
/**
 * @Stack
 * @Longest_Valid_Paranthesis
 * @Valid_Parenthesis
 */
import java.util.*;
public class LongestValidParenthesis {
	
	public static int longestValidParenthesis(String str) {
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push(i);
			}
			else {
				stack.pop();
				if(stack.isEmpty())
					stack.push(i);
				else
					max = Math.max(max, i-stack.peek());
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String str = ")()())";
		System.out.println(longestValidParenthesis(str));
	}

}
;