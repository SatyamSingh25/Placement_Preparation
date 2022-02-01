package standard_Quetions;
import java.util.*;
public class GenerateAllValidBrackets {
	//Method
	public static void generateParanthesis(String s, int size, int open, int close, ArrayList<String> list) {
		if(s.length() == size*2) {
			list.add(s);
			s= "";
		}
		if(s.length() > size*2)
			return;
		
		if(open < size) {
			generateParanthesis(s+"(", size, open+1, close, list);
		}
		if(close < open) {
			generateParanthesis(s+")", size, open, close+1, list);
		}
	}
	//Driver Code
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		generateParanthesis("", 5, 0, 0, arr);
		System.out.println(arr.size() + "\n" + arr);
		
	}
}