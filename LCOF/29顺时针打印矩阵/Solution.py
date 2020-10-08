from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        ans = []
        while len(matrix) > 0:
            ans = ans + matrix[0]  # 输出第一行
            matrix = self.rotate(matrix)

        return ans

    def rotate(self, matrix):
        newMatrix = []
        row = len(matrix)
        col = len(matrix[0])

        for j in range(col - 1, -1, -1):
            temp = []
            for i in range(1, row):
                temp.append(matrix[i][j])
            newMatrix.append(temp)
        return newMatrix


if __name__ == '__main__':
    test_cases = [
        [[1, 2, 3], [4, 5, 6], [7, 8, 9]],
        [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
    ]
    for n in test_cases:
        solution = Solution()
        print(solution.spiralOrder(n))
