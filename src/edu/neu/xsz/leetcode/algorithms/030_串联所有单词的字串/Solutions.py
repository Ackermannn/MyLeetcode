from typing import List

"""
给定一个字符串s和一些长度相同的单词words。找出 s 中恰好可以由words 中所有单词串联形成的子串的起始位置。

注意子串要与words 中的单词完全匹配，中间不能有其他字符，但不需要考虑words中单词串联的顺序。



示例 1：

输入：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
示例 2：

输入：
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
输出：[]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
"""


class Solution:
    """
    官方题解的解法一。 对字符串窗口进行一个一个的滑动，用新的List查询是否匹配
    """

    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        def isMatch():
            for j in range(0, all_len, word_len):
                sub_sub_s = sub_s[j:j + word_len]
                if sub_sub_s in words_set:
                    words_set.remove(sub_sub_s)
                else:
                    return False
            return True

        _ans = []
        i = 0
        word_len = len(words[0])  # 单词长度
        words_len = len(words)  # words列表长度
        all_len = words_len * word_len  # 所有单词长度

        while i + all_len <= len(s):
            words_set = words.copy()
            sub_s = s[i:i + all_len]
            if isMatch():
                _ans.append(i)
            i = i + 1
        return _ans


if __name__ == '__main__':
    # s = "barfoothefoobarman"
    # words = ["foo", "bar"]

    # s = "wordgoodgoodgoodbestword"
    # words = ["word", "good", "best", "word"]

    s = "wordgoodgoodgoodbestword"
    words = ["word", "good", "best", "good"]


    ans = Solution().findSubstring(s, words)
    print(ans)
