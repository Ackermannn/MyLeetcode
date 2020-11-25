package edu.neu.xsz.leetcode.lcof.lcof66;

import java.util.Arrays;

public class Solution {
    public int[] constructArr(int[] a) {
        int[] ans = new int[a.length]; // 结果集初始化
        int[] leftArr = new int[a.length + 2];
        int[] rightArr = new int[a.length + 2];
        Arrays.fill(ans, 1);
        Arrays.fill(leftArr, 1);
        Arrays.fill(rightArr, 1);
        for (int i = 0; i < a.length; i++) leftArr[i + 1] = leftArr[i] * a[i];
        for (int i = a.length - 1; i >= 0; i--) rightArr[i + 1] = rightArr[i + 2] * a[i];
        for (int i = 0; i < ans.length; i++) ans[i] = leftArr[i] * rightArr[i + 2];
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        Solution sol = new Solution();

        int[] ret = sol.constructArr(nums);
        System.out.println(Arrays.toString(ret));
    }
}
