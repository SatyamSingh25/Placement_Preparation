package linked_List;
/*problem link : https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1/?track=amazon-linkedlists&batchId=192#
 * difficulty : Medium 
 */
public class Add_1_in_LL {
	
	class Node{
		int data ;
		Node next;
		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
	
	public static Node reverse(Node head){
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    public static Node addOneUntil(Node head){
        Node res = head;
        Node temp = null;
        Node prev = null;
        
        int carry = 1;
        int sum;
        while(head != null){
            sum = carry +  head.data;
            if(sum>=10){
                carry = 1;
            }
            else{
                carry = 0;
            }
            
            sum = sum%10;
            head.data = sum;
            temp = head;
            head = head.next;
        }
        Node newNode = new Node(carry);
        if(carry>0){
            temp.next = newNode;
        }
        
        return res;
    }
    public static Node addOne(Node head) 
    { 
        head = reverse(head);
        head = addOneUntil(head);
        head = reverse(head);
        return head;
    }

	public static void main(String[] args) {
	}

}
