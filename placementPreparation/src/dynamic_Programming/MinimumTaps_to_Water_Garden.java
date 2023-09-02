package dynamic_Programming;
/**
 * @Minimum_Number_of_Taps_to_Open_to_Water_a_Garden
 * @PairClass
 * @0_1Knapsack
 * @TwoChoices
 * @Twitter_Amazon_facebook_Expedia_Veritas
 */
/* ---------------------------------1326. Minimum Number of Taps to Open to Water a Garden-------------------------------------
 * There is a one-dimensional garden on the x-axis. 
 * The garden starts at the point 0 and ends at the point n. (i.e., the length of the garden is n).
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 * 
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed)
 * means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 * 
 * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 * 
 * Input: n = 5, ranges = [3,4,1,1,0,0]
 * Output: 1
 * Explanation: The tap at point 0 can cover the interval [-3,3]
 * The tap at point 1 can cover the interval [-3,5]
 * The tap at point 2 can cover the interval [1,3]
 * The tap at point 3 can cover the interval [2,4]
 * The tap at point 4 can cover the interval [4,4]
 * The tap at point 5 can cover the interval [5,5]
 * Opening Only the second tap will water the whole garden [0,5]
 */
import java.util.*;
public class MinimumTaps_to_Water_Garden {
	
	public int minTaps(int n, int[] ranges) {
		Pair<Integer, Integer>[] range = new Pair[ranges.length];
		for(int i=0; i<ranges.length; i++) {
			int start = Math.max(0, i - ranges[i]);
			int end = Math.min(ranges.length, i + ranges[i]);
			
			range[i] = new Pair<>(start, end);
		}
		
		Arrays.sort(range, (a,b)-> a.getKey() - b.getKey());
		
		int totalOpenTaps = solve(0, 0, range, n);
		return totalOpenTaps == 1e9 ? -1 : totalOpenTaps;
	}
	
	
	HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
	int solve(int start, int endMax, Pair<Integer, Integer>[] range, int lastPoint) {
		//range is complete
		if(start >= range.length)
			//check is my curr endMax point is more than land size 
			//that means full gargen is fullflied with water
			return (int)(endMax >= lastPoint ? 0 : 1e9);
		
		//if my curr pair[3,4] start-'3' is more than current cover endMax 
		//that means we missed some area in between
		if(range[start].getKey() > endMax){
			return (int)1e9;
		}
		
		if(map.containsKey(new Pair<>(start, endMax))) {
			return map.get(new Pair<>(start, endMax));
		}
		
		int notOpenTap = solve(start+1, endMax, range, lastPoint);
		int openTap = 1 + solve(start + 1, Math.max(endMax, range[start].getValue()), range, lastPoint);
		
		int res = Math.min(notOpenTap, openTap);
		return res;
	}
	
	class Pair<K, V>{
		private K key;
		private V value;
		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return this.key;
		}
		
		public V getValue() {
			return this.value;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o ==  null || getClass() != o.getClass()) return false;
			Pair<?, ?> pair = (Pair<? , ?>) o;
			return Objects.equals(key, pair.key) && Objects.equals(value, pair.value); 
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(key, value);
		}
	}
	
	public static void main(String[] args) {
		MinimumTaps_to_Water_Garden obj = new MinimumTaps_to_Water_Garden();
		int[] arr = new int[]{3,4,1,1,0,0};
		
		System.out.println(obj.minTaps(5, arr)); //1
		System.out.println(obj.minTaps(5, new int[] {2,0,0,0,2})); //2 
	}

}
