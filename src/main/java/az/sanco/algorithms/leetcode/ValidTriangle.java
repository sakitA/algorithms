package az.sanco.algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by sanco on 15.07.21.
 * algorithms
 */
public class ValidTriangle {
    public static void main(String[] args) {
        ValidTriangle vt = new ValidTriangle();
//        System.out.println(vt.triangleNumber(new int[]{2,2,3,4}));
        System.out.println(vt.triangleNumber(new int[]{4,2,3,4}));
    }
    public int triangleNumber(int[] nums) {
        if(nums.length<3) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length-2;i++){
            int a = nums[i];
            int k = i + 2;
            for(int j=i+1;j<nums.length;j++){
                int b = nums[j];
                while(k<nums.length && isValidTriangle(a,b, nums[k])) ++k;

                if(k>j)
                    count+=k-j-1;
            }
        }

        return count;
    }

    private boolean isValidTriangle(int a, int b, int c) {
        return (a+b>c) && (a+c)>b && (b+c)>a;
    }
}
