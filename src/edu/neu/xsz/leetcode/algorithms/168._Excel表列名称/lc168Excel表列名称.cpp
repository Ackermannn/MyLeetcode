/*
address:
https://leetcode-cn.com/problems/excel-sheet-column-title/
*/
#include<iostream>

using namespace std;
class Solution {
public:
	string convertToTitle(int n) {
		int num = 0;
		string ans = "";

		while (n >= 1)
		{
			num = n % 26;
			if (num == 0) {  // 26: Z  52:AZ
				ans = char('Z') + ans;
				n -= 26;
			}
			else {
				ans = char('A' - 1 + num) + ans;
				n = n - num;
			}
			n = n / 26;

		}
		return ans;
	}
};

int main() {
	Solution* solv = new Solution();
	string answer;
	answer = solv->convertToTitle(28);
	for (char c : answer) {
		cout << c;
	}

	delete solv;
	return 0;
}