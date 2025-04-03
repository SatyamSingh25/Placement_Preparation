package linked_List;

import linked_List.AddTwoLinkedList.Node;

public class DeleteNode_in_O1_time {

	public static void deleteNode(Node currNode) {
		if(currNode == null)
			return;
		if(currNode.next == null)
			currNode = null;
		else {
			currNode.data = currNode.next.data;
			currNode.next = currNode.next.next;
		}
	}
	
	public static void main(String[] args) {
		Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(6);
        printLinkedList(l1);
        
        deleteNode(l1.next);
        
        printLinkedList(l1);
	}
	
	static class Node {
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
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
