package az.sanco.algorithms.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by sanco on 12.07.21.
 * algorithms
 */
public class TestLeetCode {

    @Test
    public void mergeIntervals(){
        MergeIntervals mi = new MergeIntervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        int[][] answer = mi.merge(intervals);
        int[][] expected = {{1,6},{8,10},{15,18}};

        Assert.assertArrayEquals(expected, answer);

        intervals = new int[][]{{1, 4}, {4, 5}};
        answer = mi.merge(intervals);
        expected = new int[][]{{1,5}};

        Assert.assertArrayEquals(expected, answer);
    }

    @Test
    public void divideTwoIntegers(){
        DivideTwoIntegers dti = new DivideTwoIntegers();

        Assert.assertEquals(-10/3, dti.divide(-10, 3));
        Assert.assertEquals(-1/1, dti.divide(-1, 1));
        Assert.assertEquals(7/-3, dti.divide(7, -3));
        Assert.assertEquals(3/3, dti.divide(3, 3));
        Assert.assertEquals(32/2, dti.divide(32, 2));
        Assert.assertEquals(32/30, dti.divide(32, 30));
        Assert.assertEquals(32/-32, dti.divide(32, -32));
        Assert.assertEquals(2147483647, dti.divide(-2147483648, -1));
        Assert.assertEquals(-2147483648, dti.divide(-2147483648, 1));
//        Assert.assertEquals(1073741823, dti.divide(2147483647, 2));
        Assert.assertEquals(-1073741824, dti.divide(-2147483648, 2));
    }

    @Test
    public void isomorphicStrings(){
        IsomorphicStrings is = new IsomorphicStrings();
        Assert.assertTrue(is.isIsomorphic("egg", "add"));
        Assert.assertTrue(is.isIsomorphic("title", "paper"));
        Assert.assertTrue(is.isIsomorphic("paper", "title"));
        Assert.assertFalse(is.isIsomorphic("foo", "bar"));
        Assert.assertTrue(is.isIsomorphic("aaa", "bbb"));
        Assert.assertTrue(is.isIsomorphic("saaa", "mbbb"));
        Assert.assertFalse(is.isIsomorphic("badc", "baba"));
    }

    @Test
    public void squaresSortedArrays(){
        SquaresOfSortedArrays sosa = new SquaresOfSortedArrays();

        int[] arr = {-4,-1,0,3, 10};
        int[] exp = {0, 1, 9, 16, 100};

        Assert.assertArrayEquals(exp, sosa.sortedSquares(arr));

        arr = new int[]{-1};
        exp = new int[]{1};
        Assert.assertArrayEquals(exp, sosa.sortedSquares(arr));

        arr = new int[]{-5,-3,-2,-1};
        exp = new int[]{1,4,9,25};
        Assert.assertArrayEquals(exp, sosa.sortedSquares(arr));

        arr = new int[]{0,0};
        exp = new int[]{0,0};
        Assert.assertArrayEquals(exp, sosa.sortedSquares(arr));

        arr = new int[]{-1,-1};
        exp = new int[]{1,1};
        Assert.assertArrayEquals(exp, sosa.sortedSquares(arr));

        arr = new int[]{-1,1};
        exp = new int[]{1,1};
        Assert.assertArrayEquals(exp, sosa.sortedSquares(arr));

        arr = new int[]{-1,-1, 0};
        exp = new int[]{0, 1,1};
        Assert.assertArrayEquals(exp, sosa.sortedSquares(arr));
    }

