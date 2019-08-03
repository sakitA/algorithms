package az.sanco.algorithms.leetcode;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by sanco on 2019-08-03.
 * CodeForce
 */
public class TestAtoi {
    private static Atoi atoi;

    @BeforeClass
    public static void init(){
        atoi = new Atoi();
    }

    @Test
    public void testCase1(){
        String input = "42";

        int output = atoi.myAtoi(input);

        Assert.assertEquals(42, output);
    }

    @Test
    public void testCase2(){
        String input = "   -42";

        int output = atoi.myAtoi(input);

        Assert.assertEquals(-42, output);
    }

    @Test
    public void testCase3(){
        String input = "4193 with words";

        int output = atoi.myAtoi(input);
        Assert.assertEquals(4193, output);
    }

    @Test
    public void testCase4(){
        String input = "words and 987";

        int output = atoi.myAtoi(input);
        Assert.assertEquals(0, output);
    }

    @Test
    public void testCase5(){
        String input = "-91283472332";

        int output = atoi.myAtoi(input);
        Assert.assertEquals(Integer.MIN_VALUE, output);
    }

    @Test
    public void testCase6(){
        String input = "91283472332";

        int output = atoi.myAtoi(input);
        Assert.assertEquals(Integer.MAX_VALUE, output);
    }

    @Test
    public void testCase7(){
        String input = "+";

        int output = atoi.myAtoi(input);
        Assert.assertEquals(0, output);
    }

    @AfterClass
    public static void destroy(){
        atoi = null;
    }
}
