package az.sanco.algorithms.leetcode;

import java.util.*;

/**
 * Created by sanco on 09.07.21.
 * algorithms
 */
public class GrayCode {
    public static void main(String[] args) {
        GrayCode gc = new GrayCode();

        System.out.println(gc.grayCode(25));
    }
    public List<Integer> grayCode(int n) {
        Integer[][] base = new Integer[n+1][];
        base[1] = new Integer[]{0,1};

        if(n==1) return Arrays.asList(base[1]);

        for(int i=2;i<=n;i++){
            base[i] = new Integer[(int)Math.pow(2, i)];
            int len = base[i-1].length;
            System.arraycopy(base[i-1], 0, base[i], 0, len);
            int pow = (int)Math.pow(2, i-1);
            for(int z=base[i-1].length-1;z>=0;z--){
                base[i][len++] = pow+base[i-1][z];
            }
        }

        return Arrays.asList(base[n]);
    }
}
