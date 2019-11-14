#include<iostream>
#include <vector>
using namespace std;
class Solution {
public:
	vector<vector<int>> permute(vector<int>& nums) {
		vector<vector<int>>* res = new vector<vector<int>>;
		get_left({}, nums, res);
		return *res;
	}
	void get_left(vector<int> offered, vector<int> candidate, vector<vector<int>>* res) {
		for (int i = 0; i < candidate.size(); i++) {
			offered.push_back(candidate[i]);
			vector<int> sub_candidate = candidate;
			sub_candidate.erase(sub_candidate.begin() + i);
			if (sub_candidate.empty() != 1) {
				get_left(offered, sub_candidate, res);
			}
			else {
				res->push_back(offered);
			}
			offered.pop_back();
		}


	};

};


int main() {
	vector<int> x = { 1,2,3,4 };
	
	Solution sol;
	auto res = sol.permute(x);
	return 0;
}