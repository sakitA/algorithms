package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 2019-07-02.
 * CodeForce
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }

        for(int i=s.length();i>=0;i--){
            for(int j=0;j+i<=s.length();j++){
                String tmp = s.substring(j,i+j);
                if(isPalindrome(tmp)){
                    return tmp;
                }
            }
        }
        return s;
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        int end = len/2;
        char[] ch = s.toCharArray();
        for(int i=0;i<end;i++){
            if(ch[i]!=ch[len-i-1]){
                return false;
            }
        }
        return true;
    }
}
