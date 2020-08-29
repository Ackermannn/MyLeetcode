package lc153;

import java.lang.reflect.Array;

/**
 * 二分法
 */
public class SolutionBinarySearch implements Solution {

    @Override
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length;
        if (right == 1) return nums[0];
        int mid;
        while (right - left > 2) {
            if (nums[left] < nums[right - 1]) return nums[left]; // 如果没有旋转直接返回第一个。
            mid = (left + right) / 2;
            if (nums[mid] > nums[left]) { // 最小值可能在右半段
                left = mid;
            } else { // 在左半段
                right = mid + 1;
            }
        }

        return Math.min(nums[left], nums[left + 1]);

    }


}



