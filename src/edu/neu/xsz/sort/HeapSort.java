package edu.neu.xsz.sort;

/**
 * 堆排序，大话数据结构P399 P400
 */
public class HeapSort implements Sort {
    @Override
    public void sort(int[] nums) {
        int i;
        for (i = nums.length / 2; i > 0; i--) {
            heapAdjust(nums, i, nums.length - 1);
        }
        for (i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapAdjust(nums, 0, i - 1);
        }
    }

    protected void heapAdjust(int[] nums, int s, int len) {
        int temp = nums[s];
        int j;
        for (j = 2 * s; j <= len; j *= 2) {
            if (j < len && nums[j] < nums[j + 1]) ++j; /*j为关键字中较大的记录的下标*/
            if (temp >= nums[j]) break; // rc应插入在位置s上
            nums[s] = nums[j];
            s = j;
        }
        nums[s] = temp; // 插入
    }
}
