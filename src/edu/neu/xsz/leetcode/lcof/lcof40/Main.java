package edu.neu.xsz.leetcode.lcof.lcof40;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        Solution2 solution = new Solution2();

        int[] arr = {3, 2, 1};
        int k = 2;

        int[] ret = solution.getLeastNumbers(arr, k);

        System.out.println(Arrays.toString(ret));

    }
}
