package edu.neu.xsz.leetcode.lcof.lcof39;

// 摩尔投票法最容易理解的解答如下：
// https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/584421

public class Solution {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int votes = 0;

        for (int x : nums) {
            if (votes == 0) {
                votes++;
                ans = x;
            } else {
                if (x != ans) votes--;
                else votes++;
            }

        }
        return ans;

    }
}
