# -*- coding: utf-8 -*-
"""
Created on Thu Nov 14 15:20:38 2019

@author: Ackerman

leetcode 053 最大子序和
"""

def maxSubArray(nums):
    sums = 0
    ans = nums[0]
    for x in nums:
        if sums > 0:
            sums += x
        else:
            sums = x
        ans = max(ans, sums)
            
    return ans

x = [6,-1,6]
y = maxSubArray(x)
print(y)

#https://leetcode-cn.com/problems/maximum-subarray/comments/8881
#https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/