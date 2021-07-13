package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 13.07.21.
 * algorithms
 */
public class SquaresOfSortedArrays {
    public int[] sortedSquares(int[] nums) {
        if(nums.length==1) return new int[]{nums[0]*nums[0]};

        int[] squares = new int[nums.length];

        int posInd = -1;
        int negInd = -1;
        boolean hasNegative = nums[0]<0;

        for(int i=0;i<nums.length;i++){
            if(posInd==-1 && nums[i]>=0){
                posInd=i;
            }
            nums[i] *= nums[i];
        }
        if(!hasNegative) return nums;
        if(posInd==-1){
            for(int i=nums.length-1;i>=0;i--) squares[nums.length-i-1] = nums[i];
            return squares;
        }

        int index = 0;
        negInd = posInd - 1;
        while(negInd>=0 && posInd<nums.length){
            if(nums[posInd]>=nums[negInd]){
                squares[index++] = nums[negInd];
                --negInd;
            }else {
                squares[index++] = nums[posInd];
                ++posInd;
            }
        }

        while(negInd>=0) squares[index++] = nums[negInd--];
        while(posInd<nums.length) squares[index++] = nums[posInd++];

        return squares;
    }
}
