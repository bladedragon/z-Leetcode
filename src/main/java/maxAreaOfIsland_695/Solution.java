package maxAreaOfIsland_695;

import java.util.Arrays;

public class Solution {


    int[][] steps = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int maxAreaOfIsland(int[][] grid){
        if (grid.length == 0) {
            return 0;
        }
        int[][] marks = new int[grid.length][grid[0].length];
        for (int[] mark : marks) {
            Arrays.fill(mark, 0);
        }
        int maxArea =0;
        int curArea = 0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[i].length;j++){
                int area = dfs(grid,marks,i,j);
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int[][] marks, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if(marks[i][j] != 1 && grid[i][j] == 1){
            marks[i][j] = 1;
           int cur = 1;
            for(int[] step :steps) {
                cur+= dfs(grid, marks, i + step[0], j + step[1]);
            }
            return cur;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(s.maxAreaOfIsland(matrix));
    }
}
