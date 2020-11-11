package edu.neu.xsz.leetcode.lcof.lcof53_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution2();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int ret = sol.search(nums, target);
        System.out.println("target is:" + target);
        System.out.println("nums is: " + Arrays.toString(nums));
        System.out.println("Answer is: " + ret);

    }
}
