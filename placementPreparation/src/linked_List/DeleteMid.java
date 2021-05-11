package linked_List;
/*Question Link  : https://www.geeksforgeeks.org/delete-middle-of-linked-list/
 * Difficulty : Easy
 */
public class DeleteMid {
	
	class Node{
		int data;
		Node next;
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	Node deleteMid(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;
        Node prevPtr = slowPtr;
        
        if(head!=null){
            while(fastPtr!=null && fastPtr.next!=null){
                prevPtr = slowPtr;
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }
        }
        
        if(slowPtr==prevPtr){
            return null;
        }
        prevPtr.next = slowPtr.next;
        
        return head;
    }

}
