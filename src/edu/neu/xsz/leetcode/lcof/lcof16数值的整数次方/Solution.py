class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            return 1.0 / self.myPow(x, -1 * n)
        elif n == 0:
            return 1
        else:
            ans = x
            bit = 1
            while bit * 2 <= n:
                ans = ans * ans
                bit = bit * 2
            return ans * self.myPow(x, n - bit)


if __name__ == '__main__':
    solution = Solution()

    test_cases = [[2.0, 10],  # 1024.00000
                  [2.1, 3],  # 9.26100
                  [2.0, -2],  # 0.25000
                  ]

    for n in test_cases:
        ret = solution.myPow(n[0], n[1])
        print(ret)
