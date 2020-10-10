package edu.neu.xsz.leetcode.algorithms.lc059_螺旋矩阵Ⅱ;

import java.util.Arrays;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int i = 0; // 横坐标
        int j = 0; // 纵坐标

        String mod = "right";
        int right_border = n - 1;
        int left_border = 0;
        int up_border = 0;
        int down_border = n - 1;
        for (int val = 1; val <= Math.pow(n, 2); val++) {
            result[i][j] = val;
            switch (mod) {
                case "right":
                    ++j;
                    if (j == right_border) {
                        mod = "down";
                        ++up_border;
                    }
                    break;
                case "down":
                    ++i;
                    if (i == down_border) {
                        mod = "left";
                        --right_border;
                    }
                    break;
                case "left":
                    --j;
                    if (j == left_border) {
                        mod = "up";
                        --down_border;
                    }
                    break;
                case "up":
                    --i;
                    if (i == up_border) {
                        mod = "right";
                        ++left_border;
                    }
                    break;
            }
        }
        return result;
    }

    // output
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        int[][] res = s.generateMatrix(n);
        System.out.println(Arrays.deepToString(res));
    }
}
