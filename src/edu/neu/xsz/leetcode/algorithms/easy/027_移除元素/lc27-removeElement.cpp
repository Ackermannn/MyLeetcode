#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
	int removeElement(vector<int>& nums, int val) {
		int i = 0, j;
		for (j = 0; j < nums.size(); j++) {
			if (nums[j] != val)
			{
				nums[i] = nums[j];
				i++;
			}
	
		}
		return i;
	}
};
int main() {
	Solution solv;
	vector<int> nums = {3,2,2,3 };
	int val = 3;
	int ans = solv.removeElement(nums, val);
	cout << ans << endl;
	return 0;
}