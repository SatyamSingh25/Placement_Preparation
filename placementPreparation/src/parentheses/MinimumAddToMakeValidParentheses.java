package parentheses;

import  java.util.*;
public class MinimumAddToMakeValidParentheses {
	
	//Stack Approach
	// TC: O(n)
	// Sc: O(n)
	public static int minAdd_valid_parentheses_with_STACK(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(char ch: s.toCharArray()) {
			if(ch == '(')
				stack.push(ch);
			else {
				if(!stack.isEmpty() && stack.peek() == '(') 
					stack.pop();
				else
					stack.push(ch);
			}
		}
		
		return stack.size();
	}
	
	//single pass without stack
	//TC : O(n)
	//SC : O(1)
	public static int minAdd_valid_parentheses(String s) {
		int leftBrackets = 0, balance = 0;
		
		for(char ch:  s.toCharArray()) {
			if(ch == '(') {
				balance++;
			}
			else {
				if(balance == 0)
					leftBrackets++;
				else
					balance--;
			}
		}
		
		return leftBrackets + balance;
	}

	//Driver Code
	public static void main(String[] args) {
		System.out.println(minAdd_valid_parentheses_with_STACK("())))"));//3
		System.out.println(minAdd_valid_parentheses("())))"));//3
	}

}
