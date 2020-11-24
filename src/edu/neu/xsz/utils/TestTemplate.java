package edu.neu.xsz.utils;
import java.util.Arrays;

public class TestTemplate {
    public static void main(String[] args) {
        ExampleSolution sol = new ExampleSolution();

        int[][] testSet = {
                {},
                {7, 1, 5, 3, 6, 4}, // 5
                {7, 6, 4, 3, 1}  // 0
        };
        int[] ansSet = {0, 5, 0};

        for (int i = 0; i < ansSet.length; i++) {
            System.out.println("=========================================================");
            System.out.println("test nums: " + Arrays.toString(testSet[i]));

            int ret = sol.maxProfit(testSet[i]);
            System.out.println("my result: " + ret);

            int ans = ansSet[i];
            System.out.println("real answer: " + ans);

            if (ret == ans) System.out.println("correct √ ");
            else System.out.println("wrong ×");

        }

    }
}
/*
 _____                         _      _       _______
|  _  \   ___ _      _  __   _| |    | |____ |____   |
| |  \ \ / _ \ \ /\ / /|  \ | | |    | |  _ \    /  /
| |_ / /| (_) \ V  V / | |\\| |\ \_ / /|  __/  /   /__
|_____/  \___/ \_/\_/  |_| \__| \ _ _/ |_|    /_______|


 */