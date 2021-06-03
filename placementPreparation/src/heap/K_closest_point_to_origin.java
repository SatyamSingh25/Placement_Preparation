package heap;
import java.util.*;
/**
 * @author Satyam Singh
 * -----------------------------LEETCODE 973--------------------------------
 * problem link : https://leetcode.com/problems/k-closest-points-to-origin/
 * Difficulty : Medium
 */
public class K_closest_point_to_origin {
	//pair of hypotenuse and coordinate
	class pair{
        int sqrt;
        int[] arr = new int[2];
        public pair(){}
        public pair(int root, int[] arr){
            this.sqrt = root;
            this.arr[0] = arr[0];
            this.arr[1] = arr[1];
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int row =  points.length;
        //int col = points[0].length;
        
        //max heap technique
        PriorityQueue<pair> queue = new PriorityQueue<>(new Comparator<pair>(){
            public int compare(pair a, pair b){
                return b.sqrt - a.sqrt;
            }
        });
        
        //main procedure
        for(int i=0; i<row; i++) {
        	int[] arr = new int[2];
        	arr[0] = points[i][0];
        	arr[1] = points[i][1];
        	int hypo = (arr[0] * arr[0])  + (arr[1]*arr[1]);
        	
        	queue.add(new pair(hypo, arr));
        	if(queue.size() > k) {
        		queue.poll();
        	}
        }    
        //maintaining result matrix here
        int[][] res = new int[k][2];
        for(int i=0; i<k; i++) {
        	res[i][0] = queue.peek().arr[0];
        	res[i][1] = queue.peek().arr[1];
        	queue.poll();	
        }
        return res;
    }
}
