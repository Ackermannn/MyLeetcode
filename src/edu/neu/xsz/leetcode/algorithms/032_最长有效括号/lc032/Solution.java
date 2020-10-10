package lc032;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 动态规划
 */
class Solution implements ISolution {
    /*返回数组最大值*/
    public int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int x : nums) max = Math.max(max, x);
        return max;
    }

    @Override
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length() + 1]; // dp[i] 存放必须包含到i的区间最长有效括号
        Deque<Integer> stack = new ArrayDeque<>();
        for (int p = 0; p < s.length(); p++) {
            if (s.charAt(p) == '(') {
                stack.push(p);
            } else { // ')'
                if (stack.size() > 0) {
                    int poped = stack.pop();
                    dp[p + 1] = p - poped + 1 + dp[poped];
                }
            }
        }
        return getMax(dp);
    }
}
