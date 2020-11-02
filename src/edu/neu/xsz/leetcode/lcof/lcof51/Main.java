package edu.neu.xsz.leetcode.lcof.lcof51;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {7,5,6,4};
        System.out.println("nums: ");

        System.out.println(Arrays.toString(nums));

        int ret = sol.reversePairs(nums);


        System.out.println("Answer: " + ret);
    }
}
