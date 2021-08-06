package az.sanco.algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by sanco on 05.08.21.
 * algorithms
 */
public class StoneGames {
    public static void main(String[] args) {
        StoneGames sg = new StoneGames();
        System.out.println(sg.stoneGame(new int[]{3,2,10,4,9,7}));
    }
    private int[][] max;
    public boolean stoneGame(int[] piles) {
        int totalSum = 0;
        totalSum = Arrays.stream(piles).sum();
        max = new int[piles.length][piles.length];

        int sum = helper(piles, 0, 0, piles.length-1);
        return sum>totalSum/2;
    }

    private int helper(int[] piles, int sum, int lo, int hi) {
        if(lo>hi) return sum;
        if(max[lo][hi]!=0) return max[lo][hi];
        else if(hi-lo==1){
            max[lo][hi] = Math.max(piles[lo], piles[hi]);
            return sum+max[lo][hi];
        }

        int h1 = helper(piles,sum+piles[lo], lo+2, hi);
        int h2 = helper(piles,sum+piles[lo], lo+1, hi-1);
        int h3 = helper(piles,sum+piles[hi], lo+1, hi-1);
        int h4 = helper(piles,sum+piles[hi], lo, hi-2);
        max[lo][hi] = Math.max(Math.max(h1,h2), Math.max(h3,h4));
        return max[lo][hi];
    }
}
