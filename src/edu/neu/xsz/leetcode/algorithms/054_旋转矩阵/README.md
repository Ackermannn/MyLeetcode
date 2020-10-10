# 题目

给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:

    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
  
输出: 


    [1,2,3,6,9,8,7,4,5]
  
示例 2:

输入:

    [
      [1, 2, 3, 4],
      [5, 6, 7, 8],
      [9,10,11,12]
    ]
  
输出: 

    [1,2,3,4,8,12,11,10,9,5,6,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix

# 解答

我的题解[地址](https://leetcode-cn.com/problems/spiral-matrix/solution/ju-zhen-xuan-zhuan-da-yin-di-yi-xing-javayong-shi-/)


# code

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        while (true) {
            int row = matrix.length;
            if (row == 0) return res;
            int col = matrix[0].length;

            // 打出第一行
            for (Integer i : matrix[0]) res.add(i);
            // 旋转
            int[][] rotate = new int[col][row - 1];
            for (int j = col - 1; j >= 0; j--) 
                for (int i = 1; i < row; i++) 
                    rotate[col - 1 - j][i - 1] = matrix[i][j];
            
            matrix = rotate;
        }

    }
}


```
