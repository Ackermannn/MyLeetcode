package edu.neu.lc075;
/**
 * question
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * 官方题解
 * https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode/
 */

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len == 0) return;

        int left = 0;
        int right = len - 1;
        int mid = left;
        while (mid <= right) {
            if(nums[mid] == 0) {
                if (mid > left)
                    swap(nums, left++, mid);
                else {
                    left++;
                    mid++;
                }

            }
            else if (nums[mid] == 1){
                mid++;
            }
            else{ // is 2
                swap(nums,mid,right--);
            }

        }


    }
    public static void swap(int[] data, int a, int b) {
        int t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution s = new Solution();
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
