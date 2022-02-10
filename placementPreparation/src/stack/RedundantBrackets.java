package stack;
import java.util.*;
public class RedundantBrackets {
	public static boolean checkRedundentBrackets(String str) {
		Stack<Character> stack = new Stack<>();
		for(char ch: str.toCharArray()) {
			if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/' 	) {
				stack.push(ch);
			}
			else {	
				if(ch == ')') {
					
					boolean isRedundent = true;
					while(stack.peek() != '(') {
						char currTop = stack.pop();
						if(currTop == '+' || currTop == '-' || currTop == '*' || currTop == '/') {
							isRedundent = false;
						}
					}
					
					if(isRedundent == true) {
						return true;
					}
					stack.pop();
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String str = "(a+(b*C))";
		String  str2 = "((a+b))";
		
		if(checkRedundentBrackets(str)) {
			System.out.println("redundent brackets are present in str1");
		}
		else {
			System.out.println("redundent brackets are not present in str1: ");
		}
		
		if(checkRedundentBrackets(str2)) {
			System.out.println("redundent brackets are present in str2: ");
		}
		else {
			System.out.println("redundent brackets are not present in str2: ");
		}
	}

}
