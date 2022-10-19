package heap;

import java.util.*;
public class Top_K_frequent_word {
	static class Pair {
        String word;
        int count;
        Pair(){}
        Pair(String str, int count){
            this.word = str;
            this.count = count;
        }        
    }
	public static List<String> solve(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
        	(a,b) -> {
        		if(a.count == b.count) {
        			return a.word.compareTo(b.word); //if count same then lexografically first will come first
        		}
        		return b.count - a.count; //map heap acc/to count
        	}
        );
        
        for(Map.Entry<String, Integer> itr: map.entrySet())
        	pq.offer(new Pair(itr.getKey(), itr.getValue()));
        
        List<String> result = new ArrayList<>();
        while(k-- != 0) {
        	result.add(pq.poll().word);
        }
        
        return result;
	}

	public static void main(String[] args) {
		String[] words = {"i","love","leetcode","i","love","coding"};
		System.out.println(solve(words, 3));
	}

}
