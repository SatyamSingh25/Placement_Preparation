package linked_List;
/*Problem link : https://leetcode.com/problems/linked-list-cycle/
 * Difficulty : Easy 
 */
public class HasCycle {
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int d){
			this.val =d;
			this.next = null;
		}
	}
	
    public boolean hasCycle(ListNode head) {
        
        if(head==null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != fast){
            if(fast ==  null || fast.next == null){
                return false;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
