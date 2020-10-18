package edu.neu.xsz.leetcode.lcof.lcof40;

import java.util.Arrays;

/**
 * 排序法
 */
class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        if (k >= 0) System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }


}
