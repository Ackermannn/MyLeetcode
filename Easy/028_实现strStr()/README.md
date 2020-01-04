# 题目
实现 `strStr()` 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
```
示例 1:
输入: haystack = "hello", needle = "ll"
输出: 2
```
```
示例 2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1
```

说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

链接：<https://leetcode-cn.com/problems/implement-strstr>

# 解答

滑动窗口法,双指针

# code

```cpp
class Solution {
public:
	int strStr(string haystack, string needle) {
		int ans = -1;
		if (needle.empty()) return 0;
		int start = 0, end = start + needle.size() - 1;

		for (; end < haystack.size(); end++,start++) 
			if (haystack.substr(start, needle.size()) == needle) return start;
		
		return ans;
	}

};
```

PS: 
  学习使用 STL 中 `string.substr()` `string.assign()`
  
  有别的高级算法， 面试使用双指针即可
