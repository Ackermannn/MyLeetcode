# -*- coding: utf-8 -*-
"""
leetcode 461

两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。


例子:
输入: x = 1, y = 4
输出: 2
解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
上面的箭头指出了对应二进制位不同的位置。

链接：https://leetcode-cn.com/problems/hamming-distance

"""
def hammingDistance(x, y):

    s = bin(x ^ y)
    s = s[2:]
    l = list(s)
    l = [int(i) for i in l]
    return sum(l)
#print(bin(a ^ b))

a = 1
b = 4
print(hammingDistance(a, b))
