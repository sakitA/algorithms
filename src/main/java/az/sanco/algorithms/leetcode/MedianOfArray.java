package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 2019-07-02.
 * CodeForce
 */
public class MedianOfArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        int[] c = new int[len];
        mergeArray(c,nums1,nums2,0,0,0);
        if(len%2==0){
            return (c[len/2]+c[len/2 -1 ])/2.0;
        }else{
            return c[(len-1)/2];
        }
    }

    public void mergeArray(int[] m, int[] a, int[] b,int mi, int ai, int bi){
        if(ai<a.length && bi<b.length){
            if(a[ai]<b[bi]){
                m[mi] = a[ai++];
            }else if(a[ai]>b[bi]){
                m[mi] = b[bi++];
            }else{
                if(a.length<b.length){
                    m[mi] = a[ai++];
                }else{
                    m[mi] = b[bi++];
                }
            }
        }else if(ai<a.length){
            m[mi] = a[ai++];
        }else if(bi<b.length){
            m[mi] = b[bi++];
        }else{
            return;
        }

        if(mi>(a.length+b.length)/2)
            return;
        mergeArray(m,a,b,++mi,ai,bi);
    }
}
