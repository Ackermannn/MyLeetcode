package edu.neu.xsz.leetcode.lcof.lcof49;

/**
 * 三指针法
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        for (int i = 2; i < n + 1; i++) {
            int n2 = dp[p2] * 2;
            int n3 = dp[p3] * 3;
            int n5 = dp[p5] * 5;

            if (n2 <= n3 && n2 <= n5) {
                dp[i] = n2;
                p2++;
            }
            if (n3 <= n2 && n3 <= n5) {
                dp[i] = n3;
                p3++;
            }
            if (n5 <= n3 && n5 <= n2) {
                dp[i] = n5;
                p5++;
            }
        }
        return dp[n];
    }
}
