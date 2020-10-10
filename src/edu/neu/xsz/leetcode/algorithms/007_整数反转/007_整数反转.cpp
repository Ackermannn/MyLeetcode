class Solution:
    def reverse(self, x: int) -> int:
        
          
        list1 = list(str(abs(x)))
        list1 = list1[::-1]
            
        str1 = str()
        for i in range(0,len(list1)):
            str1 += list1[i]
        if x < 0:    
            int1 = -1 * int(str1) 
        else:
            int1 = int(str1)

        if int1 > 2 ** 31 - 1 or int1 < -1 * 2 ** 31:
            return 0
        else:
            return int1
