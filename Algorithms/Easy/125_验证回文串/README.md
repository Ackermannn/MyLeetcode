# 验证回文串

## Question

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

	输入: "A man, a plan, a canal: Panama"
	输出: true

示例 2:

	输入: "race a car"
	输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome

## code
```cpp
class Solution {
public:
	bool isPalindrome(string s) {
		int left = 0, right = s.size();
		while (left < right) {
			while (!isalnum(s[left]) && left < s.size()-1) left++;
			while (!isalnum(s[right]) && right > 0) right--;
			if (toupper(s[left]) == toupper(s[right])) {
				left++;
				right--;
			}
			else if(left < right)
				return false;
		}
		return true;
	}
};
```