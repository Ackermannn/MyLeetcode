/*
*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
*给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
*
*示例:
*
*输入："23"
*输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;
ostream& operator<<(ostream& os, vector<string>& v)
{
	os << '[';
	for (auto iter = v.begin(); iter < v.end() - 1; iter++)
	{
		os << '"' << *iter << "\" ," << endl;
	}
	os << '"' << *(v.end() - 1) << '"'<< ']';
	return os;
}
class Solution {
public:
	vector<string> letterCombinations(string digits) {
		// 电话键盘的映射关系
		map<char, string> tellphone = {
			   { '2', "abc" },{ '3', "def" },
			   { '4', "ghi" },{ '5', "jkl" },
			   { '6', "mno" },{ '7', "pqrs"},
			   { '8', "tuv" },{ '9', "wxyz"},
		};
		// 当输入数字只有一位的处理
		vector<string> ans = {};
		for (int i = 0; i < tellphone[digits[0]].size(); i++) {
			string temp;
			temp.push_back(tellphone[digits[0]][i]);
			ans.push_back(temp);
		}
		// 当大于等于两位数字的处理
		for (int i = 1; i < digits.size(); i++) {
			vector<string> new_ans = {}; // 初始化新的 结果

			// 把前n步找到所有组合 与 下一组号码组进行组合
			for (int j = 0; j < tellphone[digits[i]].size(); j++) {
				for (auto x : ans) {
					new_ans.push_back(x + tellphone[digits[i]][j]);				
				}
			}			
			ans = new_ans; // 新的组合赋值旧组合
		}		
		return ans;
	}
};
int main() {
	string digits = { "233" };
	Solution solv;
	auto ans = solv.letterCombinations(digits);
	cout << ans << endl;
	return 0;
}

