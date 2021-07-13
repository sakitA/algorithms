package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 13.07.21.
 * algorithms
 */
public class DuplicateZero {
    public void duplicateZeros(int[] arr) {
        int size = 0, endIndex=-1, startIndex=-1;
        boolean noneZero = false;
        for(int i=0;i<arr.length && size<arr.length;i++){
            if(arr[i]==0) {
                noneZero=true;
                size+=2;
            } else {
                if(!noneZero)
                    ++startIndex;
                ++size;
            }
            endIndex=i;
        }
        if(endIndex!=arr.length-1){
            int index = arr.length-1;
            if(size>arr.length) {
                arr[index--] = 0;
                --endIndex;
            }
            for(;index>startIndex;index--){
                arr[index] = arr[endIndex];
                if(arr[index]==0) arr[--index] = 0;
                --endIndex;
            }
        }
    }
}
