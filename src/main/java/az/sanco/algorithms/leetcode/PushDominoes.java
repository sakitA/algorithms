package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 22.07.21.
 * algorithms
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        if(dominoes.length()<2) return dominoes;
        char[] chars = dominoes.toCharArray();

        int count = 0,begin=0,end=0,i=0;

        while (i<chars.length){
            if(chars[i]=='.'){
                begin = i;
                count=1;
                end = i;
                while (end<chars.length-1 && chars[++end]=='.') ++count;
                if(count==1){
                    if(begin==0){
                        chars[begin] = chars[begin+1]=='L'? 'L':'.';
                    }else if(begin==chars.length-1){
                        chars[begin] = chars[begin-1]=='R'? 'R':'.';
                    }else {
                        if((chars[begin-1]=='R' && chars[begin+1]=='L') || (chars[begin-1]=='L' && chars[begin+1]=='R')) {
                            chars[begin]='.';
                        }else{
                            chars[begin]=chars[begin-1]=='R'? 'R': chars[begin+1]=='L'? 'L':'.';
                        }
                    }
                    ++i;
                }else if(count==chars.length){
                    return dominoes;
                }else{
                    if(begin>0 && chars[begin-1]=='R' && chars[end<chars.length? end : end-1]=='L') {
                        for(int k = begin; k < begin + count / 2; k++)
                            chars[k] = 'R';
                        for(int k=begin+count/2+count%2;k<end;k++){
                            chars[k]='L';
                        }
                    }else if(chars[begin==0? 0 : begin-1]=='R'){
                        while(begin<end) chars[begin++]='R';
                    }else if(chars[end<chars.length? end:end-1]=='L'){
                        while(begin<end) chars[begin++]='L';
                    }
                    i = end;
                }
            }else ++i;
        }

        return new String(chars);
    }
}
