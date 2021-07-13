package az.sanco.algorithms.leetcode;

import java.util.*;

/**
 * Created by sanco on 05.07.21.
 * algorithms
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(4));
    }
    public List<String> generateParenthesis(int n) {
        Map<Integer, List<String>> map = new HashMap<>();

        map.put(1, Collections.singletonList("()"));
        for(int i=2;i<=n;i++){
            Set<String> parentheses = new HashSet<>();
            for(String s: map.get(i-1)){
                int lastIndex = 0;
                while(lastIndex<s.length()){
                    int index = s.indexOf("()", lastIndex);
                    if(index==-1)
                        break;
                    // left concat
                    parentheses.add(s.substring(0, index)+"()"+s.substring(index));
                    //right
                    parentheses.add(s.substring(0, index+1)+"()"+s.substring(index+1));
                    //inside
                    parentheses.add(s.substring(0, index+2)+"()"+s.substring(index+2));

                    lastIndex = index+2;
                }
            }

            map.put(i, new ArrayList<>(parentheses));
        }

        return map.get(n);
    }
}
