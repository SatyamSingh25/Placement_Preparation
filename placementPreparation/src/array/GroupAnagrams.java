package array;
import java.util.*;
/**
 * @Group_Of_Anagrams 
 * @Leetcode_49
 * @Contributor Satyam Singh
 *  Problem link : https://leetcode.com/problems/group-anagrams/
 *	Difficulty : Medium
 */
public class GroupAnagrams {
	//Time: O(N * M * nLogN)
	//using hash map to solve this problem.
	public List<List<String>> groupAnagrams(String[] strs) {
		
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String i: strs){ //O(N)
        	
            char[] tempStr = i.toCharArray(); //O(M)
            Arrays.sort(tempStr); //NlogN
            
            String tempString  = new String(tempStr);
            
            if(!map.containsKey(tempString)){
                map.put(tempString, new ArrayList<String>());
            }
            
            map.get(tempString).add(i);
        }
        List<List<String>> res = new ArrayList<>();
        
        for(ArrayList<String> itr: map.values()){
            res.add(itr);
        }
        
        return res;
    }
	
	//Approach 2
	//Time: O(n * m)
	public static List<List<String>> groupAnagrams2(String[] strs) {
		
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String i: strs){
        	
            char[] tempStr = new char[26];
            
            for(int ch: i.toCharArray()) {
            	tempStr[ch-'a']++;
            }
            
            String tempString  = String.valueOf(tempStr);
            
            if(!map.containsKey(tempString)){
                map.put(tempString, new ArrayList<String>());
            }
            
            map.get(tempString).add(i);
        }
        
        List<List<String>> res = new ArrayList<>();        
        res.addAll(map.values());
        
        return res;
    }
	
	public static void main(String[] args) {
		String[] words = new String[] {"eat","tea","tan","ate","nat","bat"};
		System.out.print(groupAnagrams2(words));
	}
}
