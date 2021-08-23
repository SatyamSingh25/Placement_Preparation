package string;

import java.util.ArrayList;
import java.util.Scanner;

public class VowelAndConstantsSubStrings {
	public static int subString(int n ) {
		return (n*(n+1)/2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		ArrayList<Integer> vowel = new ArrayList<Integer>();
		ArrayList<Integer> consonant = new ArrayList<Integer>();
		
		for(int i=0 ;i<str.length(); i++) {
			char ch = str.charAt(i); 
			if(ch=='a' || ch == 'e' || ch == 'i'|| ch == 'o' || ch == 'u'||
					ch=='A' || ch == 'E' || ch == 'I'|| ch == 'O' || ch == 'U') {
				vowel.add(i);
			}
			else {
				consonant.add(i);
			}
		}
		int sum = 0;
		//for vowel to consonant subStrings
		for(int i =0; i<vowel.size(); i++) {
			int k = consonant.size()-1;
			while(k>=0 && vowel.get(i)<consonant.get(k)) {
				sum++;
				k--;
			}
		}
		//for consonant to vowel substrings
		for(int i=0; i<consonant.size(); i++) {
			int k = vowel.size()-1;
			while(k>=0 && consonant.get(i)<vowel.get(k)) {
				sum++;
				k--;
			}
		}
		System.out.println(sum);
		sc.close();
	}

}
