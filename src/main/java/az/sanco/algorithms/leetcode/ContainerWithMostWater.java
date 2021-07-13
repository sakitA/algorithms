package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 30.06.21.
 * algorithms
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
//        int[] input = {1,8,6,2,5,4,8,3,7};
//        int[] input = {4,3,2,1,4};
        int[] input = {2,3,4,5,18,17,6};

        ContainerWithMostWater cww = new ContainerWithMostWater();
        System.out.println(cww.maxArea(input));
        
    }
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;

        while(l<r){
            area = Math.max(area, Math.min(height[l], height[r])*(r-l));

            if(height[l]<height[r])
                ++l;
            else
                --r;
        }

        return area;
    }
}
