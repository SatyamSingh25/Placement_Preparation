package standard_Quetions;
import java.util.*;
public class Solution {
	
	public static int solution(int[] A) {
        int answer = 0;
        float totalSum = 0f;
        PriorityQueue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: A){
            totalSum += num;
            queue.add((double)num);
        }
        float requiredSum = totalSum/2;
        while(totalSum > requiredSum){
            double curr = queue.poll();
            double newCurr = curr/2;
            totalSum -= newCurr;
            queue.add(newCurr);

            answer++;
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
