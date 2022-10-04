package heap;
/**
 * @Satyam_Singh
 * @K_Closest_Elements
 * @PriorityQueue
 * @Heap
 * @Max_Heap according to diff for size K 
 */
import java.util.*;
public class K_Closest_Elements_to_X {
	
	public static List<Integer> kClosestElements(int[] arr, int k, int x){
		//max Heap according to "diff"
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.diff - a.diff); 
		
		for(int i=0; i<k; i++) {
			pq.add(new Pair(arr[i], Math.abs(arr[i]-x)));
		}
		
		Pair curr;
		for(int i=k; i<arr.length; i++) {
			curr = pq.peek();
			if(curr.diff > Math.abs(arr[i]-x)) {
				pq.poll();
				pq.add(new Pair(arr[i], Math.abs(arr[i]-x)));
			}
		}
		
		//adding k elements to list
		List<Integer> result = new ArrayList<>();
		while(pq.isEmpty() == false) {
			result.add(pq.poll().num);
		}
		
		Collections.sort(result); // output needed in Sorted order
		return result;
	}

	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5};
		
		List<Integer> result = kClosestElements(arr, 4,  3);
		System.out.println(result);
	}
	
	static class Pair{
		int num;
		int diff;
		
		Pair(){}
		Pair(int a, int b){
			this.num = a;
			this.diff = b;
		}
	}

}
