package heap;
import java.util.*;
/**
 * @author Satyam
 * Problem link : https://leetcode.com/problems/last-stone-weight/
 * Difficulty : Easy 
 */
public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<stones.length; i++){
            pQueue.add(stones[i]);
        }
        while(pQueue.size() != 1){
            int x = pQueue.poll();
            int y = pQueue.poll();
            pQueue.offer(x-y);
        }
        return pQueue.poll();
    }
}
