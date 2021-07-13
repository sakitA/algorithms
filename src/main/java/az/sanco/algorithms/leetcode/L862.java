package az.sanco.algorithms.leetcode;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by sanco on 04.07.21.
 * algorithms
 */
public class L862 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        L862 l = new L862();
        String input = Files.readAllLines(Paths.get((new File("input.txt")).toURI())).get(0);
        String[] nums = input.split(",");
        int[] arr = new int[nums.length];
        int index = 0;
        for(String s:nums){
            arr[index++] = Integer.parseInt(s);
        }
        long start = System.nanoTime();
        int answer = l.shortestSubarray(new int[]{2,1,-1,4,5}, 10);
        long end = System.nanoTime();
        System.out.println(answer+", elapse "+(TimeUnit.NANOSECONDS.toMillis(end-start))+" ms");
    }
    public int shortestSubarraySlow(int[] nums, int k) {
        int[] sums = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=k) return 1;
            sums[i] = nums[i];
        }

        for(int i=1;i<nums.length;i++){
            int index =0;
            for(int j=i;j<nums.length;j++){
                sums[index] += nums[j];
                if(sums[index]>=k) return i+1;
                ++index;
            }
        }

        return -1;
    }

    public int shortestSubarrayNoCorrect(int[] nums, int k){
        int count1 = 0, count2 = 0, sum1 = 0, sum2 = 0;

        for(int n:nums){
            if(n==k) return 1;
            if(count1<count2){
                sum1+=n;
                ++count1;
                if(sum2+n >= k) return count2+1;
            }else if (count1>count2){
                sum2+=n;
                ++count2;
                if(sum1+n >= k) return count1+1;
            }else{
                if(sum1+n < sum2+n){
                    sum2+=n;
                    ++count2;
                }else{
                    sum1+=n;
                    ++count1;
                }
            }
            if(sum1>=k) return count1;
            if(sum2>=k) return count2;
            if(sum1+sum2>=k) return count1+count2;

        }

        return -1;
    }

    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }
}
