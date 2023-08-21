package Design;
import java.util.*;
public class LRUcache {
	
    Node head = new Node(0,0), tail = new Node(0,0);
    Map<Integer, Node> map = new HashMap<>();
    int size;

    public LRUcache(int capacity) {
        this.size = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);

            remove(node);
            insert(node);
            return node.value;
        }
        return -1;                
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == size){
            remove(tail.prev); //least recently used node
        }
        insert(new Node(key, value)); //insert after the head of DLL
    }

    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //insert node at first after head
    public void insert(Node node){
        map.put(node.key, node);

        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;        
    }

    //Node class
    class Node{
        int key, value;
        Node next, prev;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */