package lc041;

import java.util.Arrays;

public class Solution implements ISolution {
    /**
     * 有排序的方法 不符合题目要求
     */
    @Override
    public int firstMissingPositive(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || (i != nums.length - 1 && nums[i] == nums[i + 1])) continue;
            if (nums[i] == ans) ans++;
            else break;
        }
        return ans;
    }
}
