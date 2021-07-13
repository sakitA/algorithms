package az.sanco.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanco on 12.07.21.
 * algorithms
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for(int i=0;i<sChar.length;i++){
            char cs = sChar[i];
            char ct = tChar[i];
            if(sMap.containsKey(cs) && ct!=sMap.get(cs)){
                return false;
            }else if(!sMap.containsKey(sChar[i]) && tMap.containsKey(ct)){
                return false;
            }else{
                sMap.put(cs, ct);
                tMap.put(ct, cs);
            }
        }
        return true;

    }

}
