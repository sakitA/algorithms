package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 2019-08-02.
 * CodeForce
 */
public class Atoi {
    public int myAtoi(String str) {
        //remove white space
        str = str.trim();

        if(str.isEmpty())
            return 0;
        else if(str.length()==1){
            //if length is 1 then check that is digit or no.
            //is digit return it else return 0
            char c = str.charAt(0);

            if(isDigit(c))
                return toNum(c);
            else
                return 0;
        }else {
            //search all number until find first none digit character
            int index = 0;
            char[] arr = str.toCharArray();
            char firstChar = arr[index];

            if (firstChar == '-' || firstChar == '+' || isDigit(firstChar)) {
                if (firstChar == '-' || firstChar == '+')
                    ++index;

                int sum = 0;
                boolean minus = firstChar == '-';
                do {
                    char digit = arr[index++];
                    if (isDigit(digit)) {
                        int num = toNum(digit);

                        //checking overflow for integer
                        //for positive numbers
                        if (!minus && (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && num > 7)))
                            return Integer.MAX_VALUE;

                        //for negative numbers
                        if (minus && (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && -num < -8)))
                            return Integer.MIN_VALUE;

                        if (minus)
                            sum = sum * 10 - num;
                        else
                            sum = sum * 10 + num;
                    } else {
                        return sum;
                    }
                } while (index < arr.length);

                return sum;
            }
        }
        return 0;
    }

    //convert digit chart to digit num
    private int toNum(char c) {
        return c-'0';
    }

    //check character is digit or not
    private boolean isDigit(char c){
        return c>='0' && c<='9';
    }
}
