package az.sanco.algorithms.leetcode;

import java.util.ArrayDeque;

/**
 * Created by sanco on 08.07.21.
 * algorithms
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = ObjectFactory.createLinkedList(new int[]{1,2,3,4,5});

        ReverseLinkedList rn = new ReverseLinkedList();

        ObjectFactory.printLinkedList(rn.reverse(head));
    }

    public ListNode reverse(ListNode head){
        ListNode ln = new ListNode(head.val, null);
        ListNode tmp = head.next;
        while (tmp!=null){
            ln = new ListNode(tmp.val, ln);
            tmp = tmp.next;
        }
        return ln;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ListNode newHead = null;
        ListNode tmp = null;

        while (head!=null){
            queue.add(head.val);
            if(queue.size()==k){
                while (!queue.isEmpty()) {
                    if(newHead==null){
                        tmp = new ListNode(queue.pollLast());
                        newHead = tmp;
                    }else{
                        tmp.next = new ListNode(queue.pollLast());
                        tmp = tmp.next;
                    }
                }
            }
            head = head.next;
        }

        while (!queue.isEmpty()){
            tmp.next = new ListNode(queue.poll());
            tmp = tmp.next;
        }
        return newHead;
    }
}
