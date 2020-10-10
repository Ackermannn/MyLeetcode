class Solution:
    def twoSum(self, nums, target):
        '''
        两数之和
        '''
        ans = []
        p2 = 0
        p3 = len(nums) - 1
        while(p2 < p3):
            sum_p = nums[p2] + nums[p3]
            if sum_p > target:
                p3 = p3 - 1
            elif sum_p < target:
                p2 = p2 + 1
            else:
                if (ans == [] or [nums[p2], nums[p3]] != ans[-1]): # 去重复 
                    ans.append([nums[p2], nums[p3]])    
                p2 = p2 + 1
                p3 = p3 - 1
        return ans
        
    def fourSum(self, nums, target):
        # 锚定两个点, 嵌套循环, 调用两数之和函数
        if nums == []: return []
        
        nums.sort()       
        ans = []
        p1 = 0
        p4 = len(nums) - 1
        
        while(p1 + 2< p4):            
            while(p1 + 2 < p4 ):
                
                temp =  self.twoSum(nums[p1+1:p4], target-nums[p1]-nums[p4])

                if temp != []: 
                    for i in range(len(temp)):
                        temp[i] = [nums[p1]] + temp[i] + [nums[p4]] # 前拼后接,使其符合要求
                    ans = ans + temp
                
                while(p1 < len(nums) - 1 and nums[p1] == nums[p1+1]): p1 = p1 + 1 # 跳过连续相同值,去重复
                p1 = p1 + 1
                
            while(p4 > 0 and nums[p4] == nums[p4-1]): p4 = p4 - 1 # 跳过连续相同值,去重复
            p4 = p4 - 1
            p1 = 0

            
        return ans

s = Solution() 
# nums = [1,-2,-5,-4,-3,3,3,5]
# target = -11 # [[-5,-4,-3,1]]
# nums = [0,0,0,0]
# target = 0

# nums = [-2,-2,-1,-1,0,0,1,1,2,2] #重复性
# target = 0
# ans = s.fourSum(nums, target)
# print(ans)

nums = [1,0,-1,0,-2,2]
target = 0
ans = s.fourSum(nums, target)
print(ans)

# nums = [1, 0, -1, 0, -2, 2]
# target = 0
# ans = s.fourSum(nums, target)
 

