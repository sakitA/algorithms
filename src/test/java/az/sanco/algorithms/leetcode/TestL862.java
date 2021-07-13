package az.sanco.algorithms.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Created by sanco on 05.07.21.
 * algorithms
 */
public class TestL862 {
    private Random r = new Random();

    @Test
    public void l862(){
        L862 l = new L862();
        int len = 5+r.nextInt(15);
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = (r.nextInt(6)%5==0? -1:1)*r.nextInt((int)100);
            System.out.print(arr[i]+",");
        }

        int k = r.nextInt((int)500);
        System.out.println("\n"+k);

        Assert.assertEquals(l.shortestSubarraySlow(arr, k),l.shortestSubarray(arr, k));
    }
}
