class Solution:
    def merge(self, intervals):
        intervals.sort()
        iend = len(intervals) - 2
        i = 0
        while (i <= iend):
        
            if intervals[i][1] >= intervals[i+1][0]:
                if intervals[i+1][1] >  intervals[i][1]:
                    intervals[i][1] = intervals[i+1][1]
                intervals.remove(intervals[i+1])
                iend  -= 1
            else:
                i += 1
        return intervals

list1 = [[1,4],[2,3]]

s=Solution()
res = s.merge(list1)
print(res)
