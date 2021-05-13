package linked_List;

/* Problem Link : https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/0/?track=amazon-linkedlists&batchId=192#
 * Difficulty : Easy 
 */

public class Nth_Node_From_Last {
	
	class Node{
		int data;
		Node next;
		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
	//O(n) TC & O(1) Auxiliary space
	int getNthFromLast(Node head, int n)
    {
    	if(head == null){
    	    return -1;
    	}
    	
    	Node temp = head;
    	int itr = n;
    	while(itr != 0){
    	    if(temp == null){
    	        return -1;
    	    }
    	    else{
    	        temp = temp.next;
    	        itr--;
    	    }
    	}
    	
    	Node that = head;
    	while(temp != null){
    	    temp = temp.next;
    	    that = that.next;
    	}
    	
    	return that.data;
    }

}
