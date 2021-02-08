package edu.neu.xsz.leetcode.algorithms._128;

import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        if (nums.length == 0) return 0;

        // 排序先
        Arrays.sort(nums);

        int curCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] ) continue; // 去重复

            if (nums[i] == nums[i - 1] + 1) curCount++;
            else {
                ans = Math.max(ans, curCount);
                curCount = 1;
            }
        }
        ans = Math.max(ans, curCount);
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int ret = sol.longestConsecutive(nums);
        System.out.println(ret);
    }
}