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
		
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		for(ArrayList<String> itr: map.values()) {
			result.add(itr);
		}
		return result;
	}

	//driver code
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] words = new String[n];
		for(int i=0; i<n; i ++) {
			words[i] = sc.next();
		}
		
		System.out.println(groupAnagrams(words));
	}
}
