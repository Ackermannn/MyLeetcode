class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        ans = []
        count = []
        for i in nums:
            if not i in ans:
                ans.append(i)
                count.append(0)
            else:
                idx = ans.index(i)
                count[idx] += 1
        out =  ans[count.index(max(count))]
        return out
