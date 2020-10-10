# [Question](https://leetcode-cn.com/problems/word-break/)

# Code

[官方题解](https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/)

```python3
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        """回溯法超时了，得用官方题解的动态规划法"""
        dp = [False] * (len(s) + 1) # dp长度设置len+1, 为空值情况做考虑，从而不用多写if语句
        dp[0] = True  # 当s全取时，前半个字符串为空"", 默认True

        for i in range(1, len(s) + 1): # 计算dp数组的数值
            for j in range(0, i): # 对当下的字符串在j处前后分开
                if dp[j] and (s[j:i] in wordDict): # 从0~j-1 与 j~i-1 都合法
                    dp[i] = True
                    break
        return dp[-1]


```
