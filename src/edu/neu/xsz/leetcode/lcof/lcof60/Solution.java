package edu.neu.xsz.leetcode.lcof.lcof60;


import java.util.Arrays;

public class Solution {

    public int[] dicesCount(int n) {
        if (n == 1) return new int[]{1, 1, 1, 1, 1, 1};
        int[] lastAns = dicesCount(n - 1);
        int[] newAns = new int[6 * n - n + 1];
        for (int j = 0; j < newAns.length; j++) {
            for (int k = 0; k < lastAns.length; k++) {
                if (k <= j && j - k < 6) {
                    newAns[j] += lastAns[k];
                }
            }
        }
        return newAns;
    }

    public double[] dicesProbability(int n) {
        int[] ans = dicesCount(n);
        double[] doubles = new double[ans.length];
        for (int i = 0; i < doubles.length; i++) doubles[i] = ans[i] / Math.pow(6.0, n);
        return doubles;
    }
}




class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] testSet = {
//                1,
                2,
//                3
        };

        for (int j : testSet) {
            System.out.println("=========================================================");
            System.out.println("test nums: " + j);

            double[] ret = sol.dicesProbability(j);
            System.out.println("my result: " + Arrays.toString(ret));

        }
    }
}
