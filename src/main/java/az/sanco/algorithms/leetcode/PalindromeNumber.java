package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 2019-08-03.
 * algorithms
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else if(x<10)
            return true;
        else if(x%10==0)
            return false;

        int reverse = 0;
        int tmp = x;

        do{
            reverse = reverse*10+tmp%10;
            tmp/=10;
        }while(tmp!=0);
        return x==reverse;
    }
}
