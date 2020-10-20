package edu.neu.xsz.leetcode.lcof.lcof42;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start test Offer42...");

        Solution solution = new Solution();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int ret = solution.maxSubArray(nums);

        System.out.println("result is: " + ret);

    }
}
