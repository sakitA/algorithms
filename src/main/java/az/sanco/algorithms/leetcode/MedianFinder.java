package az.sanco.algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by sanco on 11.07.21.
 * algorithms
 */
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(6);
        mf.addNum(3);
        mf.addNum(2);
        mf.addNum(2);
        mf.addNum(2);
        mf.addNum(2);
        mf.addNum(2);
        mf.addNum(2);
        mf.addNum(9);
        mf.addNum(13);
        mf.addNum(12);
        mf.addNum(125);
        mf.addNum(-34);
        mf.addNum(-35);
        mf.addNum(50);
        mf.addNum(55);
        mf.addNum(60);
        System.out.println(mf.findMedian());
    }
    private int[] elements;
    private int size = 0;
    private int capacity = 16;
    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
       elements = new int[capacity];
    }

    public void addNum(int num) {
        checkCapacity();
        if(elements[0]>=num || size==0){
            System.arraycopy(elements, 0, elements, 1, size);
            elements[0] = num;
        }else if(elements[size-1]<=num){
            elements[size] = num;
        }else {
            int i = 0, j = size - 1;
            while(i!=j){
                int mid = (i+j)>>>1;
                if(elements[mid]<num){
                    i = mid + 1;
                }else{
                    j = mid;
                }
            }
            System.arraycopy(elements, i, elements, i+1, size-i);
            elements[i] = num;
        }
        ++size;
    }

    private void checkCapacity() {
        if(capacity-size<10){
            capacity += size/2;
            elements = Arrays.copyOf(elements, capacity);
        }
    }

    public double findMedian() {
        if(size%2==0){
            int mid = size/2;
            return (elements[mid]+elements[mid-1]) / 2.0;
        }else{
            return elements[size/2];
        }
    }
}
