class Solution:
    
    def trap(self,height):
        if not height: return 0
        hei_idx = height.index(max(height))
        water = column = 0
        for i in height[:hei_idx]:
            if i < column: water += column - i
            else: column = i
        column = 0
        for i in height[hei_idx:][::-1]:
            if i < column: water += column - i
            else: column = i
        return water
        
    
if __name__ == '__main__':
    s = Solution()
    height =  [2,1,23,1,15]
    print("the answer is: ",s.trap(height))
