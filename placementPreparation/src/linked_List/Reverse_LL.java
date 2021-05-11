package linked_List;
/*Link : https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
 * Difficulty : Easy
 */
public class Reverse_LL {
	
	class Node{
		int data;
		Node next;
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	Node reverseList(Node head){
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

}
