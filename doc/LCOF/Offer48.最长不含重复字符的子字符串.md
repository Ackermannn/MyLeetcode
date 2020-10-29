# 剑指 Offer 48. 最长不含重复字符的子字符串

## 问题

https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/

## 解答

滑动窗口

### 代码

```python3
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        ans, deque = 0, []
        for item in s:
            while item in deque: deque.pop(0)
            deque.append(item)
            ans = max(ans, len(deque))
        return ans

```
