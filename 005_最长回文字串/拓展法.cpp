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
	cout << "result: " <<solu.longestPalindrome("") << endl;

	return 0;
}
