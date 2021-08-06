package az.sanco.algorithms.leetcode;

import java.util.*;

/**
 * Created by sanco on 19.07.21.
 * algorithms
 */
public class RandomProblems {
    public static void main(String[] args) {
        System.out.println((int)('Z'-'A'));
        RandomProblems rp = new RandomProblems();
//        System.out.println(rp.threeEqualParts(new int[]{1,1,1,0}));
//        System.out.println(rp.findIntegersSlow(Integer.MAX_VALUE));
//        char[][] grid = new char[][]{
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        };
//        System.out.println(rp.numIslands(grid));
//        System.out.println(rp.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
//        System.out.println(rp.numSquares(133));
//        System.out.println(rp.dailyTemperatures(new int[]{30,30,30,40}));
//        System.out.println(rp.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
//        System.out.println(rp.threeSumClosest(new int[]{1,2,5,10,11}, 12));
//        System.out.println(rp.threeSumClosest(new int[]{-1,0,1,1,55}, 3));
//        System.out.println(rp.beautifulArray(10));
//        System.out.println(rp.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
//        System.out.println(rp.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}}));
//        System.out.println(rp.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2));
//        System.out.println(rp.myPow(2.00000, -5));
//        System.out.println(rp.myPow(2.00000, -2147483648));
//        System.out.println(rp.trap(new int[]{0,7,1,4,6}));
//        System.out.println(rp.trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));
        System.out.println(rp.getBillionUsersDay(new float[]{1.1f,1.2f,1.3f}));
    }
    private static final int[] IMPOSSIBLE = new int[] {-1, -1};

    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;

        // Count how many 1s are in arr.
        int totalOnes = 0;
        for (int bit : arr) {
            totalOnes += bit;
        }

        // If total number of ones is not evenly divisible by 3, then no solution exists.
        if (totalOnes % 3 != 0) {
            return IMPOSSIBLE;
        }

        // Otherwise, each part should contain an equal amount of 1s.
        int targetOnes = totalOnes / 3;
        if (targetOnes == 0) {
            return new int[] {0, n - 1};
        }

        // i1, j1 marks the index of the first and last one in the first block of 1s, etc.
        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;

        //Find the index of the first and last 1 in each block of ones.
        int oneCount = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == 1) {
                oneCount += 1;
                if (oneCount == 1) i1 = i;
                if (oneCount == targetOnes) j1 = i;
                if (oneCount == targetOnes + 1) i2 = i;
                if (oneCount == 2 * targetOnes) j2 = i;
                if (oneCount == 2 * targetOnes + 1) i3 = i;
                if (oneCount == 3 * targetOnes) j3 = i;
            }
        }

        // The array is in the form W [i1, j1] X [i2, j2] Y [i3, j3] Z
        // where each [i, j] is a block of 1s and W, X, Y, and Z represent blocks of 0s.
        int[] part1 = Arrays.copyOfRange(arr, i1, j1 + 1);
        int[] part2 = Arrays.copyOfRange(arr, i2, j2 + 1);
        int[] part3 = Arrays.copyOfRange(arr, i3, j3 + 1);

        if (!Arrays.equals(part1, part2) || !Arrays.equals(part1, part3)) {
            return IMPOSSIBLE;
        }

        // The number of zeros after the left, middle, and right parts
        int trailingZerosLeft = i2 - j1 - 1;
        int trailingZerosMid = i3 - j2 - 1;
        int trailingZeros = n - j3 - 1;

        if (trailingZeros > Math.min(trailingZerosLeft, trailingZerosMid)) {
            return IMPOSSIBLE;
        }
        return new int[] {j1 + trailingZeros, j2 + trailingZeros + 1};
    }

    public int findIntegers(int n){
        return 0;
    }

    public int findIntegersSlow(int n){
        int ans = 0;
        for(int i=0;i<=n;i++){
            String binary = Integer.toBinaryString(i);
            if(!binary.contains("11"))++ans;
        }
        return ans;
    }

    public int numIslands(char[][] grid) {
        int island = 0;
        int mLen = grid.length;
        int nLen = grid[0].length;

        for(int m=0;m<mLen;m++){
            for(int n=0;n<nLen;n++){
                if(grid[m][n]=='0') continue;
                int ln = n==0? 0 : grid[m][n-1]-'0';
                int rn = n==nLen-1? 0 : grid[m][n+1]-'0';
                int un = m==0? 0 : grid[m-1][n]-'0';
                int bn = m==mLen-1? 0 : grid[m+1][n]-'0';

                if(ln+rn+un+bn<2) ++island;
            }
        }
        return island;
    }

    // -1: deadend, 0: unvisited, 1: visited
    private int[] nums;
    public int openLock(String[] deadends, String target) {
        Queue<Pair> queue = new LinkedList<>();

        int tarNum = Integer.parseInt(target);

        nums = new int[10000];
        for(String s: deadends){
            int num = Integer.parseInt(s);
            if(num==0) return -1;
            nums[num] = -1;
        }

        if(tarNum==0) return 0;

        nums[0] = 1;
        queue.add(new Pair(0, 0));

        while(!queue.isEmpty()){
            int len = queue.size();

            for(int i=0;i<len;i++){
                Pair p = queue.poll();
                int val = p.val;

                if(isFound(val, tarNum)) return p.level;

                for(int j=0;j<4;j++){
                    int forward = val+(int)Math.pow(10,j);
                    int backward = (int)Math.pow(10, j+1)-forward;

                    if(isFound(forward, tarNum) || isFound(backward, tarNum)) return p.level+1;

                    if(inRange(forward) && nums[forward]==0){
                        nums[forward] = 1;
                        queue.add(new Pair(forward,p.level+1));
                    }

                    if(inRange(backward) && nums[backward]==0){
                        nums[backward] = 1;
                        queue.add(new Pair(backward,p.level+1));
                    }
                }
            }
        }

        return -1;
    }

    private boolean inRange(int index) {
        return index>=0 && index<=9999;
    }

    private boolean isFound(int val, int target){
        if(!inRange(val)) return false;
        return val==target && nums[val]!=-1;
    }

    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        int min,j;
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            min = i;
            j=1;
            while(i-j*j>=0){
                min = Math.min(min, dp[i-j*j]+1);
                ++j;
            }
            dp[i] = min;
        }

        return dp[n];
    }

    private int dfs(int target, int step, int count) {
        if(target<=3) return count+target;
        if(isPerfectSquare(target)) return count+1;
        else {
            int square = step*step;
            int newTarget = target-square;
            return dfs(newTarget, newTarget<square? (int)Math.sqrt(newTarget):step, count+1);
        }
    }

    private boolean isPerfectSquare(int n) {
        int squareRoot = (int)Math.sqrt(n);
        return squareRoot*squareRoot == n;
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Pair> stack = new Stack<>();

        for(int i=0;i<temperatures.length-1;i++){
            if(temperatures[i]<temperatures[i+1]){
                ans[i] = 1;
                while (!stack.isEmpty() && temperatures[i+1]>stack.peek().val){
                    Pair p = stack.pop();
                    ans[p.level] = i+1-p.level;
                }
            }else
                stack.push(new Pair(temperatures[i], i));
        }

        Pair p = new Pair(temperatures[temperatures.length-1], temperatures.length-1);
        while (!stack.isEmpty()){
            if(p.val>stack.peek().val) {
                Pair t = stack.pop();
                ans[t.level] = p.level - t.level;
            }else
                p = stack.pop();
        }
        return ans;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solveWithDfs(nums, target, 0,  0,0);
    }

    private int solveWithDfs(int[] nums, int target, int sum, int index, int count){
        if(index>=nums.length){
            return target==sum? count+1:count;
        }

        return solveWithDfs(nums,target, sum+nums[index], index+1, count)+
                solveWithDfs(nums,target,sum-nums[index], index+1, count);
    }

    public int threeSumClosestBF(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, sum, ans=0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    sum = nums[i]+nums[j]+nums[k];
                    if(Math.abs(target-sum)<diff){
                        diff = Math.abs(target-sum);
                        ans = sum;
                    }
                }
            }
        }
        return ans;
    }

    public int threeSumClosest(int[] nums, int target) {
        int sum=0, i=0,j,k, diff = Integer.MAX_VALUE, tmp;
        Arrays.sort(nums);
        for(;i<nums.length;i++){
            j = i+1;
            k = nums.length-1;
            while(j<k){
                tmp = nums[j]+nums[k];
                if(Math.abs(target-nums[i]-tmp)<diff){
                    diff = Math.abs(target-nums[i]-tmp);
                    sum = tmp+nums[i];
                }

                if(tmp<target-nums[i])
                    ++j;
                else
                    --k;
            }
        }
        return sum;
    }

    public int[] beautifulArray(int n) {
        int[] ans = new int[n];
        int t=0,cnt=0;
        for(int i=1;i<=n;i+=2){
            ans[t] = i;
            ++cnt;
            if(cnt>2 && cnt%2==1){
                swap(ans, t-1,t);
            }
            ++t;
        }

        cnt=0;
        for(int i=2;i<=n;i+=2){
            ans[t]=i;
            ++cnt;
            if(cnt>2 && cnt%2==1){
                swap(ans,t-1,t);
            }
            ++t;
        }

        return ans;
    }

    private void swap(int[] arr, int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public String decodeString(String s){
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String val = "";
        int k=0;
        boolean start = false;
        for(char c: s.toCharArray()){
            if(c!='[' && c!=']' && !Character.isDigit(c) && stack.isEmpty()){
                sb.append(c);
            }else
                stack.push(c);
            if(!stack.isEmpty() && stack.peek()==']'){
                while(!stack.isEmpty()){
                    if(stack.peek()==']'){
                    }else if(!start && stack.peek()=='['){
                        val = tmp.toString();
                        tmp.setLength(0);
                        start = true;
                    }else if(start && !Character.isDigit(stack.peek())){
                        break;
                    }else
                        tmp.insert(0, stack.peek());
                    stack.pop();
                }
                if(start){
                    start = false;
                    k = Integer.parseInt(tmp.toString());
                    tmp.setLength(0);
                    for(int i=1;i<=k;i++){
                        tmp.append(val);
                    }

                    if(stack.isEmpty())
                        sb.append(tmp);
                    else{
                        tmp.chars().forEach(cc->stack.push((char)cc));
                    }
                    tmp.setLength(0);
                }
            }
        }
        return sb.toString();
    }
    public String decodeStringWrong(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        Stack<String> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int index = 0, k=0;
        String val="";
        boolean start = false;
        while(true){
            while(arr[index]!=']'){
                stack.push(String.valueOf(arr[index++]));
            }
            do{
                String c = stack.pop();
                if(c.equals("[")){
                    val = tmp.toString();
                    tmp.setLength(0);
                    start = true;
                }else if(start && (!Character.isDigit(c.charAt(0))||stack.isEmpty())){
                    if(stack.isEmpty())
                        tmp.insert(0,c);
                    k = Integer.parseInt(tmp.toString());
                    start = false;
                    tmp.setLength(0);

                    for(int i=1;i<=k;i++){
                        tmp.append(val);
                    }
                    if(stack.isEmpty()){
                        sb.append(tmp);
                    }else{
                        stack.push(c+tmp);
                    }
                    tmp.setLength(0);
                    break;
                }else {
                    tmp.insert(0, c);
                }
            }while(true);

            if(index>=s.length()-1)break;
            ++index;
        }
        return sb.toString();
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        for(int i=0;i< mat.length;i++)
            Arrays.fill(ans[i], Integer.MAX_VALUE-10000);

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    ans[i][j] = 0;
                }else{
                    if(i>0){
                        ans[i][j] = Math.min(ans[i][j],ans[i-1][j]+1);
                    }

                    if(j>0){
                        ans[i][j] = Math.min(ans[i][j], ans[i][j-1]+1);
                    }
                }
            }
        }

        for(int i=mat.length-1;i>=0;i--){
            for(int j=mat[i].length-1;j>=0;j--){
                if(i<mat.length-1){
                    ans[i][j] = Math.min(ans[i][j],ans[i+1][j]+1);
                }

                if(j<mat[i].length-1){
                    ans[i][j] = Math.min(ans[i][j], ans[i][j+1]+1);
                }
            }
        }
        return ans;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int r,c,nr,nc;
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            r = point[0];
            c = point[1];

            for(int i=0;i<dir.length;i++){
                nr = point[0]+dir[i][0];
                nc = point[1]+dir[i][1];
                if(nr<0 || nc<0 || nr>=image.length || nc>=image[0].length
                        || image[r][c]!=image[nr][nc] || image[nr][nc]==newColor) continue;
                queue.offer(new int[]{nr,nc});
            }
            image[r][c] = newColor;
        }
        return image;
    }
    private double ans;
    public double myPow(double x, int n) {
        ans = 1;
        helper(x, n);
        return ans;
    }

    public void helper(double x, int n){
        if(x==0) {ans = 0; return;}
        if(n==0) {ans *= 1;return;}
        if((n&1) == 1)
            ans *= n<0? 1/x : x;
        helper(x*x, n/2);
    }

    class Pair{
        int val;
        int level;

        public Pair(int val, int level){
            this.val = val;
            this.level = level;
        }
    }

    public int trap(int[] height) {
//        return Math.max(helper(height), helper(reverseArray(height)));
        return helper(height);
    }


    private int helper(int[] height){
        int res = 0, start=0,end=0,sum=0, max=0;
        for(;start<height.length;start++){
            if(height[start]==0 && (start==0 || start==height.length-1)) continue;
            if(start>=end){
                res+=sum;
                end = findNextHeight(height, start+1, height[start]);
                max = end==-1? 0 : Math.min(height[start], height[end]);
                sum = 0;
            }
            if(end!=-1 && max>height[start]){
                sum+=max-height[start];
            }
        }
        return res;
    }
    private int[] reverseArray(int[] height) {
        int[] arr = new int[height.length];
        for(int i=height.length-1;i>=0;i--) arr[height.length-i-1] = height[i];
        return arr;
    }

    private int findNextHeight(int[] heights, int index, int height){
        if(index>=heights.length) return -1;
        int max = heights[index];
        int maxIndex = index;
        for(int i=index;i<heights.length;i++){
            if(heights[i]>=height)
                return i;
            if(max<=heights[i]){
                max = heights[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        Arrays.sort(growthRates);
        float max = growthRates[growthRates.length-1];
        return (int)Math.ceil(Math.log(Math.pow(10,9))/Math.log(max));

    }
}
