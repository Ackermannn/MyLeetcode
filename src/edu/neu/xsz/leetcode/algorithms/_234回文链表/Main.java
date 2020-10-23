package edu.neu.xsz.leetcode.algorithms._234回文链表;

import edu.neu.xsz.datastruct.ListNode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] nums = new int[]{1, 2};
        //  {1, 2, 2, 1}
        // {-129, -129}

        int[][] test_set = new int[][]{
                {1, 2},
                {1, 2, 2, 1},
                {-129, -129}
        };

        for (var nums : test_set) {
            System.out.println("The test is: ");
            System.out.println(Arrays.toString(nums));
            boolean ret = sol.isPalindrome(ListNode.createListNodes(nums));
            System.out.println("The result is:");
            System.out.println(ret);
            System.out.println("");
            System.out.println("");
        }

    }
}
