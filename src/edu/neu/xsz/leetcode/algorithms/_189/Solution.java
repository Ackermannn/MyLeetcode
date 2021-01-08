package edu.neu.xsz.leetcode.algorithms._189;

/**
 * Solution
 * author: DownUpZ
 * create: 2021/1/8 上午 10:02
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int idx = nums.length - 1 - k; idx >= 0; idx--) {
            // 每次移动一位
            int temp = nums[idx];
            for (int i = 0; i < k; i++) {
                nums[idx + i] = nums[idx + i + 1];
            }
            nums[idx + k] = temp;
        }
    }
}
