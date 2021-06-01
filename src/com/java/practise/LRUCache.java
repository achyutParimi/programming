import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
    Map<Integer, Node> hMap;
    int size;
    Node head, tail;
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public LRUCache(int capacity) {
        head = tail = null;
        size = capacity;
        hMap = new HashMap<>();
    }
    void removeNode(Node node){
        if(node.prev!=null){
            node.prev.next = node.next;
        }else{
            //handling first node
            head = node.next;
        }
        if(node.next!=null){
            node.next.prev = node.prev;
        }else{
            tail = node.prev;
        }
    }
    void addNode(Node node){
        //always add in the beginning
        node.prev = null;
        node.next = head;
        if(head != null){
            head.prev = node;
        }
        head = node;
        if(tail == null){
            tail = head;
        }
    }

    public int get(int key){
        Node node;
        if(hMap.containsKey(key)) {
            node = hMap.get(key);
            removeNode(node);
            addNode(node);
            return(node.value);
        }else
            return -1;
    }
    public void put(int key, int value){
        if(hMap.containsKey(key)){
            Node node = hMap.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        }else{
            if(hMap.size() == size){
                hMap.remove(tail.key);
                removeNode(tail);
            }
            Node node = new Node(key, value);
            hMap.put(key, node);
            addNode(node);
        }
    }

}
