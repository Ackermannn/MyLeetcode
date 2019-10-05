#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
	double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
		double res = 0;
		nums1.insert(nums1.end(),nums2.begin(),nums2.end());
		sort(nums1.begin(), nums1.end());
		//for (auto x : nums1) {
		//	cout << x << endl;
		//}
		int len = nums1.size();
		if (len % 2 == 0) res = double(nums1[len / 2] + nums1[len / 2 - 1]) / 2;
		else res = nums1[(len - 1) / 2];

		return res;
	}
};

int main() 
{
	Solution s;
	vector<int> num1, num2;
	num1 = {1,2 };
	num2 = { 3,4 };
	cout << s.findMedianSortedArrays(num1, num2) << endl;
	return 0;
}
