package edu.neu.xsz.leetcode.algorithms._238;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int pro = 1;
        for (int i = res.length - 2; i >= 0; i--) {
            pro *= nums[i + 1];
            res[i] *= pro;
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] ret = sol.productExceptSelf(nums);
        System.out.println(Arrays.toString(ret));
    }
}
