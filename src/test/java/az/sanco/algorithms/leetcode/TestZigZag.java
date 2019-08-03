package az.sanco.algorithms.leetcode;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by sanco on 2019-08-03.
 * algorithms
 */
public class TestZigZag {
    private static ZigZag zigZag;

    @BeforeClass
    public static void init(){
        zigZag = new ZigZag();
    }

    @Test
    public void testCase1(){
        String input = "PAYPALISHIRING";
        int numRows = 3;

        String output = zigZag.convert(input, numRows);

        Assert.assertEquals("PAHNAPLSIIGYIR", output);
    }

    @Test
    public void testCase2(){
        String input = "PAYPALISHIRING";
        int numRows = 4;

        String output = zigZag.convert(input, numRows);

        Assert.assertEquals("PINALSIGYAHRPI", output);
    }

    @AfterClass
    public static void destroy(){
        zigZag = null;
    }
}
