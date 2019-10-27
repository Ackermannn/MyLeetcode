# Question

给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。
```
示例 1:

输入: a = "11", b = "1"
输出: "100"
```
```
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
```
来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/add-binary
# Solutions

右端看齐, 加法进位

当前位是 `num1 ^ num2 ^ flag` (^ 是异或)

进位是 `((num1 & num2) | (flag &(num1 ^ num2)))` (& 与, | 或) 

# Python Code
```python
# -*- coding: utf-8 -*-
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        if len(b)>len(a): a, b = b, a # set a is longer one      
        res = []
        flag = 0 # 进位符号
        for i in range(-1,-(len(a)+1),-1): # i =[-1, -2, -3, -4]
            num1 = int(a[i])
            if -i <= len(b): num2 = int(b[i])
            else: num2 = 0
            res.insert(0, str((num1 ^ num2 ^ flag)))
            flag = ((num1 & num2) | (flag &(num1 ^ num2)))
        if flag == 1:
            res.insert(0, '1')
        return ''.join(res) # str型的list 转 str 用法

a = "1"
b = "111"
solu = Solution()

print(solu.addBinary(a, b))
```
