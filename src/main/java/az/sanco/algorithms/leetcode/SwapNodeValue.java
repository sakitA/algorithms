package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 08.07.21.
 * algorithms
 */
public class SwapNodeValue {
    public static void main(String[] args) {
        SwapNodeValue snv = new SwapNodeValue();

        int[] arr = new int[]{1};

        ListNode org = ObjectFactory.createLinkedList(arr);
        ListNode chn = snv.swapNodes(org, 1);
        ObjectFactory.printLinkedList(chn);
    }
    public ListNode swapNodes(ListNode head, int k) {
        ListNode tmp = head;
        ListNode n1=null,n2=null;
        int count = 1;
        while((tmp=tmp.next)!=null){
            ++count;
        }
        tmp = head;
        for(int i=1;i<=count;i++){
            if(n1!=null && n2!=null) break;
            if(i==k){
                n1 = tmp;
            }
            if(i==count-k+1){
                n2 = tmp;
            }
            tmp = tmp.next;
        }
        swapNodeValue(n1, n2);
        return head;
    }
    public ListNode swapNodesMoreMemory(ListNode head, int k) {
        ListNode node1 = findKNode(head, k);
        ListNode node2 = findKNode(head, node1.val-k+1);
        swapNodeValue(node1.next, node2.next);
        return head;
    }

    private void swapNodeValue(ListNode node1, ListNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

    private ListNode findKNode(ListNode head, int k) {
        int count = 0;
        ListNode ln = head;
        ListNode kNode = new ListNode();
        while (ln!=null){
            ++count;
            if(count==k){
                kNode.next = ln;
            }
            ln = ln.next;
        }
        kNode.val = count;
        return kNode;
    }

}
