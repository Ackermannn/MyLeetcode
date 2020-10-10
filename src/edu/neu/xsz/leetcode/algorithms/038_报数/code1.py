class Solution:
    def countAndSay(self, n: int) -> str:
        def say_str(say):
            say = say + "#"
            res = str()
            start = 0
            end = start
            while end < len(say)-1:
                while say[end] == say[start]:
                    end += 1
                temp = say[start:end]
                start = end
                res += str(len(temp)) + str(temp[0])
            return res
        say = "1"
        for i in range(n-1):
            say = say_str(say)
        return say
solu = Solution()
print(solu.countAndSay(10))
