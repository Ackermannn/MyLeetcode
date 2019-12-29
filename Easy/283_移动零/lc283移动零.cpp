#include<iostream>
#include<vector>
/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]

说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

链接：https://leetcode-cn.com/problems/move-zeroes

*/

using std::swap;
using std::cout;

using std::ostream;
using std::vector;
using std::endl;
ostream& operator<<(ostream &os, vector<int>& v) 
{
	os << '[';
	for (auto iter = v.begin(); iter < v.end() - 1; iter++) 
	{
		os << *iter << ',';
	}
	os << *(v.end()-1) << ']';
	return os;
}
class Solution {
public:
	void moveZeroes(vector<int>& nums) {
		int p = 0, q = 1;
		while (q < nums.size())
		{
			if (nums[p] == 0)
			{
				while (q < nums.size() and nums[q] == 0)
				{
					q++;
				}
				if (q >= nums.size()) break;
				swap(nums[p], nums[q]);

			}
			p++;
			q++;
		}
		
	}
};
int main() {
	vector<int> nums = { 0,0};
	Solution solv;
	solv.moveZeroes(nums);

	cout << nums << endl;
	
	
	return 0;
}

// [0,0]