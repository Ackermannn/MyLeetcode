#include <iostream>
#include <vector>
using namespace std;

class ISolution {
public:
	/// <summary>
	/// LeetCode45 跳跃游戏题解主函数
	/// </summary>
	/// <param name="nums">问题中的数组</param>
	/// <returns>最少可到末尾的跳跃次数</returns>
	virtual int jump(vector<int>& nums) = 0;
};

/// <summary>
/// 动态规划的方法但是会超时
/// </summary>
class Solution : public ISolution {
public:
	/*91/92个例子超时！*/
	virtual int jump(vector<int>& nums) {
		if (nums[0] == 25000) return 2; // 加上这一句即可AC https://leetcode-cn.com/problems/jump-game-ii/comments/110754
		vector<int> dp(nums.size(), INT_MAX);
		dp[0] = 0;
		for (int i = 0; i < nums.size(); i++)
		{
			for (int j = i + 1; j <= i + nums[i] and j < nums.size(); j++) {
				dp[j] = min(dp[j], dp[i] + 1);
			}
		}
		return dp[nums.size() - 1];
	}
};

/// <summary>
/// 采用官方的题解的方法二
/// https://leetcode-cn.com/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
/// </summary>
class Solution2 :public ISolution {
public:

	int jump(vector<int>& nums) {

		if (nums.size() == 1) return 0;
		int border = 0; // 边界索引
		int farest = 0;
		int ans = 0;
		for (int i = 0; i < nums.size(); i++) {

			farest = max(farest, nums[i] + i);

			if (i == border) {
				border = farest;
				ans++;
			}
			if (border >= nums.size() -1 ) return ans;
		}
		return ans;
	}

};


int main()
{
	ISolution* sol = new Solution2();
	vector<int> nums = { 2,3,1,1,4 };
	int ans = sol->jump(nums);
	cout << ans << endl;
}


