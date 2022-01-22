package stack;
import java.util.*;
public class Stack_Using_Queue {
	Queue<Integer> q1;
	Queue<Integer> q2;
	int top;
	//constructor
	public void stack_Using_Queue() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
		top = 0;
	}
	//push Method
	public void push(int a) {
		top = a;
		q1.add(a);
	}
	//pop method
	public int pop() {
		int size = q1.size();
		for(int i=1; i<size; i++) {
			if(i==size-1) {
				top = q1.peek();
			}
			q2.add(q1.poll());
		}
		int last = q1.poll();
		q1 = new LinkedList<Integer>(q2);
		q2.clear();
		return last;
	}
	//peek method
	public int peek() {
		return top;
	}
	//size of stack
	public int size(){
		return q1.size();
	}
}
