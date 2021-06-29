package create_one_using_another;
import java.util.*;
/**
 * @Contributor Satyam Singh
 * @stack_Using_Queue
 */
public class Stack_Using_Queue {
	//using two queues
	static Queue<Integer> q1 = new LinkedList<>();
	static Queue<Integer> q2 = new LinkedList<>();
	
	public static void push(int x) {
		q1.offer(x);
	}
	
	public static int pop() {
		if(q1.isEmpty()) {
			throw new EmptyStackException();
		}
		
		while(q1.size() != 1) {
			q2.offer(q1.remove());
		}
		
		int top = q1.remove();
		
		//swaping queues
		Queue<Integer>  temp = q1;
		q1 = q2;
		q2 = temp;
		
		return top;
	}
	
	public static int peek() {
		if(q1.isEmpty()) {
			throw new EmptyStackException();
		}
		
		while(q1.size() != 1) {
			q2.offer(q1.remove());
		}
		
		int top = q1.remove();
		
		//swaping queues
		Queue<Integer>  temp = q1;
		q1 = q2;
		q2 = temp;
		
		q1.offer(top);
		
		return top;
	}
	public static void main(String[] args) {
		Stack_Using_Queue stack = new Stack_Using_Queue();
		stack.push(0);
		stack.push(1);
		stack.push(2);

		System.out.println("Peek: "  + stack.peek());
		System.out.println("pop: "  + stack.pop());
		System.out.println("Peek: "  + stack.peek());
		System.out.println("pop: "  + stack.pop());
	}

}
