# -*- coding: utf-8 -*-
class Solution:
    
    def norm_search(self, nums, target,  bias=0):    
        if nums == []: return -1    
        left = 0    
        right = len(nums) - 1        
        if target == nums[left]: return 0 + bias
        if target == nums[right]: return right + bias    
        while (True):        
            if (right - left) <= 1: return -1       
            mid = (right - left) // 2 + left         
            if target == nums[mid]: return mid + bias
                            
            if  target < nums[mid]:            
                right = mid # 取左半               
            else:
                left = mid # 取右半边
                
    def search(self, nums, target):
        if nums == []: return -1
        left = 0    
        right = len(nums) - 1
        if target == nums[left]: return 0    
        if target == nums[right]: return right
        
        while(True):
            if (right - left) <= 1: return -1
            mid = (right - left) // 2 + left
            if target == nums[mid]: return mid
            
            # 如果target 在连续段内
            if nums[left] < target and target < nums[mid]:
                return self.norm_search(nums[left: mid + 1], target, bias=left)
            elif nums[mid] < target and target < nums[right]:
                return self.norm_search(nums[mid: right], target, bias=mid)
            
            # 不在的话
            if nums[left] < nums[mid]:
                left = mid # 取右半边
            else:
                right = mid # 取左半
        
    
#nums = [1, 3, 5]
#target = 2
#nums = [4,7, 0, 1,2,3]
#target = 5
nums = [3,4,5,6,7,8,1,2]
target = 7

solu = Solution()
ans = solu.search(nums, target)

if ans != -1:
    nums[ans] = '{}'.format(nums[ans])
else:
    print("don't find")
print(nums)
