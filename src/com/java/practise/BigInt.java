import java.util.Stack;

public class BigInt {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){ this.val = val;}
        ListNode(int val, ListNode node){this.val = val; this.next = node;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        ListNode t1 = l1;
        while(t1 != null){
            s1.push(t1.val);
            t1 = t1.next;
        }

        ListNode t2 = l2;
        while(t2 != null){
            s2.push(t2.val);
            t2 = t2.next;
        }

        Stack<Integer> result = new Stack<Integer>();
        int sum = 0;
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()){
                sum = sum+s1.pop();
                //carry = sum/10;
                //result.push(sum%10);
            }
            if(!s2.isEmpty()){
                sum = sum + s2.pop();
                //carry = sum/10;
                //result.push(sum%10);
            }
            sum = sum+carry;
            carry = sum/10;
            result.push(sum%10);
            sum = 0;
        }
        if(carry > 0)
            result.push(carry);

        return resultList(result);
    }
    ListNode resultList(Stack<Integer> result){
        ListNode head = null;
        ListNode nNode = null;
        if(!result.isEmpty()){
            nNode = new ListNode(result.pop());
            head = nNode;
        }
        //pop from the stack and add to the headNode
        while(!result.isEmpty()){
            ListNode temp = new ListNode(result.pop());
            nNode.next = temp;
            nNode = nNode.next;
        }

        return head;
    }
}
