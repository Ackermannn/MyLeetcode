package edu.neu.xsz.leetcode.lcof.lcof63;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)  return 0;
        int lowest = prices[0];
        int max = 0;
        for (int i : prices) {
            max = Math.max(max, i - lowest);
            lowest = Math.min(lowest, i);

        }
        return max;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testSet = {
                {},
                {7, 1, 5, 3, 6, 4}, // 5
                {7, 6, 4, 3, 1}  // 0
        };
        int[] ansSet = {0, 5, 0};

        for (int i = 0; i < ansSet.length; i++) {
            System.out.println("=========================================================");
            System.out.println("test nums: " + Arrays.toString(testSet[i]));

            int ret = sol.maxProfit(testSet[i]);
            System.out.println("my result: " + ret);

            int ans = ansSet[i];
            System.out.println("real answer: " + ans);

            if (ret == ans) System.out.println("correct √ ");
            else System.out.println("wrong ×");

        }

    }
}