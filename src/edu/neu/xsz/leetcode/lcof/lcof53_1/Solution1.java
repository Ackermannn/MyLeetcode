package edu.neu.xsz.leetcode.lcof.lcof53_1;

/*
遍历法
 */
public class Solution1 implements Solution{
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) count++;
            else if (nums[i] > target) break;

        }
        return count;
    }
}
