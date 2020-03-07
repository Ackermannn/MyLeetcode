# -*- coding: utf-8 -*-
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        if len(b)>len(a): a, b = b, a        
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
        return ''.join(res)

a = "1"
b = "111"
solu = Solution()

print(solu.addBinary(a, b))