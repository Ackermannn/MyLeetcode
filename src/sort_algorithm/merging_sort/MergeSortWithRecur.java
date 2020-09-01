package sort_algorithm.merging_sort;

import sort_algorithm.Sort;

import java.util.Arrays;

public class MergeSortWithRecur implements Sort {
    private int[] nums;

    @Override
    public void sort(int[] nums) {
        this.nums = nums;
        int left = 0;
        int right = this.nums.length;
        MSort(left, right);
    }

    protected void MSort(int left, int right) {
        // 分两半
        if (right - left <= 1) return;
        int mid = (left + right - 1) / 2;
        // 分开后递归调用
        MSort(left, mid);
        MSort(mid, right);
        // 合并
        merge(left, mid, right);
    }

    protected void merge(int num1Left, int mid, int num2Right) {
        // 复制出来
        int[] nums1Copy = Arrays.copyOfRange(nums, num1Left, mid);
        int[] nums2Copy = Arrays.copyOfRange(nums, mid, num2Right);

        int num1Head = 0;
        int num2Head = 0;
        for (int i = num1Left; i < num2Right; i++) { // 对要并归的区间合并
            if (num1Head < nums1Copy.length && num2Head < nums2Copy.length) {// 如果两个数组都没空的时候，谁小赋值谁
                if (nums1Copy[num1Head] <= nums2Copy[num2Head]) {
                    nums[i] = nums1Copy[num1Head++];
                } else
                    nums[i] = nums2Copy[num2Head++];
            } else if (num1Head == nums1Copy.length) { // nums1满了， 后面全部赋值 nums2
                nums[i] = nums2Copy[num2Head++];
            } else if (num2Head == nums2Copy.length) {// nums2满了， 后面全部赋值 nums1
                nums[i] = nums1Copy[num1Head++];

            }
        }


    }
}
