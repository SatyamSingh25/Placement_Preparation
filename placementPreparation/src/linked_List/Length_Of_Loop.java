package linked_List;

/*problem link : https://practice.geeksforgeeks.org/problems/find-length-of-loop/1/?track=amazon-linkedlists&batchId=192#
 * Difficulty : Easy
 * time complexity : O(n)
 * Auxiliary space : O(1)
 */

public class Length_Of_Loop {

	class Node{
		int data;
		Node next;
		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
	
	public static int countNum(Node startLoop){
        Node temp = startLoop;
        int count = 1; 
        while(temp.next != startLoop){
            count++;
            temp = temp.next;
        }
        
        return count;
    }
    
    static int countNodesinLoop(Node head)
    {
        Node slow = head;
        Node fast = head.next;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return countNum(slow);
            }
        }
        return 0;
    }

}
