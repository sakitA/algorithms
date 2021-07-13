package az.sanco.algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by sanco on 04.07.21.
 * algorithms
 */
public class SumFloorPairs {
    public static void main(String[] args) {
        SumFloorPairs sfp = new SumFloorPairs();

        System.out.println(sfp.sumOfFlooredPairs(new int[]{2,3,5,6,8,9,20}));
    }
    public int sumOfFlooredPairs(int[] nums) {
        Arrays.sort(nums);

        int module = (int)Math.pow(10,9)+7;
        int sum = nums.length;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                sum = (sum+Math.floorDiv(nums[j], nums[i]))%module;
                if(nums[i]==nums[j]){
                    sum = (sum+1)%module;
                }
            }
        }

        return sum;

    }
}
