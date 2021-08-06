package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 22.07.21.
 * algorithms
 */
public class Array {
    public static void main(String[] args) {
        Array a = new Array();
        System.out.println(a.findMaxLength(new int[]{0,0,1,0,0,0,1,1}));

        System.out.println(a.findMaxLength(new int[]{0,1}));
        System.out.println(a.findMaxLength(new int[]{
                0,1,0,1,1,1,0,0,1,1,
                0,1,1,1,1,1,1,0,1,1,
                0,1,1,0,0,0,1,0,1,0,
                0,1,0,1,1,1,1,1,1,0,
                0,0,0,1,0,0,0,1,1,1,
                0,1,0,0,1,1,1,1,1,0,
                0,1,1,1,1,0,0,1,0,1,
                1,0,0,0,0,0,0,1,0,1,
                0,1,1,0,0,1,1,0,1,1,
                1,1,0,1,1,0,0,0,1,1}));
        System.out.println(a.findMaxLength(new int[]{
                0,0,1,1,0,1,0,1,0,1,0,0,0,1,1,1,1,1,0,0,1,0,0,1,1,0,1,1,0,0,1,0,0,0,1,0,0,1,0,1,0,0,1,0,1,1,1,0,0,1,1,0,0,1,1,0,0,0,1,0,1,0,0,1,1,0,0,1,0,1,0,0,0,0,0,1,0,1,1,0,0,1,1,0,0,1,0,1,0,0,0,1,1,0,1,1,1,0,0,1
        }));
    }
    public int partitionDisjoint(int[] nums) {
        if (nums.length == 2) return 1;
        int leftMax = nums[0], leftEndIndex = 0, rightMax = nums[0];
        boolean rightBegin = false;
        for (int i = 1; i < nums.length - 1; i++) {
            if (leftMax > nums[i]) {
                leftEndIndex = i;
                if (rightBegin) {
                    rightBegin = false;
                    leftMax = rightMax;
                }
            } else rightBegin = true;

            if (rightBegin && rightMax < nums[i]) {
                rightMax = nums[i];
            }
        }
        return leftEndIndex + 1;
    }

    class MyNum implements Comparable<MyNum> {
        int index = -1;
        int value = -1;

        public MyNum(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(MyNum o) {
            return this.value == o.value ? Integer.compare(this.index, o.index) :
                    Integer.compare(this.value, o.value);
        }
    }

    public int partitionDisjointWrong(int[] nums) {
        if (nums.length == 2) return 1;
        int minIndex = 0;

        //find minimum element in the array;
        for (int i = 1; i < nums.length; i++) {
            if (nums[minIndex] > nums[i]) {
                minIndex = i;
            }
        }
        return minIndex + 1;
    }

    public int findMaxLength(int[] nums) {
        if(nums.length<=1) return 0;

        int zc = 0, oc = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                ++zc;
            }else{
                ++oc;
            }
        }
        int ans = 2*Math.min(zc,oc);
        if(ans==nums.length) return ans;

        int lefAns = 0;
        int rightAns = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                --zc;
            else
                --oc;

            if(zc+oc==ans){
                lefAns = ans;
                break;
            }else{
                ans = 2*Math.min(zc,oc);
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==0)
                --zc;
            else
                --oc;

            if(zc+oc==ans){
                rightAns = ans;
                break;
            }else{
                ans = 2*Math.min(zc,oc);
            }
        }
        return Math.max(lefAns, rightAns);
    }

    int helper(int[] nums, int start, int end){
        int zc = 0, oc = 0;
        for(int i=start;i<end;i++){
            if(nums[i]==0){
                ++zc;
            }else{
                ++oc;
            }
        }
        return 2*Math.min(zc,oc);
    }
}
