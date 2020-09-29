class Solution:
    def fib(self, n: int) -> int:
        dp = [0, 1]
        if n == 0: return dp[0]
        if n == 1: return dp[1]
        else:
            for i in range(2, n+1):
                dp.append(dp[i-1] + dp[i-2])

        return dp[-1] % int(1e9+7)

if __name__ == '__main__':
    sol = Solution()
    ret = sol.fib(5)

    print(ret)