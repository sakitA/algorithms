package az.sanco.algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by sanco on 31.07.21.
 * algorithms
 */
public class Example {
    public static void main(String[] args) {
        for(long i: Arrays.asList(1000l, 10000l, 100000l, 1000000l,(long)10e8)){
            System.out.println(i+" takes "+loop(i)+" ms");
        }
    }

    private static long loop(long i) {
        long start = System.currentTimeMillis();
        for(long j=1;j<=i;j++);
        return System.currentTimeMillis()-start;
    }
}
