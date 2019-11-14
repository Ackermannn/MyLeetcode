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
# 递归推导:
#https://leetcode-cn.com/problems/maximum-subarray/comments/8881

# 首赞答案
#https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/

# 最形象的解答
#https://leetcode-cn.com/problems/maximum-subarray/solution/jia-she-ni-shi-yi-ge-du-tu-by-acnesu/
#
#假设你是一个选择性遗忘的赌徒，数组表示你这几天来赢钱或者输钱，
#你用sum来表示这几天来的输赢，
#用ans来存储你手里赢到的最多的钱，
#
#如果昨天你手上还是输钱（sum < 0），你忘记它，明天继续赌钱；
#如果你手上是赢钱(sum > 0), 你记得，你继续赌钱；
#你记得你手气最好的时候
#
#作者：acnesu
