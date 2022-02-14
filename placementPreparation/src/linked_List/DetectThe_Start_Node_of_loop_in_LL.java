package linked_List;
/**
 * @author Satyam
 * link: https://leetcode.com/problems/linked-list-cycle-ii/
 * Problem statement: Find the start node of the loop
 * 
 */
public class DetectThe_Start_Node_of_loop_in_LL {
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
	
	public Node detectFirstNodeOf_Loop(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				slow = head;
				
				while(slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				
				return slow; //you can also return 'fast' both are at same point
			}
			
		}
		
		return null;
	}
}
