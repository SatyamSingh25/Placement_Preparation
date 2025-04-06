package backtrack_or_recursion;
import java.util.*;
/**
 * @author Satyam
 * -----------------------------------------Letter Combinations of a Phone Number-------------------------------------
 * Given a string containing digits from 2-9 inclusive, 
 * return all possible letter combinations that the number could represent. 
 * Return the answer in any order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * 
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */

public class LetterCombination {
	
	private static ArrayList<String> combinations = new ArrayList<>();
	private static int count = 0;
	
	public static List<String> letterCombinations(String digits){
		if(digits.length() == 0) return combinations;
		
		String[] alphas = {"0", "0", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		solve(0, "", digits, alphas);
		
		return combinations;
	}
	
	public static void solve(int start, String currString, String digits, String[] alphas){
		
		if(start == digits.length()) {
			combinations.add(currString);
			return;
		}
		
		String possibleAplhas = alphas[digits.charAt(start) - '0'];
		for(char ch: possibleAplhas.toCharArray()) {
			solve(start + 1, currString + ch, digits, alphas);
		}
	}
	
	public static void main(String[] args) {
		String digits = "232";
		letterCombinations(digits);
		
		//[ada, adb, adc, aea, aeb, aec, afa, afb, afc, bda, bdb, bdc, bea, beb, bec, bfa, bfb, bfc, cda, cdb, cdc, cea, ceb, cec, cfa, cfb, cfc]
		System.out.println(combinations);
	}

}
