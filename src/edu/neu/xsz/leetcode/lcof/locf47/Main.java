package edu.neu.xsz.leetcode.lcof.locf47;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        int ret = solution.maxValue(grid);
        System.out.println("The result is: "+ret);
    }
}