    @Test
    public void duplicateZeros(){
        DuplicateZero dz = new DuplicateZero();

        int[] arr = {1,0,2,3,0,4,5,0};
        int[] exp = {1,0,0,2,3,0,0,4};

        dz.duplicateZeros(arr);
        Assert.assertArrayEquals(exp, arr);

        arr = new int[]{1,2,3};
        exp = new int[]{1,2,3};

        dz.duplicateZeros(arr);
        Assert.assertArrayEquals(exp, arr);

        arr = new int[]{0,0,0};
        exp = new int[]{0,0,0};

        dz.duplicateZeros(arr);
        Assert.assertArrayEquals(exp, arr);

        arr = new int[]{0,0};
        exp = new int[]{0,0};

        dz.duplicateZeros(arr);
        Assert.assertArrayEquals(exp, arr);

        arr = new int[]{0};
        exp = new int[]{0};

        dz.duplicateZeros(arr);
        Assert.assertArrayEquals(exp, arr);

        arr = new int[]{0,1};
        exp = new int[]{0,0};

        dz.duplicateZeros(arr);
        Assert.assertArrayEquals(exp, arr);

        arr = new int[]{1,0};
        exp = new int[]{1,0};

        dz.duplicateZeros(arr);
        Assert.assertArrayEquals(exp, arr);

        arr = new int[]{1,0,1};
        exp = new int[]{1,0,0};

        dz.duplicateZeros(arr);
        Assert.assertArrayEquals(exp, arr);

        arr = new int[]{8,5,6,0,0,0,0,7};
        exp = new int[]{8,5,6,0,0,0,0,0};

        dz.duplicateZeros(arr);
        Assert.assertArrayEquals(exp, arr);

        arr = new int[]{0, 1, 2, 3};
        exp = new int[]{0, 0, 1, 2};

        dz.duplicateZeros(arr);
        Assert.assertArrayEquals(exp, arr);

        arr = new int[]{9,9,9,4,8,0,0,3,7,2,0,0,0,0,9,1,0,0,1,1,0,5,6,3,1,6,0,0,2,3,4,7,0,3,9,3,6,5,8,9,1,1,3,2,0,0,7,3,3,0,5,7,0,8,1,9,6,3,0,8,8,8,8,0,0,5,0,0,0,3,7,7,7,7,5,1,0,0,8,0,0};
        exp = new int[]{9,9,9,4,8,0,0,0,0,3,7,2,0,0,0,0,0,0,0,0,9,1,0,0,0,0,1,1,0,0,5,6,3,1,6,0,0,0,0,2,3,4,7,0,0,3,9,3,6,5,8,9,1,1,3,2,0,0,0,0,7,3,3,0,0,5,7,0,0,8,1,9,6,3,0,0,8,8,8,8,0};

        dz.duplicateZeros(arr);
        Assert.assertArrayEquals(exp, arr);
    }

    @Test
    public void peakElement(){
        FindPeakElement fpe = new FindPeakElement();
        int[] arr = {1,2,3,1};
        int exp = 2;
        Assert.assertEquals(exp, fpe.findPeakElement(arr));
        arr = new int[]{1,2,1,3,5,6,4};
        int res = fpe.findPeakElement(arr);
        Assert.assertTrue(res==1 || res==5);

        arr = new int[]{0, 1};
        res = fpe.findPeakElement(arr);
        Assert.assertEquals(1, res);

        arr = new int[]{0};
        res = fpe.findPeakElement(arr);
        Assert.assertTrue(res==0);

        arr = new int[]{6, 5, 6};
        res = fpe.findPeakElement(arr);
        Assert.assertTrue(res==0 || res==2);

        arr = new int[]{1, 3, 1};
        res = fpe.findPeakElement(arr);
        Assert.assertTrue(res==1);
    }

    @Test
    public void preOrder(){
        TraverseTree tt = new TraverseTree();
        TreeNode root = ObjectFactory.createBinaryTree(Arrays.asList(1, null, 2, 3));

        List<Integer> result = tt.preOrderTraverse(new ArrayList<>(), root);
        List<Integer> expected = Arrays.asList(1,2,3);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList());

