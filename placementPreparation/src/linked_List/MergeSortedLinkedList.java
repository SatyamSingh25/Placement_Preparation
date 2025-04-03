package linked_List;

public class MergeSortedLinkedList {
	
	static class Node {
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	public static Node mergeSortedLinkedList(Node head1, Node head2) {
		Node temp = new Node(-1);
		Node head = temp;
		
		while(head1 != null && head2 != null) {
			if(head1.data <= head2.data) {
				temp.next = head1;
				head1 = head1.next;
				temp = temp.next;
			}
			else {
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}
		}
		
		while(head1 != null) {
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		
		while(head2 != null) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		
		return head.next;
	}
	
	

	public static void main(String[] args) {
		 Node head1 = new Node(1);
	     head1.next = new Node(3);
	     head1.next.next = new Node(6);
	     System.out.print("list 1 : ");
	     printLinkedList(head1);
	        
	     Node head2 = new Node(2);
	     head2.next = new Node(5);
	     head2.next.next = new Node(8);
	     head2.next.next.next = new Node(9);
	     head2.next.next.next.next = new Node(10);
	     System.out.print("list 2 : ");
	     printLinkedList(head2);
	     
	     Node sortedListNode = mergeSortedLinkedList(head1, head2);
	     
	     System.out.print("Sorted : ");
	     printLinkedList(sortedListNode);
	     /*
	      * list 1 : 1 -> 3 -> 6 -> null
	      * list 2 : 2 -> 5 -> 8 -> 9 -> 10 -> null
	      * Sorted : 1 -> 2 -> 3 -> 5 -> 6 -> 8 -> 9 -> 10 -> null
	      */
	     
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
