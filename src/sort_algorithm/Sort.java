package sort_algorithm;

/**
 * 排序接口
 */
public interface Sort {
    /**
     *
     * @param nums 要求排序的数组
     */
    void sort(int[] nums);

    /**
     * 原地交换
     * @param nums 需要交换的数组
     * @param idxA 需要交换的指针A
     * @param idxB 需要交换的指针B
     */
    default void swap(int[] nums, int idxA, int idxB) {
        int temp;
        temp = nums[idxA];
        nums[idxA] = nums[idxB];
        nums[idxB] = temp;
    }
}
