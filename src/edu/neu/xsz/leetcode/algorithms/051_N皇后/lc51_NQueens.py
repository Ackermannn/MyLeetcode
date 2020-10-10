# -*- coding: utf-8 -*-
"""
leetcode N皇后
"""
def insert(p,n):
    '''
    In [9]: insert(1,4)
    Out[7]: 'Q...'
    '''
    return "."*(p-1) + "Q" + "."*(n-p)

def draw(x, n): # 输入数组 每个元素是
    res = [] 
    for i in x:
        res.append(insert(i+1,n))
    for i in res:
        print(i)
#    return res

# 给出一个全排列
# [x1,x2, .. xi,xj  ...]
# 检查 任意 xi xj 是否 满足 xi +- d = xj ,d 为 xi 与 xj 在数组中的距离.
# 满足则 不是Qqueens 的解
def check(i):
    for ii in range(len(i)-1):
       for jj in range(ii+1,len(i)):
           if i[ii] == i[jj] + jj - ii or i[ii] == i[jj] + ii - jj:
               return False
    return True

import itertools
n = 5
a=itertools.permutations(list(range(n)))
for i in a:
    if check(i):
        draw(i, n)
        print()
    
               




