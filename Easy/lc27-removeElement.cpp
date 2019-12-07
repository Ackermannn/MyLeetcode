#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
	int removeElement(vector<int>& nums, int val) {
		
		int i = 0, j =  0;
		for ( ; j < nums.size(); i++) {
			
			while (nums[j] == val)
			{
				j++;
				if (j < nums.size()) { 
					nums[i] = nums[j]; 
				}
				else break;
			}

		
		}
		return i;
	}
};
int main() {
	Solution solv;
	vector<int> nums = {1};
	int val = 1;
	int ans = solv.removeElement(nums, val);
	cout << ans << endl;
	return 0;
}

/*
[]
0

[1]
1

[3,3]
3
*/