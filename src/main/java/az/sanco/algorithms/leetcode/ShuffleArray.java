package az.sanco.algorithms.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by sanco on 20.07.21.
 * algorithms
 */
public class ShuffleArray {
    class Solution {
        private Random rd;
        private final int[] original;

        public Solution(int[] nums) {
            rd = new Random();
            this.original = Arrays.copyOf(nums, nums.length);
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return original;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] nums = Arrays.copyOf(original, original.length);
            int index = 0;
            while (index<original.length){
                swap(nums, index++, rd.nextInt(original.length));
            }
            return nums;
        }

        private void swap(int[] nums, int first, int second) {
            int tmp = nums[first];
            nums[first] = nums[second];
            nums[second] = tmp;
        }
    }
}
