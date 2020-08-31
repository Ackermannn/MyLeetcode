package sort_algorithm.bubble;

import sort_algorithm.Sort;

/**
 * 正宗的冒泡排序
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }


}
