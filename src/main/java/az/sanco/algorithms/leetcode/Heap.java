package az.sanco.algorithms.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by sanco on 02.08.21.
 * algorithms
 */
public class Heap {
    public static void main(String[] args) {
        Heap h = new Heap();
        System.out.println(h.findMedian(new int[]{2, 4, 7, 1, 5, 3}));
    }

    int[] findMedian(int[] arr) {

        // Write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(arr.length);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(arr.length, Collections.reverseOrder());

        int[] medians = new int[arr.length];
        medians[0] = arr[0];
        minHeap.offer(arr[0]);

        for(int i=1;i<arr.length;i++){
            int median = addNumToHeapAndReturnMedian(
                    minHeap.size()>maxHeap.size()? maxHeap:minHeap,
                    maxHeap.size()>=minHeap.size()? maxHeap:minHeap, arr[i]);
            medians[i] = median;
        }

        return medians;
    }

    int addNumToHeapAndReturnMedian(PriorityQueue<Integer> smaller, PriorityQueue<Integer> larger, int num){
        if(smaller.size()==larger.size()){
            if(smaller.peek()>=num){
                larger.offer(smaller.poll());
                smaller.offer(num);
            }else{
                larger.offer(num);
            }
            return larger.peek();
        }else {
            int last = larger.poll();
            if(last<num){
                smaller.add(num);
                larger.add(last);
            }else{
                larger.add(last);
                smaller.add(num);
            }
            return (smaller.peek()+larger.peek())/2;
        }
    }
}
