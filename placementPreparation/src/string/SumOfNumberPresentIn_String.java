package string;
/**
 * @author Satyam
 * Problem statement: Sum of all numbers whose in string
 * Difficulty: Easy but have to know the use of Integer or Character wrapper class
 * Tag: String , Character class, Integer class 
 */
import java.util.*;
public class SumOfNumberPresentIn_String {
	//Method
	public static int findSumOfNumber(String str) {
		int i = 0;
		String temp = "0";
		int sum = 0;
		
		while(i < str.length()) {
			
			if(Character.isDigit(str.charAt(i))==true) {
				temp+=str.charAt(i);
			}
			else {
				sum += Integer.parseInt(temp);
				temp = "0";
			}
			
			i++;
		}
		return sum+Integer.parseInt(temp);
	}
	
	//Driver Code
	public static void main(String[] args) {
		String str = "1abc2x30yz67"; 
		System.out.println(findSumOfNumber(str));
	}

}
