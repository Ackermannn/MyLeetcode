package edu.neu.xsz.leetcode.lcof.lcof10II;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testCase = {44,  //   134903163
                          46}; //

        for(int x:testCase){

            System.out.println(solution.numWays(x));

        }
    }
}
