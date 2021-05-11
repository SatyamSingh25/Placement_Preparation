package linked_List;
/*Link : https://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way/
 * Difficulty: Easy 
 */
public class Insert_In_Sorted_LL {
	class Node{
		int data;
		Node next;
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	Node sortedInsert(Node head1, int key) {
        Node newNode = new Node(key);
        Node temp = head1;
        
        if(head1==null || head1.data>key){
            newNode.next = head1;
            head1= newNode;
        }
        else{
            while(temp.next != null && temp.next.data<key){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next =  newNode;
        }
        return head1;
    }
}
