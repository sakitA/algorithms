package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 09.07.21.
 * algorithms
 */
public class MergeTwoSortedList {
    public static void main(String[] args) {
        MergeTwoSortedList mtsl = new MergeTwoSortedList();

        int[] nums1 = new int[]{4};
        int[] nums2 = new int[]{1,2,3,5,6};
//        mtsl.merge(nums1, 1, nums2, nums2.length);
//
//        for (int j : nums1) {
//            System.out.print(j + ",");
//        }
        int[][] arr = new int[][]{{1,4,5},{1,3,4},{2,6}};
        ListNode[] nodes = new ListNode[arr.length];
        for(int i=0;i<arr.length;i++){
            nodes[i] = ObjectFactory.createLinkedList(arr[i]);
        }

        ObjectFactory.printLinkedList(mtsl.mergeKLists(nodes));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
        }else if(n>0) {
            if (nums1[m-1] <= nums2[0]) {
               System.arraycopy(nums2, 0, nums1, m, n);
            }else if(nums1[0]>=nums2[n-1]){
                System.arraycopy(nums1,0, nums1, m, m);
                System.arraycopy(nums2,0, nums1, 0, n);
            }else{
                int[] tmp = new int[m];
                System.arraycopy(nums1, 0, tmp, 0, m);

                int i=0,j=0, index=0;
                while (i<m && j<n){
                    while (i<m && j<n && tmp[i]<=nums2[j]){
                        nums1[index++] = tmp[i];
                        ++i;
                    }

                    while (i<m && j<n && tmp[i]>nums2[j]){
                        nums1[index++] = nums2[j];
                        ++j;
                    }
                }
                if (m - i >= 0) System.arraycopy(tmp, i, nums1, index, m - i);

                if (n - j >= 0) System.arraycopy(nums2, j, nums1, index+m-i, n - j);
            }
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode last = head;
        while (l1!=null && l2!=null){
            if(l1.val<l2.val) {
                last = addNode(last, l1.val);
                l1 = l1.next;
            }else {
                last = addNode(last, l2.val);
                l2 = l2.next;
            }
        }
        while (l1!=null){
            last = addNode(last, l1.val);
            l1 = l1.next;
        }

        while (l2!=null){
            last = addNode(last, l2.val);
            l2 = l2.next;
        }
        return head.next;
    }

    public ListNode addNode(ListNode curr, int val){
        curr.next = new ListNode(val);
        return curr.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        return mergeKLists(lists, 0, lists.length-1);
    }

    private ListNode mergeKLists(ListNode[] lists, int begin, int end) {
        if(begin>=end)
            return lists[end];
        else if(end-begin==1)
            return mergeTwoLists(lists[begin], lists[end]);
        else {
            int mid = (begin+end)>>>1;
            return mergeTwoLists(mergeKLists(lists, begin, mid), mergeKLists(lists, mid+1, end));
        }
    }
}
