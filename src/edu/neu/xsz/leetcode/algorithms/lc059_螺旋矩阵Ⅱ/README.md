# Question

给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

		输入: 3
		输出:
		[
		 [ 1, 2, 3 ],
		 [ 8, 9, 4 ],
		 [ 7, 6, 5 ]
		]

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/spiral-matrix-ii

# Code
```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int i = 0; // 横坐标
        int j = 0; // 纵坐标

        String mod = "right";
        int right_border = n - 1;
        int left_border = 0;
        int up_border = 0;
        int down_border = n - 1;
        for (int val = 1; val <= Math.pow(n, 2); val++) {
            result[i][j] = val;
            switch (mod) {
                case "right":
                    ++j;
                    if (j == right_border) {
                        mod = "down";
                        ++up_border;
                    }
                    break;
                case "down":
                    ++i;
                    if (i == down_border) {
                        mod = "left";
                        --right_border;
                    }
                    break;
                case "left":
                    --j;
                    if (j == left_border) {
                        mod = "up";
                        --down_border;
                    }
                    break;
                case "up":
                    --i;
                    if (i == up_border) {
                        mod = "right";
                        ++left_border;
                    }
                    break;
            }
        }
        return result;
    }
}
```