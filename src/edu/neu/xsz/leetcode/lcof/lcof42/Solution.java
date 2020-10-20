package edu.neu.xsz.leetcode.lcof.lcof42;


public class Solution {
    public int maxSubArray(int[] nums) {
        // 动态规划
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        // 找最大
        return max;

    }
}
