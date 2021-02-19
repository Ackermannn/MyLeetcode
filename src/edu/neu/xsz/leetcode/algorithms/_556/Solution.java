package edu.neu.xsz.leetcode.algorithms._556;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        int m = nums[0].length;
        int idx;
        if (n * m == r * c) {
            int[][] ans = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    idx = i * c + j;
                    ans[i][j] = nums[idx / m][idx % m];
                }
            }
            return ans;
        } else {
            return nums;
        }
    }
}