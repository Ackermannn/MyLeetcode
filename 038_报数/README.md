# Question
报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
```
1.     1
2.     11
3.     21
4.     1211
5.     111221
```
1 被读作  "one 1"  ("一个一") , 即 11。

11 被读作 "two 1s" ("两个一"）, 即 21。

21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/count-and-say
# Python Code
```python
class Solution:
    def countAndSay(self, n: int) -> str:
        def say_str(say):
            say = say + "#" # 给输入的字符串加一个终止符号
            res = str()
            start = 0
            end = start
            while end < len(say)-1: # 遍历数组, end 指向 最后一个字符 '#'时候终止,此时 end == len(say) - 1
                while say[end] == say[start]: # 寻找连续一样的数字
                    end += 1
                temp = say[start:end]
                start = end
                res += str(len(temp)) + str(temp[0]) # 第一个字符是连续相等的个数,第二个是该数字是什么
            return res
        say = "1"
        for i in range(n-1):
            say = say_str(say)
        return say
solu = Solution()
print(solu.countAndSay(10))
```
