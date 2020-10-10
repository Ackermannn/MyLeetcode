package edu.neu.xsz.leetcode.algorithms.数组.lc073矩阵置零;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length; // 行数
        if (m == 0) return;
        int n = matrix[0].length; // 列数
        Set<Integer> rowZero = new HashSet<>();
        Set<Integer> colZero = new HashSet<>();

        // 找出有零的地方,这样的坐标放进set中
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowZero.add(i);
                    colZero.add(j);
                }
            }
        }


        for (Integer integer : rowZero) {
            for (int j = 0; j < n; j++)
                matrix[integer][j] = 0;
        }
        for (Integer value : colZero) {
            for (int i = 0; i < m; i++)
            matrix[i][value] = 0;
        }

    }

}

class Main {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        Solution s = new Solution();
        s.setZeroes(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}