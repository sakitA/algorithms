package az.sanco.algorithms.leetcode;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by sanco on 2019-08-03.
 * CodeForce
 */
public class TestReverseInteger {
    private static ReverseInteger reverseInteger;

    @BeforeClass
    public static void init(){
        reverseInteger = new ReverseInteger();
    }

    @Test
    public void testCase1(){
        int input = 123;

        int output = reverseInteger.reverse(input);

        Assert.assertEquals(321, output);
    }

    @Test
    public void testCase2(){
        int input = -123;

        int output = reverseInteger.reverse(input);

        Assert.assertEquals(-321, output);
    }

    @Test
    public void testCase3(){
        int input = 120;

        int output = reverseInteger.reverse(input);

        Assert.assertEquals(21, output);
    }

    @AfterClass
    public static void destroy(){
        reverseInteger = null;
    }
}
