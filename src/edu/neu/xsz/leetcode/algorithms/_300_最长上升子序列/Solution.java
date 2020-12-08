package edu.neu.xsz.leetcode.algorithms._300_最长上升子序列;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        int maxAns = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxAns = Math.max(dp[i], maxAns);
        }
        return maxAns;

    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};//4
        int[] nums = {7, 7, 7, 7, 7}; //1
//        int[] nums = {4, 10, 4, 3, 8, 9};//3
//        int[] nums = {0, 1, 0, 3, 2, 3};//4
//        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};//6
//        int[] nums = {};//0


        int ret = sol.lengthOfLIS(nums);
        System.out.println("===========================");
        System.out.println(Arrays.toString(nums));
        System.out.println("Answer: ");
        System.out.println(ret);
    }
}
