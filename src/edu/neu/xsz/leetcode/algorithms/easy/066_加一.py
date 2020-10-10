# -*- coding: utf-8 -*-
"""
leetcode 66.加一
"""

def add(x):
    flag = 1
    for i in range(-1,-len(x)-1,-1):
        if flag + x[i] != 10:
            x[i] += 1
            flag = 0
            return x
        else:
            x[i] = 0
    if flag == 1:
        x.append(0)
        x[0] = 1
        return x

x = [9,8,9]
print(add(x))