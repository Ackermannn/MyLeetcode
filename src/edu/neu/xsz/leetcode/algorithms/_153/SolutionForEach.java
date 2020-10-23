package edu.neu.xsz.leetcode.algorithms._153;

/**
 * 遍历法
 */
class SolutionForEach implements Solution {

    @Override
    public int findMin(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        for (int x : nums) {
            minNum = Math.min(x, minNum);
        }
        return minNum;
    }
}
