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
	//using hash map to solve this problem.
	public List<List<String>> groupAnagrams(String[] strs) {
		
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String i: strs){
        	
            char[] tempStr = i.toCharArray();
            Arrays.sort(tempStr);
            
            String tempString  = String.valueOf(tempStr);
            
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
}
