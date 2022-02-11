package heap;
/**
 * @author Satyam
 * Problem statement: Given a characters array tasks, representing the tasks a CPU needs to do,
 *                    where each letter represents a different task. Tasks could be done in any order.
 *                    Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

                      However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array),
                      that is that there must be at least n units of time between any two same tasks.

                      Return the least number of units of times that the CPU will take to finish all the given tasks
                      
   Input: tasks = ["A","A","A","B","B","B"], n = 2
   Output: 8
   explain: A -> B -> idle -> A -> B -> idle -> A -> B
   
   Difficulty: Medium
   
   Tag: Max Heap, Queue
 */
import java.util.*;
public class Task_sheduling {
	
	static class Pair{
		int first, second;
		Pair(){
			this.first = 0;
			this.second = 0;
		}
		Pair(int i, int j){
			this.first = i;
			this.second = j;
		}
	}
	
	public static int taskSheduling(char[] tasks, int n) {
		int[] freq = new int[26];
        for(char ch: tasks)
            freq[ch-'A']++;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: freq){
            if(i!=0){
                maxHeap.add(i);
            }
        }
        
        Queue<Pair> queue = new LinkedList<Pair>();
        int time = 0;
        
        while(maxHeap.isEmpty()==false || queue.isEmpty()==false){
            time++;
            
            if(maxHeap.isEmpty()==false){
                int currTask = maxHeap.poll();
                currTask--; 
                if(currTask > 0){
                    queue.add(new Pair(currTask, time+n));
                }   
            }  
            
            if(queue.isEmpty()==false && queue.peek().second==time){
                Pair temp = queue.poll();
                maxHeap.add(temp.first);
            }
        }
        return time;
	}

	//Driver code
	public static void main(String[] args) {
		char[] arr = {'A', 'A', 'A', 'B', 'B', 'B'};
		System.out.println(taskSheduling(arr, 2)); //output = 8 
	}
}
