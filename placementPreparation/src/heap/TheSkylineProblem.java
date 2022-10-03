package heap;

import java.util.*;
public class TheSkylineProblem {
	
	public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> arr = new ArrayList<>();
        
        for(int i=0; i<buildings.length; i++){
            int start = buildings[i][0];
            int end = buildings[i][1];
            int height = buildings[i][2];

            arr.add(new Pair(start, -height)); //adding start point
            arr.add(new Pair(end, height)); //adding end point
        }

        Collections.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.add(0);

        int currMaxHeight = 0;
        List<List<Integer>> result = new ArrayList<>();

        for(Pair curr: arr){
            int start = curr.x;
            int height = curr.height;

            if(height < 0){//starting point of rectangle
                pq.add(-height);
            }
            else{ //ending point of rectangle
                pq.remove(height);
            }

            if(currMaxHeight != pq.peek()){
                List<Integer> innerList = new ArrayList<>();
                innerList.add(start);
                innerList.add(pq.peek());

                result.add(innerList);
                currMaxHeight = pq.peek();
            }
        }

        return result;
    }

    public static class Pair implements Comparable<Pair>{
        int x;
        int height;

        Pair(int x, int ht){
            this.x = x;
            this.height = ht;
        }
  
        @Override
        public int compareTo(Pair i){
            if(this.x != i.x){
                return this.x - i.x;
            }
            else{
                return this.height - i.height;
            }
        }
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] buildings = new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		
		List<List<Integer>> result = getSkyline(buildings);
		for(List<Integer> res: result)
			System.out.println(res);
	}

}
