# 问题描述
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

### 示例 1：

输入: "babad"

输出: "bab"

注意: "aba" 也是一个有效答案。



### 示例 2：

输入: "cbbd"

输出: "bb"

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/longest-palindromic-substring


# 解答

## 中心拓展法 
### Introduce

1. 先在字符串中插入#,以取消奇数偶数长度额讨论

2. 对字符串循环, 利用对称性检查以字符i为中心左右两边是否相等

### Code

C++ 代码:
```cpp
#include<iostream>
using namespace std;

class Solution {
public:
	string longestPalindrome(string s) {
		// add #
		string extend = "#";
		for (auto x : s) {
			extend.push_back(x);
			extend.append("#");
		}
	
		string longest;
		string::iterator iter_left, iter_right;
		for (auto iter = extend.begin(); iter != extend.end(); iter++)
		{
			iter_left = iter;
			iter_right = iter;
			while (*iter_left == *iter_right)
			{
				if (iter_right - iter_left + 1 > longest.size()) {
					longest.assign(iter_left, iter_right + 1);
					
				}
				if (iter_left == extend.begin() or iter_right == extend.end() - 1) break;
				iter_left -= 1;
				iter_right += 1;
			}
		}
		
		// 去除#
		string ans;
		for (int i = 0; i < longest.size(); i++) {
			if (longest[i] != '#') {
				ans.push_back(longest[i]);
			}
		}
		return ans;
	}
};

int main() {
	Solution solu;
	cout << "result: " <<solu.longestPalindrome("abbd") << endl;

	return 0;
}


```
