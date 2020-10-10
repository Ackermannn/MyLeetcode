package edu.neu.xsz.leetcode.lcof.lcof17;

/*
* 看评论区，此题在剑指offer 上难度很高
*
* */
class Solution {
    public int[] printNumbers(int n) {
        int count = (int) Math.pow(10, n) - 1;
        int[] ans = new int[count];
        for (int i = 0; i < count; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ret = solution.printNumbers(6);
        for (int x : ret) {
            System.out.printf("%d,", x);
        }
    }

}