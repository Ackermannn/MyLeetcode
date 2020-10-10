package edu.neu.xsz.leetcode.algorithms.数组.lc074_搜索二维矩阵_tag二分查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;

        int first = -1; // 头指针在0前面
        int last = m * n; // 尾指针在最后一个元素后面

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        while (last - first > 1) {
            int mid = (last + first) / 2;
            int i = mid / n;
            int j = mid % n;

            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                last = mid;
            } else if (target > matrix[i][j])
                first = mid;
        }
        return false;

    }

    public boolean searchMatrixVersionOne(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;

        List<Integer> list = new ArrayList<>();
        for (int[] line : matrix) {
            for (int a : line)
                list.add(a);
        }
        return list.contains(target);


    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int t = 50;
        boolean res = s.searchMatrix(mat, t);
        System.out.println(res);
    }
}
