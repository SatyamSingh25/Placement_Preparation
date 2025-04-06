package parentheses;
import java.util.*;
public class _1_ValidParenthesis {
	
	//Approach
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else{
                if(stack.isEmpty() ||
                    (ch == ')' && stack.pop() != '(') ||
                    (ch == '}' && stack.pop() != '{') ||
                    (ch == ']' && stack.pop() != '['))
                        return false;
            }
        }

        return stack.isEmpty();
    }

	public static void main(String[] args) {
		System.out.println(isValid("([])")); //true
		System.out.println(isValid("([")); //false
	}

}
