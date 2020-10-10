package edu.neu.xsz.leetcode.lcof.lcof31;

class Main {
    public static void main(String[] args) {
        System.out.println("Local test is starting! ");
        Solution solution = new Solution();

        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};

        boolean ret = solution.validateStackSequences(pushed, popped);

        System.out.println("answer: " + ret);


    }
}
