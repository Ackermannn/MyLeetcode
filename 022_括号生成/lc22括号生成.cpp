/*
����n�����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�

���磬����n = 3�����ɽ��Ϊ��

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

���ӣ�https://leetcode-cn.com/problems/generate-parentheses

�ⷨ: ������

�������ŶԵ��������,���ж���Ч��

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
	// �ж�������Ч��
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
