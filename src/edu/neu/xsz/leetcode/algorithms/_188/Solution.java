package edu.neu.xsz.leetcode.algorithms._188;

/**
 * Solution
 * author: DownUpZ
 * create: 2020/12/28 上午 9:37
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[2][k + 1][prices.length];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < k + 1; j++) {

                int tempMax1 = 0;
                for (int l = 0; l <= j; l++) {
                    tempMax1 = Math.max(dp[1][l][i - 1], tempMax1);
                }
                for (int l = 0; l <= j - 1; l++) {
                    tempMax1 = Math.max(dp[0][l][i - 1], tempMax1);
                }
                dp[1][j][i] = tempMax1;

                dp[0][j][i] = Math.max(dp[1][j][i - 1], dp[0][j][i - 1]);
            }
        }
        return dp[0][k][prices.length - 1];

    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int k = 2;
        int[] prices = {2, 4, 1};
        int ret = sol.maxProfit(k, prices);
        System.out.println(ret);

    }
}