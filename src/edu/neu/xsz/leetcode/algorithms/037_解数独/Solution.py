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


if __name__ == '__main__':
    board = [["5", "3", ".", ".", "7", ".", ".", ".", "."],
             ["6", ".", ".", "1", "9", "5", ".", ".", "."],
             [".", "9", "8", ".", ".", ".", ".", "6", "."],
             ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
             ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
             ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
             [".", "6", ".", ".", ".", ".", "2", "8", "."],
             [".", ".", ".", "4", "1", "9", ".", ".", "5"],
             [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
    sol = Solution()
    sol.solveSudoku(board)

    print(board)
