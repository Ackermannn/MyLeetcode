#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
	string longestCommonPrefix(vector<string>& strs) {
		
		if (strs.empty()) return "";
		string out = strs[0];				//初始化 第一个字符串为最终结果
		for (int j = 1; j < strs.size(); j++) {
			// if (strs[j].size() < out.size()) out = out.substr(0, strs[j].size()); // 没有这句更简洁
			for (int i = 0; i < out.size(); i++) {
				if (out[i] != strs[j][i])      // 查询接下来的对应字符是否相等
				{
					out = out.substr(0, i);   // 不等的话，缩短结果
					break;
				}
			}
			
		}
		return out;
	}
};


int main() {
	vector<string> strs = { "flpwer" ,"flow","flight" };
	string out;
	Solution s;
	out = s.longestCommonPrefix(strs);
	cout << out << endl;
	
	return 0;
}
