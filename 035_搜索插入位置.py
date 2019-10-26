# -*- coding: utf-8 -*-
nums = [1,3,5,6]
target = 2
class Solution:
    def searchInsert(self, nums, target):        
        if not target in nums: 
            nums.append(target)
            nums.sort()
        return nums.index(target)
    
solu = Solution()
print(solu.searchInsert(nums, target))
