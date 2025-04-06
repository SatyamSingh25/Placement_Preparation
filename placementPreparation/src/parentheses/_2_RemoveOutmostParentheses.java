package parentheses;
/**
 * -------------------------------------------Remove Outmost Parentheses------------------------------------
 */
public class _2_RemoveOutmostParentheses {
	
	//Approach
	public static String removeOutmostParentheses(String s){
		StringBuilder str = new StringBuilder("");
		int count = 0;
		
		for(char ch: s.toCharArray()) {
			if(ch == '(') {
				if(count > 0) str.append(ch);
				count++;
			}
			else {
				count--;
				
				if(count > 0) str.append(ch);
			}
		}
		
		return str.toString();
	}

	//Driver Code
	public static void main(String[] args) {
		System.out.println(removeOutmostParentheses("(()())(())")); //()()()
	}

}
