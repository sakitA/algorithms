package az.sanco.algorithms.leetcode;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by sanco on 2019-08-03.
 * CodeForce
 */
public class TestAddTwoNumbers {
    private static AddTwoNumbers addTwoNumbers;

    @BeforeClass
    public static void init(){
        addTwoNumbers = new AddTwoNumbers();
    }

    @Test
    public void testCase1(){
        AddTwoNumbers.ListNode ln1 = fillNode(2,4,3);
        AddTwoNumbers.ListNode ln2 = fillNode(5,6,4);

        AddTwoNumbers.ListNode output = addTwoNumbers.addTwoNumbers(ln1,ln2);

        AddTwoNumbers.ListNode expected = fillNode(7,0,8);
        Assert.assertEquals(expected, output);
    }

    @AfterClass
    public static void destroy(){
        addTwoNumbers = null;
    }

    public AddTwoNumbers.ListNode fillNode(int... num){
        AddTwoNumbers.ListNode ln = new AddTwoNumbers.ListNode(num[0]);
        AddTwoNumbers.ListNode tmp = ln;
        for(int i=1;i<num.length;i++){
            AddTwoNumbers.ListNode l = new AddTwoNumbers.ListNode(num[i]);
            tmp.next = l;
            tmp = tmp.next;
        }

        return ln;
    }
}
