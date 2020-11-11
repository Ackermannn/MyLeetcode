package edu.neu.xsz.leetcode.lcof.lcof53_1;

/*
二分法
 */
public class Solution2 implements Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return rightSearch(nums, target) - leftSearch(nums, target);
    }

    int leftSearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid;
        if (nums[0] == target) return left;

        while (right - left > 0) {
            mid = (right + left) / 2;
            if (nums[mid] > target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
            else {
                if (nums[mid - 1] != target) return mid;
                else right = mid;
            }
        }
        return left;
    }

    int rightSearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid;
        if (nums[right - 1] == target) return right;

        while (right - left > 0) {
            mid = (right + left) / 2;
            if (nums[mid] > target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
            else {
                if (nums[mid + 1] != target) return mid + 1;
                else left = mid + 1;
            }
        }
        return right;
    }
}
