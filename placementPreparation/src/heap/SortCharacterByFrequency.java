package heap;
import java.util.*;
/**
 * @author Satyam Singh
 * -------------------------------LEETCODE 451---------------------------------
 * Problem link : https://leetcode.com/problems/sort-characters-by-frequency/
 * Description : Given a string s, sort it in decreasing order based on the
 *               frequency of characters, and return the sorted string.
 * 
 * Input : "tree"
 * output : "eert"
 * 
 * Difficulty : Medium
 */
public class SortCharacterByFrequency {
	//creating pair which has Character as a key and Integer as a value 
	class Pair{
        int value;
        char ch;
        public Pair(char ch, int val){
            this.ch = ch;
            this.value = val;
        }
    }
	
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        
        //counting frequency of each alphabet
        for(char c: arr){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        //using Max Heap in order to solve this problem
        PriorityQueue<Pair> queue=new PriorityQueue<Pair>((obj1,obj2)->obj2.value-obj1.value);

        //inserting hashmap values into max heap 
        for(Map.Entry<Character,Integer>entry:map.entrySet()){
            queue.add(new Pair(entry.getKey(),entry.getValue()));
        }
        
        StringBuilder res = new StringBuilder(); //result string
        
        //procedure
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            char ch = pair.ch;
            int count = pair.value;
            for(int i=0; i<count; i++){
                res.append(ch+"");
            }
        }
        
        return res.toString();
    }
}
