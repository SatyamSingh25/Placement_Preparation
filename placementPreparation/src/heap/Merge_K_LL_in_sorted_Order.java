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
	
	//Optimal Approach
	public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        return mergeKListsHelper(lists, 0, lists.length-1);
    }
    public ListNode mergeKListsHelper(ListNode[] lists, int start, int end){
        if(start == end)
            return lists[start];

        int mid = start + (end - start)/2;
        ListNode l1 = mergeKListsHelper(lists, start, mid);
        ListNode l2 = mergeKListsHelper(lists, mid+1, end);

        return mergeTwoList(l1, l2);
    }
    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null)
            return l1 == null? l2 : l1;

        ListNode newList = new ListNode(0);
        ListNode temp = newList;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }
            else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        temp.next = l1 == null ? l2 : l1;
        return newList.next;
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
