#include <iostream>
#include <vector>
#include <algorithm>
/*
* using find() function in C++ STL
*
*
*/
using namespace std;
ostream& operator<<(ostream& os, vector<int>& v)
{
	os << '[';
	for (auto iter = v.begin(); iter < v.end() - 1; iter++)
	{
		os << *iter << ',';
	}
	os << *(v.end() - 1) << ']';
	return os;
}
class Solution {
public:
	vector<int> searchRange(vector<int>& nums, int target) {
		vector<int>::iterator ans1 = find(nums.begin(), nums.end(), target);
		vector<int> ans = { -1, -1 };
		if (ans1 != nums.end())
		{
			ans[0] = ans1 - nums.begin();
			while (ans1 != nums.end() and *ans1 == target)
			{
				ans[1] = ans1 - nums.begin();
				ans1++;
			}
		}
		return ans;
	}
};

int main() {
	vector<int> nums = { 2,7,7,8,8 };
	int target = 8;
	Solution solv;
	vector<int> ans = solv.searchRange(nums, target);
	cout << ans << endl;
	return 0;
}