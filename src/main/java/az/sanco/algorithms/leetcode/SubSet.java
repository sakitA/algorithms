package az.sanco.algorithms.leetcode;

import java.util.*;

/**
 * Created by sanco on 03.08.21.
 * algorithms
 */
public class SubSet {
    public static void main(String[] args) {
        SubSet ss = new SubSet();
        ss.subsetsWithDup(new int[]{0});
    }

    private Set<Integer> mapNumKeys = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> allSubSet = new ArrayList<>();
        Arrays.sort(nums);
        int twos = 1<<nums.length;
        for(int i=0;i<twos;i++){
            List<Integer> subSet = calculate(i, nums);
            if(subSet!=null)
                allSubSet.add(subSet);
        }

        return allSubSet;
    }

    private List<Integer> calculate(int x, int[] nums) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for(int i=x;i>0;i>>=1){
            if((i&1)==1){
                list.add(nums[index]);
            }
            ++index;
        }
        int hash = Objects.hashCode(list);
        if(mapNumKeys.contains(hash)){
            return null;
        }else if(!list.isEmpty()){
            mapNumKeys.add(hash);
        }
        return list;
    }
}
