package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 13.07.21.
 * algorithms
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int i=0, j=nums.length-1;

        while(i<=j){
            if(nums[i]>nums[i+1]) return i;
            if(nums[j]>nums[j-1]) return j;
            ++i;
            --j;
        }
        return i;
    }
}
