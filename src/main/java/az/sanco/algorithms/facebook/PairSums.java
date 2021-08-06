package az.sanco.algorithms.facebook;

/**
 * Created by sanco on 31.07.21.
 * algorithms
 */
import java.util.Arrays;
// Add any extra import statements you may need here


class PairSums {

    // Add any helper functions you may need here


    int numberOfWays(int[] arr, int k) {
        // Write your code here
        Arrays.sort(arr);

        int ans = 0;
        for(int i=0;i<arr.length;i++){
            int find = k-arr[i];
            if(find<0) break;
            ans+=findAll(arr, find, i+1, arr.length);
        }
        return ans;
    }


    int findAll(int[] sortedArray, int key, int start, int end){
        if(start>=end) return 0;
        int mid = (start+end)/2;
        if(sortedArray[mid]==key){
            int cnt = 0;
            for(int i=mid;i>=start && sortedArray[i]==key;i--) ++cnt;
            for(int i=mid+1;i<end && sortedArray[i]==key;i++) ++cnt;
            return cnt;
        }else{
            return sortedArray[mid]>key? findAll(sortedArray, key, start, mid) : findAll(sortedArray, key, mid+1, end);
        }
    }








    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new PairSums().run();
    }
}
