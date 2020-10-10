package lc041;

class Solution2 implements ISolution {
    /**
     * 交换
     */
    void swap(int[] nums, int x, int y) {
        int temp;
        temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    /*
    swap的方法
    * */
    @Override
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (1 <= nums[i] && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }

        }
        int ans = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return ans;
    }
}
