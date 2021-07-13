package az.sanco.algorithms.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by sanco on 06.07.21.
 * algorithms
 */
public class TestMultiplyStrings {

    @Test
    public void testMultiplyString(){
        Random r = new Random();
        MultiplyStrings ms = new MultiplyStrings();

        BigInteger num1 = new BigInteger(30, r);
        BigInteger num2 = new BigInteger(30, r);


        String expected = num1.multiply(num2).toString();
        String result = ms.multiply(num1.toString(), num2.toString());
        System.out.println("Num1="+num1);
        System.out.println("Num2="+num2);
        System.out.println("Expected="+expected);
        System.out.println("Result="+result);
        Assert.assertEquals(expected, result);
    }
}
