package edu.neu.xsz.leetcode.lcof.lcof44;

/**
 * 超出内存限制
 */
class Solution {
    public int findNthDigit(int n) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while (sb.length() <= n){
            sb.append(num);
            num++;

        }
        return Integer.parseInt(String.valueOf(sb.charAt(n)));
    }
}
