class Solution:
    def reverseWords(self, s: str) -> str:
        s_list = s.split()
        return " ".join(s_list[::-1])


if __name__ == '__main__':
    strs = [
        "the sky is blue",
        "  hello world!  ",
        "a good   example"
    ]
    sol = Solution()
    for x in strs:
        print(sol.reverseWords(x))
