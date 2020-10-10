# 问题

编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字`1-9`在每一行只能出现一次。
数字`1-9`在每一列只能出现一次。
数字`1-9`在每一个以粗实线分隔的`3x3`宫内只能出现一次。
空白格用`'.'`表示。

![](http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)

一个数独。

![](http://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png)

答案被标成红色。

**Note:**

    给定的数独序列只包含数字`1-9`和字符`'.'`。
    你可以假设给定的数独只有唯一解。
    给定数独永远是`9x9`形式的。

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/sudoku-solver

# 解答

回溯法

## code
```python
from typing import List
"""
解数独
"""
class Solution:
    def __int__(self):
        self.board = None

    def get_choice(self, i: int, j: int) -> set:
        """获取可以选择的数字"""
        ans = set(range(1, 10))

        for x in self.board[i]:  # 排除行中已经有的
            if x != '.' and int(x) in ans:
                ans.remove(int(x))

        for k in range(9):  # 排除列中已经有的
            x = self.board[k][j]
            if x != '.' and int(x) in ans:
                ans.remove(int(x))

        for u in range(i - i % 3, i - i % 3 + 3):  # 排除 3*3 宫格
            for v in range(j - j % 3, j - j % 3 + 3):
                x = self.board[u][v]
                if x != '.' and int(x) in ans:
                    ans.remove(int(x))

        return ans

    def get_blank(self):
        for i in range(9):
            for j in range(9):
                if self.board[i][j] == ".":
                    x = i
                    y = j
                    return x, y
        return -1, -1

    def solveSudoku(self, _board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.board = _board
        self.recur()

    def recur(self):
        x, y = self.get_blank()
        if x == -1 and y == -1:
            return True

        nums = self.get_choice(x, y)
        if len(nums) != 0:
            for num in nums:
                self.board[x][y] = str(num)
                if self.recur():
                    return True
                self.board[x][y] = "."

```