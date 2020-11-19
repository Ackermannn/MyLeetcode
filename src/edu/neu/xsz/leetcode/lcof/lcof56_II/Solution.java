package edu.neu.xsz.leetcode.lcof.lcof56_II;

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        int temp;
        for (int x : nums) {
            temp = a;
            a = (x ^ a) & b;
            b = (x ^ b) & ~temp | a;
        }
        return b;
    }
}