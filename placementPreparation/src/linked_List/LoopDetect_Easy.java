package linked_List;
/*Problem link : https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1/?track=amazon-linkedlists&batchId=192
 * Difficulty : Easy 
 */

public class LoopDetect_Easy {
	
	class Node{
		int data;
		Node next;
		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
	
	//O(n) TC & O(1) Auxiliary space
	public static boolean detectLoop(Node head){
        if(head == null){
            return false;
        }
        while(head != null){
            if(head.data == -1){
                return true;
            }
            else{
                head.data = -1;
                head = head.next;
            }
        }
        
        return false;
    }

}
