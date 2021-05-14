package linked_List;
/*problem link : https://leetcode.com/problems/add-two-numbers/
 * Difficulty : Easy
 * 
 * TC = O(max(l1.size ,l2.size))
 * Auxiliary  space = O(l1.size + l2.size)
 */
public class LeetCode_2_add_two_number_in_LL {
	
	public class ListNode{
		int val;
		ListNode next;
		
		public ListNode() {}
		
		public ListNode(int d) {
			this.val = d;
			this.next = null;
		}
		
		public ListNode(int d, ListNode next) {
			this.val = d;
			this.next = next;
		}
	}
	//solution
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0, null);
        ListNode res = newList;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            if(l1 != null){
                carry = carry + l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                carry = carry + l2.val;
                l2 = l2.next;
            }
            
            newList.next =new ListNode(carry%10, null);
            carry = carry/10;
            newList = newList.next;
        }        
        return res.next;        
    }

}
