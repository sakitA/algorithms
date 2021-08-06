package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 01.08.21.
 * algorithms
 */
public class DSLinkedList {
    public static void main(String[] args) {
        DSLinkedList dsl = new DSLinkedList();
//        System.out.println(dsl.partition(ObjectFactory.createLinkedList(new int[]{2,1}),2));
        ListNode l3 = new ListNode(3);
        ListNode l1 = new ListNode(1, new ListNode(2, l3));
        l3.next = new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, l3))));
        dsl.findLoopBeginning(l1);
    }
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;
        ListNode headStart = null;
        ListNode headEnd = null;
        ListNode tailStart = null;
        ListNode tailEnd = null;

        while(head!=null){
            ListNode ln = head.next;
            if(head.val<x){
                if(headStart==null){
                    headStart = head;
                    headEnd = headStart;
                }else{
                    headEnd.next = head;
                    headEnd = head;
                }
            }else{
                if(tailStart==null){
                    tailStart = head;
                    tailEnd = tailStart;
                }else{
                    tailEnd.next = head;
                    tailEnd = head;
                }
            }
            head = ln;
        }
        if(headStart==null)
            return tailStart;
        if(tailEnd!=null)
            tailEnd.next = null;
        headEnd.next = tailStart;
        return headStart;
    }

    ListNode findLoopBeginning(ListNode head){
        ListNode slow = head;
        ListNode faster = head;

        while(faster!=null && faster.next!=null){
            slow = slow.next;
            faster = faster.next.next;
            if(faster==slow)break;
        }

        if(faster==null || faster.next==null)
            return null;

        slow = head;
        while(slow!=faster){
            slow = slow.next;
            faster = faster.next;
        }

        return faster;
    }
}
