package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 08.07.21.
 * algorithms
 */
public class RemoveNthNode {
    public static void main(String[] args) {
        ListNode head = ObjectFactory.createLinkedList(new int[]{1,2,3,4,5});
        RemoveNthNode rn = new RemoveNthNode();

        ObjectFactory.printLinkedList(rn.removeNthFromEnd(head, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = findNodeCount(head);

        if(n==1 && count==1)
            return null;
        else if(n==count){
            return head.next;
        }

        ListNode curr = head;
        int cnt = 0;
        while (curr.next!=null){
            ++cnt;
            if(cnt==(count-n)){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }

        return head;
    }

    private int findNodeCount(ListNode head) {
        int count = 1;
        ListNode ln = head.next;
        while (ln!=null){
            ++count;
            ln = ln.next;
        }

        return count;
    }
}
