package az.sanco.algorithms.leetcode;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by sanco on 2019-08-03.
 * CodeForce
 */
public class TestPalindromeNumber {
    private static PalindromeNumber palindromeNumber;

    @BeforeClass
    public static void init(){
        palindromeNumber = new PalindromeNumber();
    }

    @Test
    public void testCase1(){
        int input = 121;

        boolean output = palindromeNumber.isPalindrome(input);

        Assert.assertTrue(output);
    }

    @Test
    public void testCase2(){
        int input = 10;

        boolean output = palindromeNumber.isPalindrome(input);

        Assert.assertFalse(output);
    }

    @Test
    public void testCase3(){
        int input = -121;

        boolean output = palindromeNumber.isPalindrome(input);

        Assert.assertFalse(output);
    }

    @Test
    public void testCase4(){
        int input = 10101;

        boolean output = palindromeNumber.isPalindrome(input);

        Assert.assertTrue(output);
    }

    @Test
    public void testCase5(){
        int input = 657;

        boolean output = palindromeNumber.isPalindrome(input);

        Assert.assertFalse(output);
    }

    @Test
    public void testCase6(){
        int input = 0;

        boolean output = palindromeNumber.isPalindrome(input);

        Assert.assertTrue(output);
    }
    @AfterClass
    public static void destroy(){
        palindromeNumber = null;
    }
}
