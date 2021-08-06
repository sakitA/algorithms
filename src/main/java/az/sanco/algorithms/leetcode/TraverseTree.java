package az.sanco.algorithms.leetcode;

import java.util.*;

/**
 * Created by sanco on 15.07.21.
 * algorithms
 */
public class TraverseTree {
    public static void main(String[] args) {
        TraverseTree tt = new TraverseTree();
//        TreeNode tn = ObjectFactory.createBinaryTree(Arrays.asList(3,9,20,null,null,15,7));
//        TreeNode tn = ObjectFactory.createBinaryTree(Arrays.asList(1,2,2,3,4,4,3));
//        TreeNode tn = ObjectFactory.createBinaryTree(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,null,1));
//        TreeNode tn = ObjectFactory.createBinaryTree(Arrays.asList(1,-2,-3,1,3,-2,null,-1));
//        TreeNode tn = ObjectFactory.createBinaryTree(Arrays.asList(-2, null, -3));
//        TreeNode tn = ObjectFactory.createBinaryTree(Arrays.asList(1,2,null,3,null,4,null,5,null));

//        TreeNode tn = ObjectFactory.createBinaryTree(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4));
//        System.out.println(tt.lowestCommonAncestor2(tn, new TreeNode(6), new TreeNode(4)).val);
//        String codec = tt.serialize(ObjectFactory.createBinaryTree(Arrays.asList()));
//        System.out.println(codec);
//        System.out.println(ObjectFactory.printTree(tt.deserialize(codec)));

//        Node n = tt.connect2(ObjectFactory.createNodeBinaryTree(Arrays.asList(2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7)));
//        Node2 n = tt.connect2(ObjectFactory.createNodeBinaryTree(Arrays.asList(1,2,3,4,5,null,7)));
//        System.out.println(ObjectFactory.printNodeTree(n));
//        tt.generateTrees(3);
        tt.pathSum2(ObjectFactory.createBinaryTree(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,5,1)), 22);
        tt.pathSum2(ObjectFactory.createBinaryTree(Arrays.asList(-2,null,-3)), -5);
    }
    public List<Integer> preOrderTraverse(List<Integer> order, TreeNode root){
        if(root == null) return order;

        order.add(root.val);
        preOrderTraverse(order, root.left);
        preOrderTraverse(order, root.right);
        return order;
    }

    public List<Integer> inOrderTraverse(List<Integer> order, TreeNode root){
        if(root == null) return order;

        inOrderTraverse(order, root.left);
        order.add(root.val);
        inOrderTraverse(order, root.right);
        return order;
    }

    public List<Integer> postOrderTraverse(List<Integer> order, TreeNode root){
        if(root == null) return order;

        postOrderTraverse(order, root.left);
        postOrderTraverse(order, root.right);
        order.add(root.val);
        return order;
    }

    public List<Integer> preOrderTraverse(TreeNode root){
        List<Integer> order = new ArrayList<>();

        if(root==null) return order;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        stack.push(root);
        do {
            current = stack.pop();
            order.add(current.val);
            if(current.right!=null)
                stack.push(current.right);
            if(current.left!=null)
                stack.push(current.left);
        }while (!stack.isEmpty());


        return order;
    }

    public List<Integer> inOrderTraverse(TreeNode root){
        List<Integer> order = new ArrayList<>();
        if(root==null) return order;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while(currentNode!=null || stack.size()>0){
            while (currentNode!=null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            order.add(currentNode.val);
            currentNode = currentNode.right;
        }


        return order;
    }

    public List<Integer> postOrderTraverse(TreeNode root){
        List<Integer> order = new ArrayList<>();
        if(root==null) return order;

        Stack<TreeNode> stack = new Stack<>();

        while(true){
            while (root!=null){
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            if(stack.isEmpty()) return order;
            root = stack.pop();
            if(!stack.isEmpty() && stack.peek()==root) root = root.right;
            else {
                order.add(root.val);
                root = null;
            }
        }
    }

    public List<List<Integer>> bfs(TreeNode root){
        ArrayDeque<LevelTreeNode> queue = new ArrayDeque<>();
        queue.add(new LevelTreeNode(1, root));
        Map<Integer, List<Integer>> map = new HashMap<>();
        while (!queue.isEmpty()){
            LevelTreeNode ltn = queue.poll();
            if(ltn.node.left!=null)
                queue.add(new LevelTreeNode(ltn.level+1, ltn.node.left));
            if(ltn.node.right!=null)
                queue.add(new LevelTreeNode(ltn.level+1, ltn.node.right));
            map.computeIfAbsent(ltn.level, e->new ArrayList<>()).add(ltn.node.val);
        }

        return new ArrayList<>(map.values());
    }

    public int answer = 0;
    public int maxDepth(TreeNode root) {
        maxDepth(root, 1);
        return answer;
    }

    public void maxDepth(TreeNode root, int depth){
        if(root==null) return;
        if(root.left==null && root.right==null)
            answer = Math.max(answer, depth);
        maxDepth(root.left, depth+1);
        maxDepth(root.right, depth+1);
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        if((left==null && right!=null) || (left!=null && right==null)) return false;
        if(left.val!= right.val)return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(targetSum-root.val==0) return root.left==null && root.right==null;
        boolean left = hasPathSum(root.left, targetSum-root.val);
        boolean right = hasPathSum(root.right, targetSum-root.val);
        return  left || right;
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int sum){
        if(root==null) return targetSum==sum;

        boolean left = hasPathSum(root.left, targetSum, sum+root.val);
        boolean right = hasPathSum(root.right, targetSum, sum+root.val);
        return  left || right;
    }

    public TreeNode makeTreeFromInAndPost(int[] inorder, int[] postorder, int iStart, int iEnd, int pStart, int pEnd){
        if(isNotValid(inorder.length, iStart, iEnd)||isNotValid(postorder.length, pStart, pEnd)) return null;
        if(iEnd-iStart==1) return new TreeNode(inorder[iStart]);

        int rootIndex = findIndex(inorder, postorder[pEnd-1], iStart, iEnd);
        if(rootIndex==-1) return null;
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = makeTreeFromInAndPost(inorder, postorder, iStart, rootIndex, pStart, pStart+rootIndex-iStart);
        root.right = makeTreeFromInAndPost(inorder, postorder, rootIndex+1, iEnd, pStart+rootIndex-iStart, pEnd-1);
        return root;
    }

    public TreeNode makeTreeFromInAndPre(int[] inorder, int[] preOrder, int iStart, int iEnd, int pStart, int pEnd){
        if(isNotValid(inorder.length, iStart, iEnd)||isNotValid(preOrder.length, pStart, pEnd)) return null;
        if(iEnd-iStart==1) return new TreeNode(inorder[iStart]);

        int rootIndex = findIndex(inorder, preOrder[pStart], iStart, iEnd);
        if(rootIndex==-1) return null;
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = makeTreeFromInAndPost(inorder, preOrder, iStart, rootIndex, pStart+1, pStart+1+rootIndex-iStart);
        root.right = makeTreeFromInAndPost(inorder, preOrder, rootIndex+1, iEnd, pStart+1+rootIndex-iStart, pEnd);
        return root;
    }

    private boolean isNotValid(int length, int start, int end) {
        return start < 0 || end <= 0 || end > length || start>=length || start==end;
    }

    private int findIndex(int[] inorder, int val, int start, int end) {
        int i=start, j=end-1;
        while(i<=j){
            if(inorder[i]==val) return i;
            if(inorder[j]==val) return j;
            ++i;
            --j;
        }
        return -1;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q) return root;
        else if((p.val<root.val && root.val<q.val) || (q.val<root.val && root.val<p.val)) return root;
        else if(p.val<root.val && q.val<root.val) return lowestCommonAncestor(root.left, p, q);
        else if(p.val> root.val && q.val>root.val) return lowestCommonAncestor(root.right, p, q);
        return p.val == root.val? p:q;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode tn = queue.poll();
            sb.append(tn.val);
            if(tn.left==null)
                sb.append("#LN");
            else
                sb.append("#L").append(tn.left.val);
            if(tn.right==null)
                sb.append("#RN");
            else
                sb.append("#R").append(tn.right.val);
            sb.append(";");
            if(tn.left!=null) queue.add(tn.left);
            if(tn.right!=null) queue.add(tn.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] bTree = data.split(";");
        if(bTree.length == 0) return null;
        String[] nodes = bTree[0].split("#");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()){
            TreeNode tn = queue.poll();
            tn.left = nodes[1].equals("LN") ? null : new TreeNode(Integer.parseInt(nodes[1].substring(1)));
            tn.right = nodes[2].equals("RN") ? null : new TreeNode(Integer.parseInt(nodes[2].substring(1)));
            if(tn.left!=null) queue.add(tn.left);
            if(tn.right!=null) queue.add(tn.right);
            if(index<bTree.length)
                nodes = bTree[index++].split("#");
            else break;
        }
        return root;
    }

    public Node2 connect(Node2 root) {
        if(root==null) return null;
        ArrayDeque<Node2> queue = new ArrayDeque<>();
        root.next = null;
        int level = 1;
        int count = 0;
        Node2 pre = null;
        queue.add(root);

        while(!queue.isEmpty()){
            Node2 n = queue.poll();
            if(n.left!=null){
                queue.add(n.left);
                queue.add(n.right);

                n.left.next = n.right;
                if(pre==null){
                    pre = n.right;
                }else{
                    pre.next = n.left;
                    pre = n.right;
                }
                count+=2;
                if(count==(int)Math.pow(2,level)){
                    ++level;
                    pre = null;
                    count = 0;
                }else{
                    pre = n.right;
                }
            }
        }
        return root;
    }

    public Node2 connect2(Node2 root){
        if(root==null) return null;
        Node2 tmp1 = root, tmp2=null;
        while(tmp1!=null){
            tmp2 = tmp1;
            while(tmp2!=null){
                if(tmp2.left!=null){
                    tmp2.left.next = tmp2.right!=null? tmp2.right : findNextNode(tmp2.next);
                }
                if(tmp2.right!=null){
                    tmp2.right.next = findNextNode(tmp2.next);
                }
                tmp2 = tmp2.next;
            }

            tmp1 = tmp1.left!=null? tmp1.left : tmp1.right!=null? tmp1.right:findNextNode(tmp1.next);
        }

        return root;
    }
    private Node2 findNextNode(Node2 next) {
        if(next==null) return null;
        return next.left!=null? next.left : next.right!=null? next.right:findNextNode(next.next);
    }
    // private Map<Node, Boolean> visited = new HashMap<>();

    private void connect(Node2 parent, Node2 node, Node2 next) {
        if(node==null || node.next!=null) return;

        node.next = next!=null? next : findNextNode(parent.next);
        connect(node, node.left, node.right);
        connect(node, node.right, node.next.left);
    }



    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q || root.val==p.val || root.val==q.val) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }


    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return null;

        if(root.left!=null)
            root.left = pruneTree(root.left);
        if(root.right!=null)
            root.right = pruneTree(root.right);

        return root.left==null && root.right==null && root.val==0? null:root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return insertNode(nums,null,0,nums.length);
    }

    public TreeNode insertNode(int[] nums, TreeNode root, int start, int end){
        if(start==end) return root;
        else {
            int mid = (start + end) / 2;

            root = new TreeNode(nums[mid]);
            root.left = insertNode(nums, root.left, start, mid);
            root.right =insertNode(nums, root.right, mid + 1, end);
            return root;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    public boolean isValidBST(TreeNode root, Integer lower, Integer higher){
        if(root==null) return true;

        if((lower!=null && root.val<=lower) || (higher!=null && root.val>=higher)) return false;

        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, higher);
    }
    class LevelTreeNode{
        int level;
        TreeNode node;

        public LevelTreeNode(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }


    public List<TreeNode> generateTrees(int n) {
        return generateTree(1, n);
    }

    public int catalanNumber(int n){
        int[] catalan = new int[n+1];
        catalan[0]=catalan[1]=1;
        if(n<=1) return catalan[n];
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                catalan[i]+=catalan[j]*catalan[i-j-1];
            }
        }
        return catalan[n];
    }

    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();

        if(start>end){
            res.add(null);
            return res;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftSide = generateTree(start, i-1);
            List<TreeNode> rightSide = generateTree(i+1, end);

            for(TreeNode ltn: leftSide){
                for(TreeNode rtn: rightSide){
                    TreeNode root = new TreeNode(i);
                    root.left = ltn;
                    root.right = rtn;
                    res.add(root);
                }
            }
        }
        return res;
    }

    List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return result;

        findPath(new ArrayList<>(), root, targetSum);
        return result;
    }

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        if(root==null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        if(targetSum==root.val && isLeaf(root)){
            LinkedList<Integer> list = new LinkedList<>();
            list.add(root.val);
            result.add(list);
            return result;
        }
        if(root.left!=null){
            for(List<Integer> list: pathSum2(root.left, targetSum-root.val)){
                ((LinkedList<Integer>)list).addFirst(root.val);
                result.add(list);
            }
        }
        if(root.right!=null){
            for(List<Integer> list: pathSum2(root.right, targetSum-root.val)){
                ((LinkedList<Integer>)list).addFirst(root.val);
                result.add(list);
            }
        }
        return result;
    }

    private void findPath(List<Integer> path, TreeNode root, int targetSum){
        if(targetSum==root.val && isLeaf(root)){
            path.add(root.val);
            result.add(path);
            return;
        }

        if(root.left!=null) {
            List<Integer> left = new ArrayList<>(path);
            left.add(root.val);
            findPath(left, root.left, targetSum-root.val);
        }
        if(root.right!=null) {
            List<Integer> right = new ArrayList<>(path);
            right.add(root.val);
            findPath(right, root.right, targetSum - root.val);
        }
    }


    public boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }
}
