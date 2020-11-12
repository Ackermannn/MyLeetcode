package edu.neu.xsz.leetcode.lcof.lcof53_2;

class Solution {
    public int missingNumber(int[] nums) {
        /*二分法*/
        int left = 0;
        int right = nums.length;
        int mid = 0;

        if (nums[0] == 1) return 0;
        if (nums[nums.length - 1] == nums.length - 1) return nums.length;

        while (right > left) {
            mid = (left + right) / 2;
            if (nums[mid] == mid) left = mid + 1; // 结果一定在右边
            else {
                if (nums[mid - 1] == (mid - 1)) return mid;
                else right = mid;
            }
        }
        return mid;

    }
}
