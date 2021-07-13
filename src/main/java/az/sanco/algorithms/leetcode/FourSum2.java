package az.sanco.algorithms.leetcode;

import java.util.*;

/**
 * Created by sanco on 04.07.21.
 * algorithms
 */
public class FourSum2 {
    public static void main(String[] args) {
        FourSum2 fs = new FourSum2();
//        int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
        int[] nums1 = {-1, -1}, nums2 = {-1, 1}, nums3 = {-1, 1}, nums4 = {1, -1};
//        int[] nums1 = {0}, nums2 = {0}, nums3 = {0}, nums4 = {0};
        System.out.println(fs.fourSumCount(nums1, nums2, nums3, nums4));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Set<List<Integer>>> map = mapSet(nums3, nums4);

        int count = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (map.containsKey(-sum)) {
                    count += map.get(-sum).size();
                }
            }
        }

        return count;
    }

    private Map<Integer, Set<List<Integer>>> mapSet(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.computeIfAbsent(nums1[i] + nums2[j], k -> new HashSet<>()).add(Arrays.asList(i, j));
            }
        }
        return map;
    }
}
