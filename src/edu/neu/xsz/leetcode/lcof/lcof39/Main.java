package edu.neu.xsz.leetcode.lcof.lcof39;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        int ret = solution.majorityElement(nums);

        System.out.println("The majority element in nums is: " + ret);
    }
}
