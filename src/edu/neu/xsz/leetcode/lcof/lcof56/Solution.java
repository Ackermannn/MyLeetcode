package edu.neu.xsz.leetcode.lcof.lcof56;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class Solution {

    public int[] singleNumbers(int[] nums) {
        int[] ans = new int[2];
        int a = 0, bit = 0;

        for (int x : nums) a ^= x; // 全体的亦或就是 所求的两个数的亦或
        for (; a % 2 != 1; bit++) a >>= 1; // 找到一个不同的位

        for (int x : nums) { // 依据不同的位分组, 各自的组进行亦或
            if ((x >> bit) % 2 == 1) ans[0] ^= x;
            else ans[1] ^= x;
        }
        return ans;
    }
}
