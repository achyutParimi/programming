
public class SingleLinkedList {
    public class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
        void addAtBegin(Node head, int val){
            if( head == null){
                //LinkedList does not exist
                //create a Node and return it as head
                Node nNode = new Node(val);
                head = nNode;
            }
            Node nNode = new Node(val);
            nNode.next = head;
            head = nNode;
        }
        void addNode(Node head, int val){
            //add at the begin

        }

    }

}
