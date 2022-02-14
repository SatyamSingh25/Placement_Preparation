package linked_List;
/**
 * @author Satyam
 * Link:https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1/#
 * Problem Statement: Remove the Loop from the LL.
 *                    [variation of detect the first node loop]
 *                    
 *               
 */
public class Remove_Loop_from_LL {
	class Node{
		int data;
		Node next;
		Node(){
			this.data = 0;
			this.next = null;
		}
		Node(int i, Node next){
			this.data = i;
			this.next = next;
		}
	}
	
	public void removeLoop(Node head) {
		Node slow = head;
		Node fast = head;
		Node prev = null;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				slow = head; //now slow  pointing to head node of the LL
				prev = fast;
				
				if(slow == head) { //means already at the start node of loop
					fast = fast.next;
					while(fast != slow) {
						prev = fast;
						fast = fast.next;
					}
				}
				else {
					while(slow != fast) {
						slow = slow.next;
						prev = fast;
						fast = fast.next;
					}
				}
				
				break;
			}
		}
		
		if(prev != null) {
			prev.next = null;
		}
	}
}
