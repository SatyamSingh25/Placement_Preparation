package linked_List;

import linked_List.Delete_Nth_Node_From_Last.Node;

public class AddTwoLinkedList {

	static class Node {
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	//Add two Linked Lists
	public static Node addNumebers(Node head1, Node head2) {
		int carry = 0;
		Node temp = new Node(-1);
		Node head = temp;
		
		while(head1 != null || head2 != null || carry == 1) {
			int sum = 0;
			
			if(head1 != null) {
				sum += head1.data;
				head1 = head1.next;
			}
			
			if(head2 != null) {
				sum += head2.data;
				head2 = head2.next;
			}
			sum = sum + carry;
			
			carry = sum / 10;
			int data = sum % 10;
			
			temp.next = new Node(data);
			temp = temp.next;
		}
		
		return head.next;
	}
	
	//Driver Code
	public static void main(String[] args) {
		// First Linked List: 2 -> 4 -> 6
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(6);

        // Second Linked List: 5 -> 6 -> 4
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);
        
        Node head = addNumebers(l1, l2);
        printLinkedList(head);
        
	}
	
	static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}
