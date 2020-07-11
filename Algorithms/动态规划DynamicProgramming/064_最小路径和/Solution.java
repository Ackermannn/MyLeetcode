package edu.neu.lc064;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int res = 0;
        int m = grid.length; // 行数
        if (m == 0) return 0;
        int n = grid[0].length; // 列数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (j == 0) grid[i][j] += grid[i - 1][j]; // 如果在矩阵的最左边一列
                else if (i == 0) grid[i][j] += grid[i][j - 1];
                else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        Solution s = new Solution();
        int res = s.minPathSum(grid);
        System.out.println(res);
    }
}
