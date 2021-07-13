package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 12.07.21.
 * algorithms
 */
public class DivideTwoIntegers {
    private final int MAX = Integer.MAX_VALUE;
    private final int MIN = Integer.MIN_VALUE;

    public int divide(int dividend, int divisor) {
        boolean positive = (dividend>=0 && divisor>=0)||(dividend<0 && divisor<0);

        if(dividend==0)
            return 0;
        else if(Math.abs(divisor)==1){
            if(dividend==MAX || dividend==MIN) return positive? MAX:MIN;
            return positive? Math.abs(dividend): -Math.abs(dividend);
        }else if(divisor==MIN && dividend!=MIN){
            return 0;
        }

        int i=0;
        dividend = -Math.abs(dividend);
        divisor  = -Math.abs(divisor);

        while (dividend<=divisor){
            dividend-=divisor;
            ++i;
        }
        return positive? i:-i;
    }
}
