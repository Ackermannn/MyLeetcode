package edu.neu.xsz.leetcode.algorithms._279;

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 动态规划的数组
        for (int i = 1; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1, d = 1; j <= i; ++d, j = d * d)
                dp[i] = Math.min(dp[i], dp[i - j] + 1); // f(n) = min{  f(n-i) } + 1 , i为平方数
        }
        return dp[n];
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int ret = solution.numSquares(13);
        System.out.println(ret);
    }
}
