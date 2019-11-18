#include<iostream>
#include<vector>
#include <algorithm>
using namespace std;
class Solution {
public:
	// 暴力法会在力扣测试例中会超出时间限制
	int maxProfit_alpha(vector<int>& prices) {
		int ans = 0;
		for (auto i = prices.begin(); i < prices.end(); i++)
		{
			for (auto j = prices.begin(); j < i; j++) {
				ans = max(ans, *i - *j);
			}
		}
		return ans;
	}
	int maxProfit(vector<int>& prices) {
		int ans = 0;
		int buy = INT_MAX;
		for (auto i = prices.begin(); i < prices.end(); i++)
		{
			buy = min(buy, *i);
			ans = max(ans, *i - buy);

		}
		return ans;
	}

};
int main() {
	Solution solv;
	vector<int> p = {};
	auto ans = solv.maxProfit(p);
	cout << ans << endl;
	return 0;

}