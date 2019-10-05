#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
using namespace std;
class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		vector<vector<int>> v;
		int count = 0;
		for (auto x: nums){
			v.push_back({ x, count });
			count++;}
		sort(v.begin(), v.end());
		int i = 0, j = nums.size() - 1;
		while (true){
			if (v[i][0] + v[j][0] > target) j--;
			else if (v[i][0] + v[j][0] < target) i++;
			else{
				if (v[i][1] > v[j][1])
					return { v[j][1], v[i][1] };
				else
					return { v[i][1], v[j][1] };}}
		return{ 0,0 };
	}
};
int main()
{
	Solution s;
	vector<int> nums = { 3,2,3,7 },res;
	int target = 9;
	res = s.twoSum(nums, target);
	cout << res[0] << ',' << res[1] << endl;
	return 0;
}
