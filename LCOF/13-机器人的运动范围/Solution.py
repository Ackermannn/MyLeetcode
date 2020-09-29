"""
题目地址

https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/

"""
class Solution:

    def movingCount(self, m: int, n: int, k: int) -> int:
        self.map_ = [[0 for i in range(n)] for j in range(m)]
        # self.map_[0][0] = 0
        self.k = k
        self.m = m
        self.n = n
        self.recuir(0, 0)
        print(self.map_)
        ans = 0
        for i in self.map_:
            ans = ans + sum(i)
        return ans

    def recuir(self, i, j):
        sum_ = 0
        for x in list(str(i)):
            sum_ = sum_ + int(x)
        for x in list(str(j)):
            sum_ = sum_ + int(x)
        if sum_ <= self.k and self.map_[i][j] == 0:
            self.map_[i][j] = 1
            if i != 0:
                self.recuir(i - 1, j)
            if i != self.m - 1:
                self.recuir(i + 1, j)
            if j != 0:
                self.recuir(i, j - 1)
            if j != self.n - 1:
                self.recuir(i, j + 1)


if __name__ == '__main__':
    solution = Solution()

    # 1
    m = 3
    n = 1
    k = 0

    #  #3
    # m = 2
    # n = 3
    # k = 1
    ret = solution.movingCount(m, n, k)
    print(ret)
