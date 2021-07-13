package az.sanco.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanco on 08.07.21.
 * algorithms
 */
public class ObjectFactory {
    public static ListNode createLinkedList(int[] arr){
        ListNode head = null;
        ListNode tail = null;
        for(int i:arr){
            if(head==null){
                head = new ListNode(i);
                tail = head;
            }else{
                tail.next = new ListNode(i);
                tail = tail.next;
            }
        }

        return head;
    }

    public static void printLinkedList(ListNode listNode){
        List<Integer> list = new ArrayList<>();

        while (listNode!=null){
            list.add(listNode.val);
            listNode = listNode.next;
        }

        System.out.println(list);
    }
}
