package edu.neu.xsz.leetcode.algorithms._048_旋转图像;

import java.util.Arrays;

public class Solution {
    /**
     * 交换
     * @param matrix 矩阵
     * @param i1 坐标1 的横坐标
     * @param j1 坐标1 的纵坐标
     * @param i2 坐标2 的横坐标
     * @param j2 坐标2 的纵坐标
     */
    void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public void rotate(int[][] matrix) {

        // 转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // 对称
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                swap(matrix, i, j, i, matrix.length - 1 - j);
            }
        }

    }
}

class Main {

    public static void printMatrix(int[][] matrix){
        for (var x : matrix) {
            System.out.println(Arrays.toString(x));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Origin: ");
        printMatrix(matrix);

        solution.rotate(matrix);

        System.out.println("After rotate: ");
        printMatrix(matrix);


    }

}