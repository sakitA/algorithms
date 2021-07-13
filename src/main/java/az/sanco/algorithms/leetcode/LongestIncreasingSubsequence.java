package az.sanco.algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by sanco on 09.07.21.
 * algorithms
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

//        int[] arr = new int[]{0,1,0,3,2,3};
//        int[] arr = new int[]{10,9,2,5,3,7,200,18,101,102,103};
//        int[] arr = new int[]{10,9,2,5,3,7,101,18};
//        int[] arr = new int[]{2,15,3,7,8,6,18};
        int[] arr = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(lis.lengthOfLIS(arr));
        lis.lengthOfLISPath(arr);
    }

    public int lengthOfLIS(int[] nums) {
        int[] sub = new int[nums.length];
        int size = 0;
        for(int n: nums){
            if(size==0 || sub[size-1]<n){
                sub[size++]=n;
            }else {
                int idx = findSmallestIndex(sub, size, n);
                sub[idx] = n;
            }
        }
        return size;
    }

    private int findSmallestIndex(int[] sub, int length, int key) {
        int i=0;
        int j=length-1;
        while(i!=j){
            int mid = (i+j)>>>1;
            if(sub[mid]<key){
                i = mid+1;
            }else
                j = mid;
        }
        return i;
    }

    public void lengthOfLISPath(int[] nums) {
        int[] sub = new int[nums.length];
        int[] subIndex = new int[nums.length];
        int[] path = new int[nums.length];
        Arrays.fill(path, -1);
        int size=0;
        int subIndexSize=0;
        for (int i = 0; i <nums.length; i++) {
            if(size==0 || sub[size-1]<nums[i]){
                path[i] = subIndexSize==0? -1 : subIndex[subIndexSize-1];
                sub[size++] = nums[i];
                subIndex[subIndexSize++] = i;
            }else{
                int idx = findSmallestIndex(sub, size, nums[i]);
                path[i] = idx == 0? -1 : subIndex[idx-1];
                sub[idx] = nums[i];
                subIndex[idx] = i;

            }
        }


        int t = subIndex[subIndexSize-1];
        StringBuilder sb = new StringBuilder();
        while(t>=0){
            sb.append(nums[t]).append(",");
            t = path[t];
        }

        System.out.println("["+sb.substring(0,sb.length()-1)+"]");
    }

}
