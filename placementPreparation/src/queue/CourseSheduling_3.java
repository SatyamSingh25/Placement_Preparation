package queue;
import java.util.*;
public class CourseSheduling_3 {

	public int scheduleCourse(int[][] courses) {
        //sorting the array according to 2nd column
        Arrays.sort(courses, (a, b)-> a[1]-b[1]);
        
        //maxHeap
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        
        //time taken by courses
        int time = 0;
        
        for(int[] course: courses){
        	
            //can we take this course or not
            if(course[0] <= course[1]){
            	
                //possible to take this course 
                if(course[0]+time <= course[1]){
                    queue.offer(course[0]);
                    time += course[0];
                }
                //not possible to take this course
                else{
                    //can be swap or not
                    if(queue.peek() > course[0]){
                        time -= queue.poll();
                        time += course[0];
                        queue.offer(course[0]);
                    }
                }
            }
        }
        return queue.size();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
