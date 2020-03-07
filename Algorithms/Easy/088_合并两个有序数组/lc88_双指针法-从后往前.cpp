/*
* author: @Ackermannn
* creation time: 2019/11/18 13:48:00
* description: merge two ordered arrays
*/
// reference link:
// https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
#include<iostream>
#include<vector>
#include <algorithm>
using namespace std;
class Solution {
public:
	void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
		auto p = nums1.end(), p1 = nums1.begin() + m, p2 = nums2.end();
	
		while (p > nums1.begin() and p1 != nums1.begin() and  p2 != nums2.begin())
		{
			*(p-1) = max(*(p1-1), *(p2-1));
			if (*(p1-1) > * (p2-1)) p1--;
			else p2--;
			p--;
		}

		if (p1 == nums1.begin()) {
			while (p>nums1.begin())
			{
				*(p - 1) = *(p2 - 1);
				p2--;
				p--;
			}
		}


	}
};

int main() {
	Solution solv;
	vector<int> nums1 = { 1,2,3,0,0,0 }, nums2 = { 2,5,6 };
	int m = 3, n = 3;
	solv.merge(nums1, m, nums2, n);

	return 0;
}