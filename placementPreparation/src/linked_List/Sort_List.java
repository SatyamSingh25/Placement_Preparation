package linked_List;
/**
 * @author Satyam Singh
 * -------------------------Linked List Sorting----------------------------
 * Problem link : https://leetcode.com/problems/sort-list/
 * Difficulty : Medium
 * @Merge_Sort
 */
public class Sort_List {
	class Node {
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	public Node sortList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		//finding mid
		Node temp= head;
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			temp = slow;
			slow =slow.next;
			fast = fast.next.next;
		}
		temp.next=null;
		
		Node left = sortList(head);
		Node right = sortList(slow);
		
		return merge(left, right);
	}
	Node merge(Node left, Node right) {
		Node res = new Node(0);
		Node start = res;
		while(left != null && right != null) {
			if(left.data < right.data) {
				res.next = left;
				left = left.next;
				res = res.next;
			}
			else {
				res.next = right;
				right = right.next;
				res = res.next;
			}
		}
		if(left != null) {
			res.next = left;
			left = left.next;
			res = res.next;
		}
		if(right != null) {
			res.next = right;
			right = right.next;
			res= res.next;
		}
		return start.next;
	}
	
}
