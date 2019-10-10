#include<vector>
#include<iostream>

using namespace std;
class Solution {
public:
	int removeDuplicates(vector<int>& nums) {
		if (nums.size() <= 1) return nums.size();
		auto iter1 = nums.begin(),iter2 = iter1 + 1;
		while (iter2 != nums.end()) {
			if (*iter1 == *iter2) iter2++;
			else swap(*(iter1++ + 1), *iter2++);}
		nums.erase(iter1 + 1, nums.end());
		return nums.size();
	    // 执行用时:24 ms, 在所有 C++ 提交中击败了95.97 %的用户
  	    // 内存消耗 :9.8 MB, 在所有 C++ 提交中击败了91.12 %的用户
	}
};
int main() {
	
	vector<int> nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4,5};

	Solution s;
	cout << "unique length: " <<s.removeDuplicates(nums) << endl;

	for (auto x : nums) {
		cout << x << endl;
	}
	return 0;
}
