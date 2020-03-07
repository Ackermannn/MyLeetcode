# -*- coding: utf-8 -*-
"""
x 的平方根
"""


def my_sqrt(x):
    if x <= 1: return x
    left = 1
    right = x // 2
    while left < right:
        mid = (left + right +1) >> 1
        square = mid * mid
  
        if square > x:    
            right = mid - 1
        else:
            left = mid
            
    return left
                
X = 13
print(my_sqrt(X))


import numpy as np
print('numpy result: ',np.sqrt(X))
