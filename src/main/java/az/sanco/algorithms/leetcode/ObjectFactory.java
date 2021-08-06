package az.sanco.algorithms.leetcode;

import java.util.ArrayDeque;
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

    public static TreeNode createBinaryTree(List<Integer> elements){
        if(elements==null || elements.isEmpty()) return null;
        TreeNode root = new TreeNode(elements.get(0));
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int index = 1;
        while (index<elements.size() && !queue.isEmpty()){
            TreeNode tn = queue.poll();
            Integer val = elements.get(index++);

            if(val!=null){
                tn.left = new TreeNode(val);
                queue.add(tn.left);
            }

            if(index<elements.size()) {
                val = elements.get(index++);

                if (val != null) {
                    tn.right = new TreeNode(val);
                    queue.add(tn.right);
                }
            }
        }
        return root;
    }
    public static Node2 createNodeBinaryTree(List<Integer> elements){
        if(elements==null || elements.isEmpty()) return null;
        Node2 root = new Node2(elements.get(0));
        ArrayDeque<Node2> queue = new ArrayDeque<>();
        queue.add(root);
        int index = 1;
        while (index<elements.size() && !queue.isEmpty()){
            Node2 tn = queue.poll();
            Integer val = elements.get(index++);

            if(val!=null){
                tn.left = new Node2(val);
                queue.add(tn.left);
            }

            if(index<elements.size()) {
                val = elements.get(index++);

                if (val != null) {
                    tn.right = new Node2(val);
                    queue.add(tn.right);
                }
            }
        }
        return root;
    }

    public static String printTree(TreeNode root){
        StringBuilder sb = new StringBuilder();
        String ans = "";
        if (root != null) {
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            ArrayDeque<TreeNode> process = new ArrayDeque<>();
            process.add(root);
            while (!process.isEmpty()){
                TreeNode tn = process.poll();
                queue.add(tn);
                if(tn.left!=null) {
                    process.add(tn.left);
                } else
                    queue.add(new TreeNode(Integer.MIN_VALUE));
                if(tn.right!=null) {
                    process.add(tn.right);
                }else
                    queue.add(new TreeNode(Integer.MIN_VALUE));
            }

            while(!queue.isEmpty()){
                TreeNode tn = queue.poll();
                sb.append(",").append(tn.val==Integer.MIN_VALUE? "null":tn.val);
            }

            ans = sb.substring(1);
            if(ans.endsWith(",null,null"))
                ans = ans.substring(0,ans.length()-",null,null".length());
        }

        return "["+ans+"]";
    }
    public static String printNodeTree(Node2 root){
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            ArrayDeque<Node2> queue = new ArrayDeque<>();
            queue.add(root);
            sb.append(root.val);
            while (!queue.isEmpty()){
                Node2 tn = queue.poll();
                if(tn.left!=null) {
                    queue.add(tn.left);
                    sb.append(",").append(tn.left.val);
                } else
                    sb.append(", null");
                if(tn.right!=null) {
                    queue.add(tn.right);
                    sb.append(",").append(tn.right.val);
                }else
                    sb.append(", null");
            }
        }

        return "["+sb.toString()+"]";
    }
}
