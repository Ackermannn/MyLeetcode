#include <iostream>
#include <vector>
/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

示例 2:
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

链接：https://leetcode-cn.com/problems/jump-game


解法: 从右往左遍历 
1. 初始化能跳转到当前点的最小数值n = 0
2. 当前值如果满足条件(当前值大于等于n) n置0.
3. 往左移动指针并且n++, 再执行第二步直到到达最左端
4. 在最左端时满足条件(当前值大于等于n) 返回true,否则返回false
*/
using namespace std;

class Solution {
public:
	bool canJump(vector<int>& nums) {
		int n = 0;
		for (auto iter = nums.rbegin(); iter < nums.rend(); iter++) {
			if (*iter >= n) 
			{
				if (iter != nums.rend()-1) n = 0;
				else return true;
			}
			n++;
		}
		return false;
		
	}
};

int main() {
	Solution solv;
	vector<int> nums = {2,3,1,1,4};
	bool ans = solv.canJump(nums);
	cout << ans << endl;
	return 0;
}