#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
  // 使用动态规划方法
	int rob(vector<int>& nums) {
		int last2 = 0, last1 = 0, ans = 0;
		for (int i = 0; i < nums.size(); i++) {
			ans = max(nums[i] + last2, last1);
			last2 = last1;
			last1 = ans;
			
		}
		return ans;
	}
};

int main() {
	vector<int> nums = { 2,7,9,3,1 };
	Solution solv;
	int ans = solv.rob(nums);
	cout << ans << endl;
	return 0;
}
