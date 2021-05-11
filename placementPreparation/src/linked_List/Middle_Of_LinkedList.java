package linked_List;

// Question link : https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
 
public class Middle_Of_LinkedList {
	
//	public static Node head;
	
//	class Node{
//		int data;
//		Node next;
//		Node(int d){
//			data = d;
//			next=null;
//		}
//	}
	//finding the middle in this function
	public static void getMiddle(Node head)
    {
        Node slowPtr = head;
        Node fastPtr = head;
        
        if(head!=null){
            while(fastPtr !=null && fastPtr.next!=null){
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }
        }
        
        System.out.println(slowPtr.data);
    }
	
//	public void addNode(int data) {
//		Node newNode = new Node(data);
//		newNode.next=head;
//		head = newNode;
//	}
//	
//	public static void main(String[] args) {
//		Middle_Of_LinkedList list = new Middle_Of_LinkedList();
//		for(int i=5; i<0; i++) {
//			list.addNode(i);
//		}
//		list.getMiddle(head);		
//	}

}
