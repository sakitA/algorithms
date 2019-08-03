package az.sanco.algorithms.leetcode;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by sanco on 2019-08-03.
 * CodeForce
 */
public class TestLongestPalindromicSubstring {
    private static LongestPalindromicSubstring longestPalindromicSubstring;

    @BeforeClass
    public static void init(){
        longestPalindromicSubstring = new LongestPalindromicSubstring();
    }

    @Test
    public void testCase1(){
        String input = "babad";
        String output = longestPalindromicSubstring.longestPalindrome(input);

        Assert.assertEquals("bab", output);
    }

    @Test
    public void testCase2(){
        String input = "cbbd";
        String output = longestPalindromicSubstring.longestPalindrome(input);

        Assert.assertEquals("bb", output);
    }

    @AfterClass
    public static void destroy(){
        longestPalindromicSubstring = null;
    }

}
