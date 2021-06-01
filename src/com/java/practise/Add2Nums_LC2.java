import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Add2Nums_LC2 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val = val;};
        ListNode(int val, ListNode next){ this.val = val; this.next = next;}
    }
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
    /*
    Solution: Take two stacks and pop and insert in a queue and insert in a linkedlist
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Queue<Integer> res = new LinkedList<Integer>();

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
        int sum = 0;
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()){
                sum = sum + s1.pop();
            }
            if(!s2.isEmpty()){
                sum = sum + s2.pop();
            }
            sum += carry;
            carry = sum/10;

            res.add(sum%10);
            sum = 0;
        }
        if(carry > 0)
            res.add(carry);
        return resultantList(res);
    }

    public ListNode resultantList(Queue<Integer> result){
        ListNode head = null;
        if(result.isEmpty()) return null;

        if(!result.isEmpty()){
            head = new ListNode(result.poll());
        }

        ListNode tNode = head;
        while(!result.isEmpty()){
            tNode.next = new ListNode(result.poll());
            tNode = tNode.next;
        }

        return head;
    }

}
