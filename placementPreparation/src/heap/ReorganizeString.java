package heap;
import java.util.*;
/**
 * @author Satyam Singh
 * ---------------------------LEETCODE 767----------------------------------------------------------
 * Problem link : https://leetcode.com/problems/reorganize-string/
 * Description : Given a string s, check if the letters can be rearrangedB so that two characters
 *               that are adjacent to each other are not the same.

                 If possible, output any possible result.  If not possible, return the empty string.
   
   Input: s = "aab"
   Output: "aba"
   
   Input: s = "aaab"
   Output: ""
   
   Difficulty : Medium
 */
public class ReorganizeString {
	
	public String reorganizeString(String s) {       
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue((a,b)->map.get(b)-map.get(a));
        maxHeap.addAll(map.keySet());
        
        StringBuilder result = new StringBuilder();
        while(maxHeap.size() > 1){
            char curr = maxHeap.remove();
            char next = maxHeap.remove();
            
            result.append(curr);
            result.append(next);
            
            map.put(curr, map.get(curr)-1);
            map.put(next, map.get(next)-1);
            
            if(map.get(curr)>0){
                maxHeap.add(curr);
            }
            if(map.get(next) > 0){
                maxHeap.add(next);
            }
        }
        
        if(!maxHeap.isEmpty()){
            char last = maxHeap.remove();
            if(map.get(last)>1){
                return "";
            }
            result.append(last);
        }
        return result.toString();
    }
}
