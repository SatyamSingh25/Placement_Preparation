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
        
        //frequencies of characters
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1); 
        }
        
        //Max Heap according to frequency of characters
        PriorityQueue<Character> maxHeap = new PriorityQueue((a,b)->map.get(b)-map.get(a));
        maxHeap.addAll(map.keySet());
        
        
        StringBuilder result = new StringBuilder();
        while(maxHeap.size() > 1){
            char curr = maxHeap.remove(); //removing top element
            char next = maxHeap.remove(); //removing 2nd top element
            
            //adding top two characters into result string because two adjacent doesn't to be same
            result.append(curr);
            result.append(next);
            
            //decreasing the count by 1 of used characters
            map.put(curr, map.get(curr)-1);
            map.put(next, map.get(next)-1);
            
            //after removing -> if count of USED characters are not 0[ZERO] then 
            //                  again add that in maxHeap (acc/to freq of characters)
            
            if(map.get(curr)>0){
                maxHeap.add(curr);
            }
            if(map.get(next) > 0){
                maxHeap.add(next);
            }
        }
        
        //if last element in the maxHeap have count>1 
        //then it means -> two adjacent are going to be happen so RETURN "EMPTY STRING"
        //otherwise add that into result string
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
