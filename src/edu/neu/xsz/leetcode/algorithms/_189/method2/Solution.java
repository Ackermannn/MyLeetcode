package edu.neu.xsz.leetcode.algorithms._189.method2;

import java.util.Arrays;

/**
 * Solution
 * author: DownUpZ
 * create: 2021/1/8 上午 10:24
 */
public class Solution { // 翻转法

    void reverse(int[] nums, int start, int end) {
        int n = end - start;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[start + i];
            nums[start + i] = nums[end - 1 - i];
            nums[end - 1 - i] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);
    }
}
