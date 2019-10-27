class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        n = len(nums) / 3
        m = {}

        for item in nums:
            if not item in m:
                m[item] = 1
            else:
                m[item] += 1
        return [key for key,val in m.items() if val > n]
