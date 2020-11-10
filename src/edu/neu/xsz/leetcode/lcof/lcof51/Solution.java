package edu.neu.xsz.leetcode.lcof.lcof51;

import java.util.Arrays;

// 题目地址：
// https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
public class Solution {
    private int ans = 0; // 存储答案

    public int reversePairs(int[] nums) {
        if (nums.length <= 1) return ans;
        mergeSort(nums);
        return this.ans;
    }

    /**
     * 归并排序
     */
    public void mergeSort(int[] nums) {
        int len = nums.length;
        if (nums.length <= 1) return;

        // 分出去两半
        int[] left = new int[len / 2];
        int[] right = new int[len - len / 2];
        int i = 0;
        for (; i < left.length; i++) {
            left[i] = nums[i];
        }
        for (int j = 0; j < right.length; j++, i++) {
            right[j] = nums[i];
        }

        // 递归调用
        mergeSort(left);
        mergeSort(right);

        // 归并排序
        int pl = 0; // 左指针
        int pr = 0; // 右指针
        for (int k = 0; k < len; k++) {
            if (pl < left.length && (pr >= right.length || left[pl] <= right[pr])) {
                nums[k] = left[pl];
                pl++;
            } else {
                nums[k] = right[pr];
                this.ans += left.length - pl;  // 对逆序进行计数
                pr++;
            }
        }




    }
}


