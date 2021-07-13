package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 06.07.21.
 * algorithms
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();

        System.out.println(ms.multiply("999","99"));
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();

        int maxLen = Math.max(c1.length, c2.length);
        int minLen = Math.min(c1.length, c2.length);
        int[][] board = null;
        if(c1.length>c2.length){
            board = multiply(maxLen, c2, c1);
        }else{
            board = multiply(maxLen, c1, c2);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<2*maxLen;i++){
            if(board[minLen][i]==0 && sb.length()==0) continue;
            sb.append(board[minLen][i]);
        }
        return sb.toString();
    }

    private int[][] multiply(int len, char[] small, char[] large){
        int[][] board = new int[small.length+1][2*len];

        int index = 0;
        int start = 2*len;
        for(int i=small.length-1;i>=0;i--){
            int a = small[i]-'0';
            int productRemain = 0;
            int sumRemain = 0;

            int n = 2*len-1;
            ++index;
            --start;
            while (n>start){
                board[index][n] = board[index-1][n];
                --n;
            }
            for(int j=large.length-1;j>=0;j--){
                int b = large[j] - '0';

                int product = a*b+productRemain;
                productRemain = product/10;

                int sum = board[index-1][n]+product%10+sumRemain;
                sumRemain = sum/10;

                board[index][n] = sum%10;
                --n;
            }
            board[index][n] = sumRemain+productRemain;
        }
        return board;
    }
}
