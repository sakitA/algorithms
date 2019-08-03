package az.sanco.algorithms.leetcode;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by sanco on 2019-08-03.
 * CodeForce
 */
public class TestMedianOfArray {
    private static MedianOfArray medianOfArray;

    @BeforeClass
    public static void init(){
        medianOfArray = new MedianOfArray();
    }

    @Test
    public void testCase1(){
        double output = medianOfArray.findMedianSortedArrays(new int[]{1,3}, new int[]{2});

        Assert.assertEquals(2.0, output,0);
    }

    @Test
    public void testCase2(){
        double output = medianOfArray.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});

        Assert.assertEquals(2.5, output,0);
    }

    @AfterClass
    public static void destroy(){
        medianOfArray = null;
    }
}
