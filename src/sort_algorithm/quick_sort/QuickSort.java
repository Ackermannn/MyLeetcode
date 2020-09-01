package sort_algorithm.quick_sort;

import sort_algorithm.Sort;

/**
 * 大话数据结构 P417 快速排序算法
 */
public class QuickSort implements Sort {
    private int[] nums;

    @Override
    public void sort(int[] nums) {
        this.nums = nums;
        QSort(0, nums.length);
    }

    protected void QSort(int start, int end) {
        // 一分为二的同时，实现旋转并返回中轴所在位置
        if (start < end) {
            int pivot = partition(start, end);
            QSort(start, pivot);
            QSort(pivot + 1, end);
        }
    }

    /**
     * 快排的关键函数，分隔函数
     *
     * @param start 要被分隔数组的起始下标
     * @param end   要被分隔数组的结束下标
     * @return 返回中枢所在位置
     */
    protected int partition(int start, int end) {
        int pivotKey = nums[start]; // 用子表的第一个记录作枢纽记录
        int low = start;
        int high = end - 1;
        while (low < high) {/*从表的两端交替向中间扫描*/

            // 将比中轴记录小的记录交换到低端
            while (low < high && nums[high] > pivotKey) high--;
            swap(nums, low, high);

            //将比中轴记录大的记录交换到高端
            while (low < high && nums[low] <= pivotKey) low++;
            swap(nums, low, high);

        }
        return low; // 返回中枢所在位置
    }
}
