package edu.neu.xsz.leetcode.algorithms._1018;

import java.util.ArrayList;
import java.util.List;

/**
 * create time: 2021/1/14 上午 10:00
 *
 * @author DownUpZ
 */
public class Solution {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();
        int temp;
        for (int i = 0; i < A.length; i++) {
            if (i == 0)
                temp = A[0];
            else
                temp = (dp.get(i - 1) * 2 + A[i]) % 5;

            dp.add(temp);
            ans.add(temp == 0);
        }
        return ans;
    }
}
