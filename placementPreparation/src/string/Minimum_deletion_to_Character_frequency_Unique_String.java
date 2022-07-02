package string;
/**
 * @Minimum_Deletion_to_Character_Frequency_String
 * @String
 * @Leetcode_1647
 * @Frequency
 */
import java.util.*;
public class Minimum_deletion_to_Character_frequency_Unique_String {

	public static int minDeletion(String str) {
		int[] freq = new int[26];
		for(char ch: str.toCharArray()) {
			freq[ch-'a'] += 1;
		}
		
		int minDeletion = 0;
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<freq.length; i++) {
			while(freq[i] > 0 && set.contains(freq[i])) {
				freq[i]--;
				minDeletion++;
			}
			set.add(freq[i]);
		}
		return minDeletion;
	}
	
	public static void main(String[] args) {
		//result -> 2
		System.out.print(minDeletion("aaabbbcc")); 
	}

}
