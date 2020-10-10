package edu.neu.xsz.leetcode.algorithms.动态规划DynamicProgramming.lc322_零钱兑换;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = {1,2};
        int amount = 36;
        System.out.println(s.coinChange(coins,amount));
    }
}
