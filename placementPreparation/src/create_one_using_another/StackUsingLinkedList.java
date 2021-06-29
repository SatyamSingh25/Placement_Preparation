package create_one_using_another;
import java.util.EmptyStackException;
import java.util.Scanner;
/**
 * @Contributor Satyam Singh
 * @Stack_Using_Linked_List
 */
public class StackUsingLinkedList {
	static class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	static int size = 0;
	static Node top;
	StackUsingLinkedList(){
		this.top = null;
	}
	//push method (adding data on the top)	
	public static void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		size++;	
	}
	
	//pop method (removing data from the top)
	public static int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		int result = top.data;
		top = top.next;
		size--;
		return result;
	}
	
	//checking whether a stack is empty of not
	public static boolean isEmpty() {
		return size == 0;
	}
	
	//peek method (looking for the top value of stack)
	public static int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	//printing full list
	public static void display() {
		Node current = top;
		while(current != null) {
			System.out.print(current.data + "-> ");
			current = current.next;
			if(current == null) {
				System.out.print("null");
			}
		}
	}
	public static void main(String[] args) {
		
		StackUsingLinkedList list = new StackUsingLinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.push(6);
		list.push(7);
		
		System.out.println(list.peek());
		list.pop();
		System.out.println(list.peek());
		list.pop();
		System.out.println(list.peek());
		list.pop();
		System.out.println(list.peek());
		display();
		
	}

}
