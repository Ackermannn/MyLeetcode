
class Solution:
    '''
    question:
    
    Is here duplication in integer array?
    
    link:
        
    https://leetcode-cn.com/problems/contains-duplicate/
    '''
    def containDuplicate(self, nums):
        """
        
        use hash table mothed
        
        :type nums: List[int]
        :rtype: bool
        """
        m = {}   
        for i in nums:
            if i in m:
                return True
            else:
                m[i] = i
        return False
    
    def containsDuplicate_set(self, nums):
        """
        use set() function to solve
        
        :type nums: List[int]
        :rtype: bool
        """
        set1 = set(nums)
        if len(set1) == len(nums):
            return False
        else:
            return True
    
so = Solution()
nums = [1,2,3,1]  
print(so.containDuplicate(nums))