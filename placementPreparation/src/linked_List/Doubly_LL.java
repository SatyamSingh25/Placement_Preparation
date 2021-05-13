package linked_List;

public class Doubly_LL {
	
	Node head;
	public static class Node{
		Node prev;
		int data;
		Node next;
		public Node(int d) {
			this.data = d;
			this.prev = null;
			this.next = null;
		}
	}
	
	public static Doubly_LL addNode(Doubly_LL list, int d) {
		Node newNode = new Node(d);
		if(list.head == null) {
			list.head = newNode;
		}
		else {
			Node last = list.head;
			while(last.next != null) {
				last = last.next;
			}
			last.next = newNode;
			newNode.prev = last;
			newNode.next = null;
		}
		return list;
	}
	
	public static void printList(Doubly_LL list) {
		System.out.println("printing Doubly LL: ");
		Node temp = list.head;
		while(temp != null) {
			System.out.print("|" + temp.data + "|<=>");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		Doubly_LL list = new Doubly_LL();
		for(int i=0; i<10; i++) {
			list = addNode(list, i);
		}
		printList(list);
	}

}
