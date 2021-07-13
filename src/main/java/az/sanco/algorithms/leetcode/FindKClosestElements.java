package az.sanco.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sanco on 03.07.21.
 * algorithms
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>(arr.length);
        for (int j : arr) result.add(j);

        if(k==arr.length)
            return result;

        if(x>=arr[arr.length-1]){
            return result.subList(arr.length-k, arr.length);
        }else if(x<=arr[0]){
            return result.subList(0, k);
        }else{
            result.clear();
            NumIndex[] diff = new NumIndex[arr.length];
            for (int i = 0; i < arr.length; i++) {
                diff[i] = new NumIndex(i, Math.abs(arr[i]-x));
            }

            Arrays.sort(diff);

            for(int i=0;i<k;i++){
                result.add(arr[diff[i].index]);
            }
            result.sort(Integer::compare);
            return result;
        }
    }

    class NumIndex implements Comparable<NumIndex>{
        int index;
        int value;

        public NumIndex(int index, int value) {
            this.index = index;
            this.value = value;
        }


        @Override
        public int compareTo(NumIndex o) {
            if(this.value!=o.value)
                return Integer.compare(this.value, o.value);
            return Integer.compare(this.index, o.index);
        }
    }
}
