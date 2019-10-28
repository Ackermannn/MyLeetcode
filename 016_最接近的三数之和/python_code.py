# -*- coding: utf-8 -*-
def threeSumClosest(nums, target):
    nums.sort()
    ans = sum(nums[:3])
    d = abs(ans-target)
    for i in range(len(nums)-2):
        L = i + 1
        R = len(nums) - 1
#        print(nums[i], nums[L], nums[R])
        while True:    
            sum3 = nums[i] + nums[L] + nums[R]
            if abs(sum3 - target) < d: 
                ans = sum3
                d = abs(sum3 - target)
            if sum3 < target:
                L += 1
                if L >= R: break
            if sum3 > target:
                R -=1
                if R <= L: break
            if sum3 == target:
                return ans
    return ans
            
# 重要的测试用例               
#nums = [1,2,4,8,16,32,64,128]
#target = 82
#nums = [-1, 2, 1, -4]
#target = 1 # 2
#nums = [0,0,0]
#target = 1
#nums = [1,1,1,1]
#target = 0
#nums = [1,1,1,0]
#target = 100
#nums = [1,2,3,4]
#target = 6
#nums = [-1,0,1,2,-1,-4]
#target = 0
#            
nums = [0,2,1,-3]
target = 1
ans = threeSumClosest(nums, target)
print(ans)
