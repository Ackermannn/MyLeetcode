"""
数学方法

题目地址：
https://leetcode-cn.com/problems/jian-sheng-zi-lcof/

"""
class Solution:
    def cuttingRope(self, n: int) -> int:
        ans = 1
        if n == 2: return 1
        if n == 3: return 2
        if n == 4: return 4
        while n > 4:
            n = n - 3
            ans = ans * 3
        return ans * n


if __name__ == '__main__':
    solution = Solution()

    test_cases = [2,  # 1
                  10]  # 36

    for n in test_cases:
        ret = solution.cuttingRope(n)
        print(ret)