        result = tt.preOrderTraverse(new ArrayList<>(), root);
        expected = Arrays.asList();

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList(1));

        result = tt.preOrderTraverse(new ArrayList<>(), root);
        expected = Arrays.asList(1);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList(1,2));

        result = tt.preOrderTraverse(new ArrayList<>(), root);
        expected = Arrays.asList(1,2);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList(1,null,2));

        result = tt.preOrderTraverse(new ArrayList<>(), root);
        expected = Arrays.asList(1,2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void preOrderWithIterate(){
        TraverseTree tt = new TraverseTree();
        TreeNode root = ObjectFactory.createBinaryTree(Arrays.asList(1, null, 2, 3));

        List<Integer> result = tt.preOrderTraverse(root);
        List<Integer> expected = tt.preOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList());

        result = tt.preOrderTraverse(root);
        expected = tt.preOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList(1));

        result = tt.preOrderTraverse(root);
        expected = tt.preOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList(1,2));

        result = tt.preOrderTraverse(root);
        expected = tt.preOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList(1,null,2));

        result = tt.preOrderTraverse(root);
        expected = tt.preOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void inOrderWithIterate(){
        TraverseTree tt = new TraverseTree();
        TreeNode root = ObjectFactory.createBinaryTree(Arrays.asList(1, null, 2, 3));

        List<Integer> result = tt.inOrderTraverse(root);
        List<Integer> expected = tt.inOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList());

        result = tt.inOrderTraverse(root);
        expected = tt.inOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList(1));

        result = tt.inOrderTraverse(root);
        expected = tt.inOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList(1,2));

        result = tt.inOrderTraverse(root);
        expected = tt.inOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList(1,null,2));

        result = tt.inOrderTraverse(root);
        expected = tt.inOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void postOrderWithIterate(){
        TraverseTree tt = new TraverseTree();
        TreeNode root = ObjectFactory.createBinaryTree(Arrays.asList(1, null, 2, 3));

        List<Integer> result = tt.postOrderTraverse(root);
        List<Integer> expected = tt.postOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList());

        result = tt.postOrderTraverse(root);
        expected = tt.postOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList(1));

        result = tt.postOrderTraverse(root);
        expected = tt.postOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList(1,2));

        result = tt.postOrderTraverse(root);
        expected = tt.postOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);

        root = ObjectFactory.createBinaryTree(Arrays.asList(1,null,2));

        result = tt.postOrderTraverse(root);
        expected = tt.postOrderTraverse(new ArrayList<>(), root);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void pushDominoes(){
        PushDominoes pd = new PushDominoes();

//        System.out.println(pd.pushDominoes("R...L"));
        System.out.println(pd.pushDominoes("R.L.R"));
    }

    @Test
    public void partitionDisjoint(){
        Array a = new Array();

        int ans = a.partitionDisjoint(new int[]{5,0,3,8,6});
        int exp = 3;
        Assert.assertEquals(exp, ans);

        ans = a.partitionDisjoint(new int[]{1,1,1,0,6,12});
        exp = 4;
        Assert.assertEquals(exp, ans);

        ans = a.partitionDisjoint(new int[]{90,47,69,10,43,92,31,73,61,97});
        exp = 9;
        Assert.assertEquals(exp, ans);

    }

    @Test
    public void pruneTree(){
        TraverseTree tt = new TraverseTree();

        TreeNode root = tt.pruneTree(ObjectFactory.createBinaryTree(Arrays.asList(1,null,0,0,1)));
        String ans = ObjectFactory.printTree(root);
        String exp = "[1,null,0,null,1]";

        Assert.assertEquals(exp,ans);

        root = tt.pruneTree(ObjectFactory.createBinaryTree(Arrays.asList(1,0,1,0,0,0,1)));
        ans = ObjectFactory.printTree(root);
        exp = "[1,null,1,null,1]";

        Assert.assertEquals(exp,ans);

        root = tt.pruneTree(ObjectFactory.createBinaryTree(Arrays.asList(1,1,0,1,1,0,1,0)));
        ans = ObjectFactory.printTree(root);
        exp = "[1,1,0,1,1,null,1]";

        Assert.assertEquals(exp,ans);
    }

    @Test
    public void sortedArrayToBST(){
        TraverseTree tt = new TraverseTree();

        TreeNode ans = tt.sortedArrayToBST(new int[]{-93,-89,-85,-76,-56,-53,-20,-10,20,28,41,50,66,70,87,88,91,94});
    }

    @Test
    public void validBST(){
        TraverseTree tt = new TraverseTree();
        System.out.println(tt.isValidBST(ObjectFactory.createBinaryTree(Arrays.asList(5,1,4,null,null,3,6))));
    }

    @Test
    public void threeClosestSum(){
        RandomProblems rp = new RandomProblems();
        Random r = new Random();
        int len = 3+r.nextInt(998);
        int[] nums = new int[len];
        for(int i=0;i<len;i++){
            nums[i] = (r.nextInt()%2==0? 1:-1) *r.nextInt(1001);
        }

        int target = (r.nextInt()%2==0? 1:-1) *r.nextInt(10001);

        int ans = rp.threeSumClosest(nums.clone(), target);
        int exp = rp.threeSumClosestBF(nums, target);
        if(ans!=exp){
            System.out.println(nums);
            System.out.println(target);
        }
        Assert.assertEquals(exp, ans);
    }
}
