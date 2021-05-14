package linked_List;

/*problem link : https://leetcode.com/problems/add-two-numbers-ii/
 * Difficulty : Medium
 * 
 * TC : O(max(l1.size, l2.size))
 * Auxiliary space : O(l1.size + l2.size)
 */

public class Leetcode_445_Add_Two_Number_II {
	//node
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
	//getting size of linked list
	public int size(ListNode head){
        int s = 0;
        ListNode temp = head;
        while(temp != null){
            s++;
            temp = temp.next;
        }
        return s;
    }
	//reversing the linked list
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;            
        }
        
        return prev;
    }
    //solution
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = size(l1);
        int size2 = size(l2);
        
        if(size1<size2){
            int def = size2-size1;
            while(def != 0){
                ListNode newNode = new ListNode(0,l1);
                l1 = newNode;
                def--;
            }
            l1 = reverse(l1);
            l2 = reverse(l2);
            int carry =0;
            ListNode newList = new ListNode(0,null);
            ListNode resultNode = newList;
            while(l1 != null || l2 != null || carry != 0){
                if(l1 != null){
                    carry += l1.val;
                    l1 = l1.next;
                }
                
                if(l2 != null){
                    carry += l2.val;
                    l2 = l2.next;
                }
                
                newList.next = new ListNode(carry%10, null);
                carry /= 10;
                newList = newList.next;
            }
            return reverse(resultNode.next);
        }
        else if(size1>size2){
            int def = size1-size2;
            while(def != 0){
                ListNode newNode = new ListNode(0,l2);
                l2 = newNode;
                def--;
            }
            l1 = reverse(l1);
            l2 = reverse(l2);
            int carry =0;
            ListNode newList = new ListNode(0,null);
            ListNode resultNode = newList;
            while(l1 != null || l2 != null || carry != 0){
                if(l1 != null){
                    carry += l1.val;
                    l1 = l1.next;
                }
                
                if(l2 != null){
                    carry += l2.val;
                    l2 = l2.next;
                }
                
                newList.next = new ListNode(carry%10, null);
                carry /= 10;
                newList = newList.next;
            }
            return reverse(resultNode.next);
        }
        
        int def = size1-size2;
        while(def != 0){
            ListNode newNode = new ListNode(0,l2);
            l2 = newNode;
            def--;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry =0;
        ListNode newList = new ListNode(0,null);
        ListNode resultNode = newList;
        while(l1 != null || l2 != null || carry != 0){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
                
            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }
            
            newList.next = new ListNode(carry%10, null);
            carry /= 10;
            newList = newList.next;
        }
        return reverse(resultNode.next);
    }
}
