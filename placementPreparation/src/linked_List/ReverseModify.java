package linked_List;

import linked_List.Reverse_LL.Node;

public class ReverseModify {
	
	static class Node{
		int data;
		Node next;
		public Node(int d) {
			data = d;
			next = null;
		}
		public Node(int d, Node next) {
			this.data = d;
			this.next = next;
		}
	}
	
	static Node reverseList(Node head){
		if(head == null) {
			return null;
		}
        if(head.next==null){
            return head;
        }
        else{
            Node prev = null;
            Node current = head;
            Node next = null;
            while(current != null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
        return head;
    }
	
	public static Node test(Node head) {
		Node temp = head;
		while(temp != null) {
			temp.next = reverseList(temp.next);
			temp = temp.next;
		}
		return head;
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = (new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + "-> " );
			temp = temp.next;
		}
		temp = test(head);
		while(temp != null) {
			System.out.print(temp.data + "-> " );
			temp = temp.next;
		}
	}
}
