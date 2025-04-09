package linked_List;
/**
 * Reverses nodes of a linked list in groups of size k.
 * If the number of nodes left is less than k, they are left as is.
 *
 * Example:
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7, k = 3
 * Output: 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7
 *
 * @Dry_Run:
 * Initial list: dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
 *                ^
 *                |
 *              pointer
 *
 * --- First Iteration ---
 * tracker moves 3 times -> lands at node 3
 * Reversing 1 -> 2 -> 3:
 *   Iteration 1: prev = 1, curr = 2
 *   Iteration 2: prev = 2 -> 1, curr = 3
 *   Iteration 3: prev = 3 -> 2 -> 1, curr = 4
 * After reverse:
 *   prev = 3, curr = 4
 * Reconnect:
 *   dummy -> 3 -> 2 -> 1 -> 4 -> 5 -> 6 -> 7
 *                                   ^
 *                                   |
 *                                 pointer
 *
 * --- Second Iteration ---
 * tracker moves 3 times -> lands at node 6
 * Reversing 4 -> 5 -> 6:
 *   Iteration 1: prev = 4, curr = 5
 *   Iteration 2: prev = 5 -> 4, curr = 6
 *   Iteration 3: prev = 6 -> 5 -> 4, curr = 7
 * After reverse:
 *   prev = 6, curr = 7
 * Reconnect:
 *   dummy -> 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7
 *                                           ^
 *                                           |
 *                                         pointer
 *
 * --- Third Iteration ---
 * tracker moves 3 times -> only 1 node left (7)
 * Not enough nodes to reverse -> exit loop
 *
 * Final Output: 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7
 */


public class Reverse_K_group_in_LL {
	static class Node{
		int data;
		Node next;
		Node(int a){
			this.data = a;
			this.next = null;
		}
		Node(){
			this.data = 0;
			this.next = null;
		}
		Node(int i, Node next){
			this.data = i;
			this.next = next;
		}
	}
	
	public Node reverseKGroup(Node head, int k) {
		if(k==1 || head == null)
			return head;
		
		Node temp = new Node(0, head);
		
		Node prev = temp;
		Node curr = temp;
		Node next = temp;
		
		//finding the length of linked list
		int countLength = 0;
		Node size = head;
		while(size != null) {
			size = size.next;
			countLength++;
		}
		
		//reversing
		while(countLength >= k) {
			curr = prev.next;
			next = curr.next;
			for(int i=1; i<=k; i++) {
				curr.next = next.next;
				next.next = prev.next;
				prev.next = next;
				next = curr.next;
			}
			prev = curr;
			countLength -= k;
		}
		
		return temp.next;
	}
	
	//reverse k nodes
	public static Node[] reverse(Node head, int k) {
		Node curr = head;
		Node prev = null;
		
		for(int i=0; i<k; i++) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return new Node[] {prev, curr};
	}
	
	//Approach
	public static Node ReverseKGroup2(Node head, int k) {
		Node temp = new Node(-1, head);
		Node pointer = temp;
		
		while(pointer != null) {
			Node tracker = pointer;
			
			for(int i=0; i<k; i++) {
				if(tracker.next == null) return temp.next;
				
				tracker = tracker.next;
			}
			
			if(tracker != null) {
				
				Node[] reversedNode = reverse(pointer.next, k);
				
				Node prev = reversedNode[0];
				Node curr = reversedNode[1];
				
				Node lastNodeWhichGotReversed = pointer.next;
				lastNodeWhichGotReversed.next = curr;
				pointer.next = prev;
				
				pointer = lastNodeWhichGotReversed;
			}
		}
		return temp.next;
	}
	
	//Driver Code
	public static void main(String[] args) {
		Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        printLinkedList(head);
        
        head = ReverseKGroup2(head, 3);
        printLinkedList(head);
        
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = new Node(6);
        head2.next.next.next.next.next.next = new Node(7);
        head2.next.next.next.next.next.next.next = new Node(8);
        head2.next.next.next.next.next.next.next.next = new Node(9);
        printLinkedList(head2);
        
        head2 = ReverseKGroup2(head2, 3);
        printLinkedList(head2);
        
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
