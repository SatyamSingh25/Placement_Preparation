package linked_List;

public class Linked_List_Cycle_II {

	class ListNode{
		int val ;
		ListNode next;
		public ListNode(int d) {
			this.val = d;
			this.next = null;
		}
	}
	
	public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            else if(temp.val ==Integer.MIN_VALUE) {
                return temp;
            }
            else{
                temp.val = Integer.MIN_VALUE;
                temp = temp.next;
            }
        }        
        return null;     
    }
}
