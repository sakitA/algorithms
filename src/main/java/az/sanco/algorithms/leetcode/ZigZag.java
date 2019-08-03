package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 2019-07-04.
 * CodeForce
 */
public class ZigZag {
    public String convert(String s, int numRows) {
        if(numRows<=1 || numRows>=s.length()){
            return s;
        }

        int len = s.length();
        int step = 2*(numRows-1);
        int maxCol = len/numRows;
        int index = 0;
        int col = 0;
        int first = -1;
        int second = -1;

        char[] ch = s.toCharArray();
        char[] res = new char[len];

        for(int i=0;i<numRows;i++){
            col = 0;
            first = -1;
            second = -1;

            while(col<=maxCol){
                first = (i==0 || i==numRows-1) ? -1 : col*step - i;
                second = col*step + i;
                if(first>=0 && first<len)
                    res[index++] = ch[first];

                if(second<len && second!=first)
                    res[index++] = ch[second];
                ++col;
            }
        }

        return new String(res);
    }
}
