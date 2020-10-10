/*
https://leetcode-cn.com/problems/factorial-trailing-zeroes/submissions/
*/
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
	int trailingZeroes(int n) {
		int ans = 0;
		int index = 1;
		while (n >= pow(5, index)) {
			ans += n / pow(5, index);
			index++;
		}

		return ans;
	}
};
int main() {
	Solution solv;
	int ans = solv.trailingZeroes(120);
	cout << ans << endl;
	return 0;
}