package linked_List;
/*Discription : Given a singly linked list of size N. The task is to rotate the linked list counter-clockwise
 *  by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.
 * input: 
 * |1|->|2|->|3|->|4|->|5|->|6|->|7|->null
 * k = 3
 * 
 * o/p:
 * |4|->|5|->|6|->|7|->|1|->|2|->|3|->null
 */

public class Rotate_LL {
	
	class Node{
		int data;
		Node next;
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	//rotate function 
	//O(n) TC & O(1) SC
	public Node rotate(Node head, int k) {
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        
        Node rotator = head;
        while(k!=0){
            head = rotator.next;
            temp.next = rotator;
            rotator.next = null;
            temp = rotator;
            rotator  = head;
            k = k-1;
        }
        return head;
    }
}
