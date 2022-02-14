package linked_List;

public class Reverse_K_group_in_LL {
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

}
