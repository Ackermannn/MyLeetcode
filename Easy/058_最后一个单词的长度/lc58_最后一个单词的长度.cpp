#include<iostream>
/*
给定一个仅包含大小写字母和空格' '的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例:
输入: "Hello World"
输出: 5

链接：https://leetcode-cn.com/problems/length-of-last-word

# 解答
从后往前 先去掉空格找结尾字母位置记为start, 再找到下一个空格位置记为end
return (start-end) 


*/
using namespace std;
class Solution {
public:
	int lengthOfLastWord(string s) {
		if (s.empty()) return 0;
		int len = s.size();
		int start = -1;
		// 去空格
		for (int i = len - 1; i >= 0; i--) {
			if (s[i] != ' ') {
				start = i;
				break;
			}
		}
		int end = start;
		for (; end >= 0; end--) 
			if (s[end] == ' ') break;
		return (start - end);
	}
};


int main() {
	Solution so;
	string s = "";
	int ans;
	ans = so.lengthOfLastWord(s);

	cout << ans << endl;

	return 0;
}