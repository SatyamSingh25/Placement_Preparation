package backtrack_or_recursion;
import java.util.*;

public class LetterCombination {
	
	private static ArrayList<String> combinations = new ArrayList<>();
	private static int count = 0;
	
	public static List<String> letterCombinations(String digits){
		
		if(digits.length() == 0) return combinations;
		
		String[] alphas = {"0", "0", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		solve(digits, alphas, 0,  "");
		return combinations;
	}
	
	public static void solve(String digits, String[] alphas, int currIndex, String str){
		if(currIndex == digits.length()) {
			System.out.println(++count);
			combinations.add(str);
			return;
		}
		
		String possibleAplhas = alphas[digits.charAt(currIndex) - '0'];
		System.out.println(possibleAplhas);
		for(char ch: possibleAplhas.toCharArray()) {
			solve(digits, alphas, currIndex + 1, str + ch);
		}
	}
	
	public static void main(String[] args) {
		String digits = "232";
		letterCombinations(digits);
		System.out.println(combinations);
	}

}
