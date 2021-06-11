package array;
import java.util.*;
public class MeetingRooms {
	public static int meeting(int[][] arr) {
		Arrays.sort(arr, (a,b)->Integer.compare(a[0], b[0]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int interval[] : arr) {
			if(pq.size() == 0) {
				pq.add(interval[1]);
			}
			else {
				if(pq.peek() > interval[0]) {
					pq.add(interval[1]);
				}
				else {
					pq.remove();
					pq.add(interval[1]);
				}
			}
		}
		return pq.size();
	}
	public static void main(String[] ars) {
		int arr[][] = new int[][] {{0,30},{5,10},{15,20}};
		System.out.println(meeting(arr));
	}
}
