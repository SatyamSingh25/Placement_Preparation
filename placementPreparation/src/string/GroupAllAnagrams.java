package string;
/**
 * @author Satyam
 * Problem statement: Group all the anagrams together words = ["eat","tea","tan","ate","nat","bat"]
 *                                                   output = [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Difficulty: Medium
 * Tag: String, hash table, sorting
 */
import java.util.*;

public class GroupAllAnagrams {
	
	//group all the anagrams
	public static ArrayList<ArrayList<String>> groupAnagrams(String[] words){
		
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for(String str: words) {
			
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			
			String s = String.valueOf(ch);
			
			if(map.containsKey(s) == false) {
				map.put(s, new ArrayList<String>());
			}
			
			map.get(s).add(str);
		}
		
		return new ArrayList<>(map.values());
	}

	//driver code
	public static void main(String[] args) {
		String[] words = new String[] {"eat","tea","tan","ate","nat","bat"};
		
		System.out.println(groupAnagrams(words));
	}
}
