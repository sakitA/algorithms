package az.sanco.algorithms.leetcode;

/**
 * Created by sanco on 11.07.21.
 * algorithms
 */
public class VowelPermutation {
    public static void main(String[] args) {
        VowelPermutation vp = new VowelPermutation();
        System.out.println(vp.countVowelPermutation(50));
        System.out.println(vp.mod);
    }
    private int mod = (int)Math.pow(10,9)+7;

    /**
     * 0 - a
     * 1 - e
     * 2 - i
     * 3 - o
     * 4 - u
     */
    private char[][] charMap = new char[][]{
            {'e','i','u'},//path to 'a'
            {'a','i'},//path to 'e'
            {'e','o'},//path to 'i'
            {'i'},//path to 'o'
            {'i','o'}// path to 'u'
    };

    //we need current and previous sum for each vowel
    //0 - previous count, 1 - current or temporary

    private int[][] vowelCounts = new int[2][charMap.length];

    public int countVowelPermutation(int n) {
        if(n==1) return 5;

        for(int i=0;i<charMap.length;i++) vowelCounts[0][i]=1;

        for(int i=2; i<=n;i++){
            for (int j = 0; j < charMap.length; j++) {
                int count = 0;
                for(char c: charMap[j]){
                    int preCount = vowelCounts[0][indexOf(c)];
                    count = (count+preCount)%mod;
                }
                vowelCounts[1][j] = count;
            }

            for(int z=0;z<charMap.length;z++) {
                vowelCounts[0][z] = vowelCounts[1][z];
                vowelCounts[1][z] = 0;
            }
        }
        int ans = 0;
        for(int cnt: vowelCounts[0]){
            ans = (ans+cnt)%mod;
        }
        return ans;
    }

    private int indexOf(char c) {
        switch (c){
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
        }
        return -1;
    }
}
