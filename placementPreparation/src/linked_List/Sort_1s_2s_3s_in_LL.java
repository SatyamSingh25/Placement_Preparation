package linked_List;
/*link : https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1/?track=amazon-linkedlists&batchId=192 
 * Difficulty : Easy or Medium both
 */
public class Sort_1s_2s_3s_in_LL {
	
	class Node{
		int data;
		Node next;
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	//sO(n) TC & O(1) Auxiliary Space
	
	static Node segregate(Node head){
		
        Node temp  = head;
        int count[] = {0,0,0};
        
        while(temp != null){
            count[temp.data]++;
            temp = temp.next;
        }
        
        temp = head;
        int i = 0;
        while(temp!= null){
            if(count[i]==0){
                i++;
            }
            else{
                temp.data = i;
                --count[i];
                temp =temp.next;
            }
            
        }        
        return head;
    }
}
