package parentheses;

import java.util.*;
public class _4_Minimum_deletion_MakeValidParentheses {

	//Stack & Set Approach
	// TC : O(n) + O(n)
	// SC : O(n) + O(n)
	public static String minDeletion_using_Stack(String s) {
		Stack<Integer> stack1 = new Stack<>();
		Set<Integer> set = new HashSet<>();
		
		StringBuilder str = new StringBuilder("");
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack1.push(i);
			}
			else {
				if(!stack1.isEmpty()) 
					stack1.pop();
				else
					set.add(i);
			}
		}
		
		while(!stack1.isEmpty())
			set.add(stack1.pop());
		
		for(int i=0; i<s.length(); i++)
			if(!set.contains(i))
				str.append(s.charAt(i));
		
		return str.toString();
	}
	
	//String using approach
	//TC : O(n)
	//Sc : O(n - answer)
	public static String minDeleteion_using_string(String s) {
		StringBuilder str = new StringBuilder("");
		int open = 0;
		
		for(char ch: s.toCharArray()) {
			if(ch == '(') {
				open++;
				str.append(ch);
			}
			else {
				if(open > 0) {
					open--;
					str.append(ch);
				}
			}
		}
		
		return str.toString();
	}
	
	//Driver Code
	public static void main(String[] args) {
		System.out.println(minDeletion_using_Stack("((())))")); //((())))
		System.out.println(minDeletion_using_Stack(")((())")); //(())
		
		System.out.println(minDeleteion_using_string("((())))")); //((())))
		System.out.println(minDeleteion_using_string(")((())")); //(())
	}

}
