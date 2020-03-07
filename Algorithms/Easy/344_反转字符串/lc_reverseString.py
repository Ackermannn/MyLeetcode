class Solution:
    def reverseString(self, s):
        left = 0
        right = len(s) - 1
        while left < right:
            s[right], s[left] = s[left], s[right] 
            right -= 1
            left += 1
            
solv = Solution()
s = ["h","e","l","l","o"]
solv.reverseString(s) # 对 s 原地修改
print(s) 