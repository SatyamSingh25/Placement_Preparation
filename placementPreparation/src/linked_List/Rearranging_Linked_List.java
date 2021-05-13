package linked_List;
import java.io.*;
import java.util.*;

public class Rearranging_Linked_List {
	
	class Node{
		int data;
		Node next;
		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
	
	public static void rearrangeEvenOdd(Node head)
    { 
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        
        int i=0;
        Node temp = head;
        while(temp != null){
            if(i%2 == 0){
                even.add(temp.data);
                i++;
            }
            else{
                odd.add(temp.data);
                i++;
            }
        }
        
        temp = head;
        for(i=0; i<odd.size(); i++) {
        	temp.data = odd.get(i);
        	temp = temp.next;
        }
        
        for(i=0; i<even.size(); i++) {
        	temp.data = even.get(i);
        	temp = temp.next;
        }
        
        temp = head;
        while(temp != null) {
        	System.out.print(temp.data + " ");
        }
        System.out.println();
    }

}
