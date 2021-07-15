package linked_List;

public class OddEven {
	class Node{
		int data;
		Node next;
		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
	
	public Node oddEvenList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node odd = head;
		Node eHead = head.next;Node even = eHead;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = eHead;
		return head;
	}
}
