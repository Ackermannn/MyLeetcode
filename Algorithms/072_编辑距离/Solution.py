class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        n, m = (len(word1) + 1), (len(word2) + 1)
        dp = [[0 for _ in range(m)] for _i in range(n)]
        for i in range(n):
            for j in range(m):
                if i == 0 and j == 0:
                    continue
                elif i == 0 or j == 0:
                    dp[i][j] = max(i, j)
                else:
                    dp[i][j] = min(dp[i - 1][j] + 1,
                                   dp[i][j - 1] + 1,
                                   dp[i - 1][j - 1] if word1[i - 1] == word2[j - 1] else dp[i - 1][j - 1] + 1)
        return dp[n - 1][m - 1]


if __name__ == '__main__':
    sol = Solution()
    test_cases = [
        ['word', 'ors']
    ]
    for case in test_cases:
        word1 = case[0]
        word2 = case[1]
        ret = sol.minDistance(word1=word1, word2=word2)
        print(ret)
