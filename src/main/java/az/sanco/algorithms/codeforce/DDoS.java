package az.sanco.algorithms.codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sanco on 10/13/18.
 * CodeForce
 */
public class DDoS {

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(bi.readLine());

        String line = bi.readLine();

        System.out.println(findTime(n, line.split(" ")));
    }

    public static long findTime(int n, String[] requests){
        int sum = 0;
        int len = 0;
        int max = 0;

        int[] nums = new int[n];
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.valueOf(requests[i]);
            arr[0][i] = nums[i];
            sum+=nums[i];
            if(nums[i]>max && nums[i]>100){
                len = 1;
                max = nums[i];
            }
        }

        if(sum<100)
            return 0;

        for(int i=1;i<n;i++){
            for(int j=i;j<n;j++){
                arr[i][j] = arr[i-1][j-1]+arr[0][j];
                if(arr[i][j]>max && arr[i][j]>100*(i+1)){
                    len = i+1;
                    max = arr[i][j];
                }
            }
        }
        return len;
    }
}
