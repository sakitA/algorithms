package az.sanco.algorithms.leetcode;

import java.util.Objects;

/**
 * Created by sanco on 2019-06-30.
 * CodeForce
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calc(new ListNode(0), l1, l2, 0);
    }

    public ListNode calc(ListNode res, ListNode ln1, ListNode ln2, int remain) {
        if (ln1 == null && ln2 == null)
            if(remain!=0)
                return new ListNode(remain);
            else
                return null;
        else {
            int num1 = ln1 == null ? 0 : ln1.val;
            int num2 = ln2 == null ? 0 : ln2.val;
            int sum = num1 + num2 + remain;
            res.val = sum % 10;
            res.next = calc(new ListNode(0), ln1 == null ? null : ln1.next, ln2 == null ? null : ln2.next, sum / 10);

            return res;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ListNode)) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val &&
                    Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
