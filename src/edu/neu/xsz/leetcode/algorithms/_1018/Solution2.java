package edu.neu.xsz.leetcode.algorithms._1018;

import java.util.ArrayList;
import java.util.List;

/**
 * create time: 2021/1/14 上午 10:29
 *
 * @author DownUpZ
 */
class Solution2 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();

        int num = 0;
        for (int j : A) {
            num <<= 1;
            num += j;
            num %= 10;
            ans.add(num % 5 == 0);
        }

        return ans;
    }
}