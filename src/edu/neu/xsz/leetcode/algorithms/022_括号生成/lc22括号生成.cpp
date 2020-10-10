/*
给出n代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

链接：https://leetcode-cn.com/problems/generate-parentheses

解法: 暴力法

给出括号对的所有情况,再判断有效性

*/


#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
ostream& operator<<(ostream& os, vector<string>& v)
{
	os << '[' << endl;
	for (auto iter = v.begin(); iter < v.end() - 1; iter++)
	{
		os << '"' << *iter << "\" ," << endl;
	}
	os << '"' << *(v.end() - 1) << '"' << endl << ']';
	return os;
}
class Solution {
public:
	// 判断括弧有效性
	bool isvalid(string s) {
		int sum = 0;
		for (auto x : s) {

			if (x == '(') sum++;
			else sum--;

			if (sum < 0) return false;

		}
		return true;

	}
	vector<string> generateParenthesis(int n) {
		vector<string> ans = {};
		//int n = 3;
		string left = "(", right = ")";
		string sum = "";
		for (int i = 0; i < n; i++)
		{
			sum = sum + left;
		}
		for (int i = 0; i < n; i++)
		{
			sum = sum + right;
		}


		if (isvalid(sum))
			ans.push_back(sum);
		while (next_permutation(sum.begin(), sum.end()))
		{
			if (isvalid(sum)) ans.push_back(sum);
		}
		return ans;

	}
};


int main() {
	Solution solv;
	int n = 4;
	auto ans = solv.generateParenthesis(n);
	cout << ans << endl;
	return 0;
}
