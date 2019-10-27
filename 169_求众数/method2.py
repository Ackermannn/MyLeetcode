'''
@YourBaymax: 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
'''
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        ans = nums[0]
        count = 0
        for i in nums:
            if i == ans: 
                count += 1
            else: 
                count -=1
            if count ==  0:
                ans = i
                count = 1
        return ans
