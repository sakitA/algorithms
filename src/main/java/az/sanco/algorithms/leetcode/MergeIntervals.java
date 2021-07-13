package az.sanco.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sanco on 12.07.21.
 * algorithms
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<Pair> pairs = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            pairs.add(new Pair(intervals[i]));
        }
        Collections.sort(pairs);

        List<int[]> list = new ArrayList<>();
        int[] last = null;
        for(Pair p : pairs){
            if(last==null){
                last = p.getPair();
                list.add(last);
            }else{
                if(last[1]>=p.getStartIndex()){
                    last[1] = Math.max(last[1], p.getEndIndex());
                }else{
                    last = p.getPair();
                    list.add(last);
                }
            }
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


    class Pair implements Comparable<Pair>{
        int[] interval;

        public Pair(int[] interval) {
            this.interval = interval;
        }

        @Override
        public int compareTo(Pair o) {
            return this.getStartIndex()==o.getStartIndex() ?
                    Integer.compare(this.getEndIndex(), o.getEndIndex()) :
                    Integer.compare(this.getStartIndex(), o.getStartIndex());
        }

        public int getStartIndex(){
            return interval[0];
        }

        public int getEndIndex(){
            return interval[1];
        }

        public int[] getPair(){
            return interval;
        }
    }
}
