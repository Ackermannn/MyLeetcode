package edu.neu.xsz.leetcode.algorithms._221_最大正方形;

/*
https://leetcode-cn.com/problems/maximal-square/comments/104426
* */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length; // 长
        int n = matrix[0].length; // 宽
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '0') {
                    if (i == 0 || j == 0) dp[i][j] = matrix[i][j] - '0';
                    else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans * ans;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

//        char[][] matrix = {{'0', '1'},
//                            {'1', '0'}};
        int ret = sol.maximalSquare(matrix);
        System.out.println(ret);

    }
}
