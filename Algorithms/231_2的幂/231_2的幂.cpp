class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0: return False
        num = n
        flag = 0
        while (num >= 1):
            if (num % 2 == 1 and flag == 1):
                return False
            if (num % 2 == 1 and flag == 0): 
                flag = 1
                num //= 2
                continue
            if (num % 2 == 0):
                num //= 2

        return True

s = Solution()
print(s.isPowerOfTwo(0))
