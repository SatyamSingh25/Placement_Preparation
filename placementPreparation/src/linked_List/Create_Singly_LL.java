package linked_List;

public class Create_Singly_LL {
	
	Node head;
	
	public static class Node{
		int data;
		Node next;
		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
	
	public static Create_Singly_LL addNode(Create_Singly_LL list, int d) {
		Node newNode = new Node(d);
		newNode.next = null;
		
		if(list.head == null) {
			list.head = newNode;
		}
		else {
			Node last = list.head;
			while(last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		
		return list;
	}

	public static void printList(Create_Singly_LL list) {
		System.out.println("printing singly linked list: ");
		Node temp = list.head;
		while(temp != null) {
			System.out.print("|" + temp.data + "|->");
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		
		Create_Singly_LL list = new Create_Singly_LL();
		for(int i=0; i<10; i++) {
			list = addNode(list, i);
		}
		
		printList(list);
		
	}

}
