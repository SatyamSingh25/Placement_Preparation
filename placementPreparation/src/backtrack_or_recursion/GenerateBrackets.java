package backtrack_or_recursion;
/**
 * Generate all valid parenthesis
 */
import java.util.*;
public class GenerateBrackets {
	
	//Approach
	public static List<String> generateParenthesis(int n) {
        ArrayList<String> arr = new ArrayList<String>();
        
        generateBrackets("", n, 0, 0, arr);
        
        return arr;        
    }
	
	//generating helper
	public static void generateBrackets(String s, int size, int open, int close, ArrayList<String> arr){
        if(s.length()==size*2){
            arr.add(s);
            s="";
        }
        
        if(open < size){
            generateBrackets(s+"(", size, open+1, close, arr);
        }
        if(close < open){
            generateBrackets(s+")", size, open, close+1, arr);
        }
    }	

	//Driver Code
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3)); //[((())), (()()), (())(), ()(()), ()()()]
	}

}
