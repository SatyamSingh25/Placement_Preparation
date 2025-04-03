package linked_List;

import linked_List.MergeSortedLinkedList.Node;

public class Delete_Nth_Node_From_Last {
	
	static class Node {
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	public static Node removeNthFromLast(Node head, int n) {
		Node curr = head;
		Node prev = head;
		
		while(n-- != 0)
			curr = curr.next;
		
		if(curr == null) //means need to delete first node of list
			return head.next;
		
		while(curr.next != null) {
			curr = curr.next;
			prev = prev.next;
		}
		
		prev.next = prev.next.next;
		return head;
	}

	//Driver Code
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(6);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next = new Node(10);
        System.out.println("Initial List: ");
        printLinkedList(head);
        
        // removing last 4th node
        head = removeNthFromLast(head, 4);
        System.out.println("After removing last 4th Node from List: ");
        printLinkedList(head);
        
        /*
         * Initial List: 1 -> 3 -> 6 -> 2 -> 5 -> 8 -> 9 -> 10 -> null
         * After removing last 4th Node from List: 
         * 1 -> 3 -> 6 -> 2 -> 8 -> 9 -> 10 -> null
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
