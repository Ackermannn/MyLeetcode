"""
题目地址

https://leetcode-cn.com/problems/minimum-window-substring/

"""


class Solution1:
    """
    在 266/268个测试用例处超时
    """

    def isclude(self, sub_s: str, t: str) -> bool:
        listed = list(sub_s)
        for x in t:
            if x not in listed:
                return False
            else:
                listed.remove(x)
        return True

    def minWindow(self, s: str, t: str) -> str:
        sub_size_range = range(len(t), len(s) + 1)
        for size in sub_size_range:
            for i in range(0, len(s) - size + 1):
                sub_s = s[i:i + size]
                if self.isclude(sub_s, t):
                    return sub_s
        return ""


class Solution2:
    """滑动窗口
    最后一个测试用例超时
    """

    def isclude(self, sub_s: str, t: str) -> bool:
        listed = list(sub_s)
        for x in t:
            if x not in listed:
                return False
            else:
                listed.remove(x)
        return True

    def minWindow(self, s: str, t: str) -> str:
        left = 0
        right = 1
        ans = ""
        while left < len(s) and right <= len(s):
            sub_s = s[left:right]
            if self.isclude(sub_s, t):
                if ans == "" or len(sub_s) < len(ans):
                    ans = sub_s
                left = left + 1
                while left < right and s[left] not in t:
                    left = left + 1

            else:
                right = right + 1
                while right < len(s) and s[right - 1] not in t:
                    right = right + 1

        return ans


if __name__ == '__main__':
    sol = Solution2()

    s = "ADOBECODEBANC"
    t = "ABC"
    #
    # s = "bbaa"
    # t = "aba"
    # s = "abc"
    # t = "b"
    ret = sol.minWindow(s, t)
    print(ret)
