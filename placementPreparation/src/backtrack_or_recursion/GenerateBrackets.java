package backtrack_or_recursion;
import java.util.*;
public class GenerateBrackets {
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
    
    public static List<String> generateParenthesis(int n) 
    {
        ArrayList<String> arr = new ArrayList<String>();
        generateBrackets("", n, 0, 0, arr);
        return arr;
        
    }
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> arr = new ArrayList<String>();
		generateParenthesis(3);
		
		for(String i: arr) {
			System.out.print(i  +" ");
		}
		
		sc.close();
	}

}
