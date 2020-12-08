package edu.neu.xsz.leetcode.algorithms._300_最长上升子序列.二分法;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int len = 0;
        for (int num: nums) {
            int idx = Arrays.binarySearch(res, 0, len, num);
            idx = idx < 0? -idx - 1: idx;
            res[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        return len;
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