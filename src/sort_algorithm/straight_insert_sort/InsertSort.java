package sort_algorithm.straight_insert_sort;

import sort_algorithm.Sort;

/**
 * 直接插入排序，大话数据结构P386
 */
public class InsertSort implements Sort {
    @Override
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) { // 发现逆序
                int temp = nums[i];
                int j;
                for (j = i - 1; j >= 0 && nums[j] > temp; j--) {
                    nums[j + 1] = nums[j];
                }
                nums[++j] = temp;
            }

        }
    }
}
