package az.sanco.algorithms.leetcode;

import java.util.*;

/**
 * Created by sanco on 01.08.21.
 * algorithms
 */
public class Grid {
    public static void main(String[] args) {
        Grid g = new Grid();
        System.out.println(g.largestIsland(new int[][]{{1,0},{0,1}}));
        System.out.println(g.largestIsland(new int[][]{{0,0,0,0,0,0,0},
                {0,1,1,1,1,0,0},{0,1,0,0,1,0,0},
                {1,0,1,0,1,0,0},{0,1,0,0,1,0,0},
                {0,1,0,0,1,0,0},{0,1,1,1,1,0,0}}));
        System.out.println(g.largestIsland(new int[][]{{1,1},{1,1}}));
        System.out.println(g.largestIsland(new int[][]{{1,0,1},{0,0,0},{0,1,1}}));
    }
    public int largestIsland(int[][] grid) {
        if(grid.length==1) return 1;
        boolean hasZero = false;
        int n = grid.length;
        int ans = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        int index = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    index = i*n+j+2;
                    countMap.put(index, dfs(grid, i, j, index));
                }
                if(grid[i][j]==0 &&!hasZero)
                    hasZero = true;
            }
        }
        Set<Integer> indexSet = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 && hasOneNeighbor(grid, i, j)){
                    int sum = 0;
                    if(i>0 && grid[i-1][j]!=0){
                        indexSet.add(grid[i-1][j]);
                    }
                    if(j>0 && grid[i][j-1]!=0){
                        indexSet.add(grid[i][j-1]);
                    }
                    if(i<n-1 && grid[i+1][j]!=0){
                        indexSet.add(grid[i+1][j]);
                    }
                    if(j<n-1 && grid[i][j+1]!=0){
                        indexSet.add(grid[i][j+1]);
                    }
                    for(int idx: indexSet){
                        sum+=countMap.getOrDefault(idx,0);
                    }
                    ans = Math.max(ans, sum);
                    indexSet.clear();
                }
            }
        }

        return hasZero? ans+1 : n*n;
    }

    private boolean hasOneNeighbor(int[][] grid, int i, int j){
        return (i>0 && grid[i-1][j]!=0) ||
                (j>0 && grid[i][j-1]!=0) ||
                (i<grid.length-1 && grid[i+1][j]!=0) ||
                (j<grid.length-1 && grid[i][j+1]!=0);
    }

    private int dfs(int[][] grid, int i, int j, int index){
        if(i<0 || j<0 || i>=grid.length || j>= grid.length || grid[i][j]!=1) return 0;
        grid[i][j] = index;
        return 1+ dfs(grid,i,j-1, index)+dfs(grid,i-1,j, index) +
                dfs(grid, i,j+1, index)+dfs(grid,i+1,j,index);
    }
}
