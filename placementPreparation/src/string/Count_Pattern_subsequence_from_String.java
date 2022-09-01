package string;
import java.util.*;
/**
 * @Count_Pattern_subsequence_count_in_String
 * @Pattern_matching
 * @Optimised_approach
 * time: O(stringSize * patternSize)
 * space: O(patternSize)
 */
public class Count_Pattern_subsequence_from_String {
	
	public static int countPatternSubsequence(String str, String pattern) {
		System.out.println(str + " " + pattern);
		int strLen = str.length();
		int patternLen = pattern.length();
		
		int[] count = new int[patternLen];
		
		for(int i=0; i<strLen; i++){
            for(int j=patternLen-1; j>=0; j--){
                if(str.charAt(i) == pattern.charAt(j)){
                    count[j] += (j == 0 ? 1 : count[j - 1]);
                }
            }
        }
		System.out.println(Arrays.toString(count));
		return count[patternLen-1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); //geeksforgeeks
		String pattern = sc.next(); //gks
		
		//result -> 4 [g__ks_____, g__k______s, g________ks, _____g__ks]
		System.out.println(countPatternSubsequence(str, pattern));
	}

}
