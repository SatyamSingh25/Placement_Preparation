package heap;
import java.util.*;
/**
 * @author Satyam Singh
 * ----------------------------LEETCODE 23--------------------------------------------
 * Problem link : https://leetcode.com/problems/merge-k-sorted-lists/
 * Decription : You are given an array of k linked-lists lists, each linked-list is sorted
 *              in ascending order.
                Merge all the linked-lists into one sorted linked-list and return it.
                
   Input : lists = [[1,4,5],[1,3,4],[2,6]]
   Output: [1,1,2,3,4,4,5,6]
   
   Explanation: The linked-lists are:
   [
     1->4->5,
     1->3->4,
     2->6
   ]

   merging them into one sorted list: 1->1->2->3->4->4->5->6
   
   Difficulty : Hard
 */
public class Merge_K_LL_in_sorted_Order {
	//ListNode 
	class ListNode{
		int val;
		ListNode next;
		public ListNode() {}
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	//main method
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> arr = new ArrayList<Integer>();

        //iterating all over list lists.
        for(ListNode curr: lists){
            while(curr != null){
                arr.add(curr.val);
                curr = curr.next;
            }
        }
        Collections.sort(arr); 

        //creating result list
        ListNode head = new ListNode(0);
        ListNode iter = head;

        //entering values into list 
        for(int i: arr){
            ListNode temp = new ListNode(i);
            iter.next = temp;
            iter = iter.next;
        }
        iter.next = null;
        
        return head.next;
    }
}
