#include<iostream>
#include<vector>
#include <numeric>
using namespace std;
class Solution {
public:
	vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
		vector<vector<int>>* ans = new vector<vector<int>>; //堆
		recur(candidates, target, {}, ans);
		return *ans;

	}
	void recur(vector<int>& candidates, int target, vector<int> route, vector<vector<int>>* ans) {
		
		for (int i = 0; i < candidates.size(); i++) {
			int my_sum = 0;
			vector<int> temp_route = route;
			temp_route.push_back(candidates[i]);

			my_sum = accumulate(temp_route.begin(), temp_route.end(), 0); // 求route中的和
			
			if (my_sum < target) {
				vector<int> temp(candidates.begin() + i, candidates.end());
				recur(temp, target, temp_route, ans);
			}
			else if (my_sum == target) {
				(*ans).push_back(temp_route);

			}
		}
	


	}
};

int main() {
	Solution solv;
	vector<int> candidates = {2,3,6,7};
	int target = 7;
	auto ans = solv.combinationSum(candidates, target);
	for (auto x : ans) {
		for (auto i : x) {
			cout << i << ',';
		
		}
		cout << endl;
	}
	return 0;
}