#include<iostream>
#include<vector>
#include<map>
using std::vector;
using std::cout;
using std::endl;
using std::map;

class Solution {
public:
	int singleNumber(vector<int>& nums) {
		map<int,int> m;
		for (int x : nums) {
			if (m.find(x) == m.end()) m[x] = 1;
			else if (m[x] == 1) m[x] = 2;
		}
		for (auto x : m) {
			if (x.second == 1) return x.first;
			
		}
		
	}
		// 异或法 
	int singleNumber2(vector<int>& nums)
	{
		int a = 0;
		for (int i : nums) {
			a ^= i;
		}		
		return a;
	}
};
int main() {
	Solution solu;
	vector<int> nums = { 2,2,1 };
	cout << solu.singleNumber(nums) << endl;
	return 0;

}
