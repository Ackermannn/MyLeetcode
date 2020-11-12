package edu.neu.xsz.leetcode.lcof.lcof53_2;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] nums = {0,2,3};
        int[][] test_set = {
                {0, 2, 3},
                {0, 1, 2},
                {0, 1, 2, 3, 4, 5, 6, 7, 9}
        };

        for (int[] nums : test_set) {
            int ret = sol.missingNumber(nums);
            System.out.println("input nums is: " + Arrays.toString(nums));
            System.out.println("answer is: " + ret);
        }
    }
}
