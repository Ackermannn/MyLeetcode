package sort_algorithm.simple_selection_sort;

import sort_algorithm.Sort;

public class SelectSort implements Sort {
    /**
     * 大话数据结构P384, 时间复杂度O(n^2)
     * @param nums 要求排序的数组
     */
    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) min = j;
            }
            if (i != min) swap(nums, i, min);


        }
    }
}
