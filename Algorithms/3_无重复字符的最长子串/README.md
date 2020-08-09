
题目地址

https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

解答：

利用滑动窗口和哈希set

```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0 # 滑动窗口的左指针
        hashDict = set()
        ans = 0 # 存放最大长度
        for right in range(len(s)): # 对滑动窗口 右指针right 迭代
            if not s[right] in hashDict: # hashDict中无right指向的字符时, 将其加入hashDict
                hashDict.add(s[right])
            else:
                while s[left] != s[right]: # hashDict中有right指向的字符时, left指针不断右移动直到left所指与right相同。
                    hashDict.remove(s[left]) # 移动过程中排除不在窗口的字符
                    left += 1
                left += 1 # while执行完后 left与right指向时相同的，需要再移动一次
            ans = max(ans, right - left + 1) # 记录迭代中出现的最大值
        
        return ans
```
