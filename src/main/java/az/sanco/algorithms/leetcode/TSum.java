package az.sanco.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sanco on 03.07.21.
 * algorithms
 */
public class TSum {
    public static void main(String[] args) {
        TSum t = new TSum();
        System.out.println(t.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums.length<3)
            return result;
        else {
            Arrays.sort(nums);

            int lastI = Integer.MIN_VALUE;
            int lastJ = Integer.MIN_VALUE;
            for(int a=0;a<nums.length-2;a++){
                int i = nums[a];
                if(lastI==i) continue;
                else
                    lastI = i;

                for(int b=a+1;b<nums.length-1;b++){
                    int j = nums[b];
                    if(lastJ==j) continue;
                    else
                        lastJ = j;
                    if(numExists(nums, b+1, nums.length-1, -1*(i+j))){
                        result.add(Arrays.asList(i,j,-1*(i+j)));
                    }
                }
            }

            return result;
        }
    }

    public boolean numExists(int[] nums, int lowIndex, int highIndex, int search){
        if(lowIndex>highIndex)
            return false;
        int mid = (lowIndex+highIndex)>>>1;
        if(nums[mid]==search)
            return true;
        else if(nums[mid]<search)
            return numExists(nums, mid+1, highIndex, search);
        else
            return numExists(nums, lowIndex,mid-1, search);
    }
}
