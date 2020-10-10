#include<iostream>
using namespace std;
class Solution {
public:
	string convert(string s, int numRows) {
		string ans;
		if (numRows == 1) return s;
		int groupLen = 2 * numRows - 2;
		for (int groupIndex = 0; groupIndex < numRows; groupIndex++) {
			if (groupIndex == 0 or groupIndex == numRows - 1) {
				for (int i = groupIndex; i < s.size(); i += groupLen) {
					ans.push_back(s[i]);
				}
			}
			else {
				for (int i = groupIndex; i < s.size(); i += groupLen) {
					ans.push_back(s[i]);
					if (i + groupLen - 2 * groupIndex < s.size())
						ans.push_back(s[i + groupLen - 2 * groupIndex]);
				}


			}
		}
		return ans;

	}
};
int main() {
	string s = "LEETCODEISHIRING";
	int numRows = 2;
	Solution solu;
	cout << solu.convert(s, numRows) << endl;

	return 0;
}