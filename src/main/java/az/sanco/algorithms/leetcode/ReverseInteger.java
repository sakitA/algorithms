package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 2019-07-07.
 * CodeForce
 */
public class ReverseInteger {

    public int reverse(int x) {
        if(x/10==0){
            return x;
        }

        long exp = findLength(x<0? -x:x);

        long num = 0;

        while(x/10!=0){
            num = num + (x%10)*exp;
            x/=10;
            exp/=10;
            if(num> Integer.MAX_VALUE || num< Integer.MIN_VALUE){
                return 0;
            }
        }

        return (int)(num+x);
    }

    public int findLength(int n){
        if(n== Integer.MAX_VALUE || n== Integer.MIN_VALUE)
            return 1000000000;
       if(n<100)
           return 10;
       else if(n<1000)
           return 100;
       else if(n<10000)
           return 1000;
       else if(n<100000)
           return 10000;
       else if(n<1000000)
           return 100000;
       else if(n<10000000)
           return 1000000;
       else if(n<100000000)
           return 10000000;
       else if(n<1000000000)
           return 100000000;
       else
           return 1000000000;
    }
}
