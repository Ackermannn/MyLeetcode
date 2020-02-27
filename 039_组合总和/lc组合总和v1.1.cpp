#include<iostream>
#include<vector>
#include <numeric>
#include<algorithm>
using namespace std;
class Solution {
public:
	vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
		vector<vector<int>>* ans = new vector<vector<int>>; //堆
		sort(candidates.begin(), candidates.end());
		recur(candidates, target, {}, ans);
		return *ans;

	}
	void recur(vector<int>& candidates, int target, vector<int> route, vector<vector<int>>* ans) {
		
		for (int i = 0; i < candidates.size(); i++) {
			
			int new_target = target - candidates[i];
			vector<int> temp_route = route;
			temp_route.push_back(candidates[i]);

			if (new_target > 0) {
				vector<int> temp(candidates.begin() + i, candidates.end());
				recur(temp, new_target, temp_route, ans);
			}
			else if (new_target == 0) {
				(*ans).push_back(temp_route);

			}
			else
			{
				break;
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