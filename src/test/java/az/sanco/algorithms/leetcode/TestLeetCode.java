package az.sanco.algorithms.leetcode;

import org.junit.Assert;
import org.junit.Test;

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
}
