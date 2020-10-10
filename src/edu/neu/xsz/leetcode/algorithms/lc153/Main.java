package edu.neu.xsz.leetcode.algorithms.lc153;

class Main {
    public static void main(String[] args) {
//        Solution sol = new SolutionForEach();
        Solution sol = new SolutionBinarySearch();

//        int[] nums = new int[]{3, 4, 5, 1, 2};
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums = new int[]{};
        int ret = sol.findMin(nums);
        System.out.println(ret);


    }
}
