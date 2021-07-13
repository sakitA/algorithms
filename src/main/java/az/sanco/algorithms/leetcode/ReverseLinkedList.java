package az.sanco.algorithms.leetcode;

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
}
